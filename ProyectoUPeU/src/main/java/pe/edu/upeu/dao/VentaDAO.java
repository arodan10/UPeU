package pe.edu.upeu.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import pe.edu.upeu.data.AppCrud;
import pe.edu.upeu.modelo.ProductoTO;
import pe.edu.upeu.modelo.VentaDetalleTO;
import pe.edu.upeu.modelo.VentaTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.TecladoRead;
import pe.edu.upeu.util.UtilsX;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.Color.*;

public class VentaDAO extends AppCrud{
    LeerArchivo lar;
    TecladoRead tre=new TecladoRead();
    UtilsX ut=new UtilsX();
    ProductoTO prodTO;
    VentaTO ventTO;
    VentaDetalleTO vdTO;
    SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    SimpleDateFormat formatoFecha=new SimpleDateFormat("dd-MM-yyyy");        

    public void registroVentaGeneral() {
        VentaTO vTO=crearVenta();
        String continuar="SI";
        double precioTotalX=0;
        do {
            VentaDetalleTO vdTOX=carritoVenta(vTO);
            precioTotalX=precioTotalX+vdTOX.getPrecioTotal();
            continuar=tre.read("", "Desea algun producto mas? (SI=S/NO=N):").toUpperCase();
        } while (continuar.charAt(0)=='S');
        vTO.setPrecioTotal(precioTotalX);
        vTO.setNetoTotal(precioTotalX/1.18);
        vTO.setIgv(vTO.getNetoTotal()*0.18);
        
        ut.pintarLine('H', 20);        
        System.out.println("Precio Neto S/.:"+        
        vTO.getNetoTotal()+" | IGV S/.: "+vTO.getIgv()+" | Total a pagar S/."+ 
        vTO.getPrecioTotal());        
        ut.pintarLine('H', 20);        
    
        lar=new LeerArchivo("Venta.txt");
        editarRegistro(lar, 0, vTO.getIdVenta(), vTO);
    }

    public VentaTO crearVenta() {
        lar=new LeerArchivo("Venta.txt");
        ventTO=new VentaTO();
        ventTO.setIdVenta(generarId(lar, 0, "V", 1));
        ventTO.setIdDni(tre.read("", "Ingrese el DNI del cliente:"));
        ventTO.setFechaVenta(formato.format(new Date()));
        ventTO.setIgv(0.0);
        ventTO.setNetoTotal(0.0);
        ventTO.setPrecioTotal(0.0);
        lar=new LeerArchivo("Venta.txt");
        agregarContenido(lar, ventTO);
        return ventTO;
    }

    public VentaDetalleTO carritoVenta(VentaTO vTO) {
        ut.clearConsole();
        System.out.println("*************Agregar Productos a carrito de ventas***********");
        mostrarProductos();
        vdTO=new VentaDetalleTO();
        vdTO.setIdProducto(tre.read("", "Ingrese el ID del Producto:"));
        vdTO.setIdVenta(vTO.getIdVenta());
        lar=new LeerArchivo("VentaDetalle.txt");
        vdTO.setIdVentaDetalle(generarId(lar, 0, "DV", 2));
        LeerArchivo larX=new LeerArchivo("Producto.txt");
        Object[][] dataP=buscarContenido(larX, 0,vdTO.getIdProducto());
        double porcentUt=Double.parseDouble(String.valueOf(dataP[0][5]));
        double pUnit=Double.parseDouble(String.valueOf(dataP[0][4]));
        vdTO.setPorcentUtil(porcentUt);
        vdTO.setPrecioUnit(pUnit+pUnit*porcentUt);
        vdTO.setCantiad(tre.read(0.0, "Ingrese cantidad:"));
        vdTO.setPrecioTotal(vdTO.getCantiad()*vdTO.getPrecioUnit());
        lar=new LeerArchivo("VentaDetalle.txt");
        agregarContenido(lar, vdTO);
        restarstcok(vdTO.getCantiad(),dataP);
        return vdTO;
    }

    public void restarstcok(double cantidad,Object[][] stock){
        lar=new LeerArchivo("Producto.txt");
        ProductoTO stoxk =new ProductoTO(); 
        stoxk.setIdProducto(stock[0][0].toString());
        stoxk.setStock(Double.parseDouble(stock[0][6].toString())- cantidad);
        editarRegistro(lar, 0, stoxk.getIdProducto(),stoxk);
    }

    public void mostrarProductos() {
        lar=new LeerArchivo("Producto.txt");
        Object[][] dataP=listarContenido(lar);
        for (int i = 0; i < dataP.length; i++) {            
            System.out.print(dataP[i][0]+"="+dataP[i][1]+"(P.Unit S/.:"+
            dataP[i][4]+", Stock:"+dataP[i][6]+"), ");
        }
        System.out.println("");
    }

    public void reportarVentasRangoFecha(){
        lar=new LeerArchivo("Venta.txt");
        Ansi color=new Ansi();
        System.out.println("*******************Reporte de ventas por fechas*******************");
        String fechaInit=tre.read("", "Ingrese la fecha de Inicio (dd-MM-yyyy):");
        String fechaFin=tre.read("", "Ingrese fecha final (dd-MM-yyyy):");
        Object[][] dataV=listarContenido(lar);
        int cantidadFi=0;
        try {
            for (int i = 0; i < dataV.length; i++) {
                String[] dataFechaV=String.valueOf(dataV[i][2]).split(" ");
                if ((formatoFecha.parse(dataFechaV[0].toString()).after(formatoFecha.parse(fechaInit)) || 
                    dataFechaV[0].equals(fechaInit))   && (
                        formatoFecha.parse(dataFechaV[0].toString()).before(formatoFecha.parse(fechaFin)) || 
                    dataFechaV[0].equals(fechaFin)
                    )) {
                        cantidadFi++;
                }
            }
            System.out.println("Cantidad:"+cantidadFi);
            Object[][] dataRealRF=new Object[cantidadFi][dataV[0].length];
            cantidadFi=0;
            double netoTotalX=0, igvX=0, precioTotalX=0;

            for (int i = 0; i < dataV.length; i++) {
                String[] dataFechaV=String.valueOf(dataV[i][2]).split(" ");
                if ((formatoFecha.parse(dataFechaV[0].toString()).after(formatoFecha.parse(fechaInit)) || 
                    dataFechaV[0].equals(fechaInit))   && (
                        formatoFecha.parse(dataFechaV[0].toString()).before(formatoFecha.parse(fechaFin)) || 
                    dataFechaV[0].equals(fechaFin)
                    )) {
                        for (int j = 0; j < dataV[0].length; j++) {
                            dataRealRF[cantidadFi][j]=dataV[i][j];   
                            if (j==3) { netoTotalX=netoTotalX+Double.parseDouble(dataV[i][j].toString()); }
                            if (j==4) { igvX=igvX+Double.parseDouble(dataV[i][j].toString()); }
                            if (j==5) { precioTotalX=precioTotalX+Double.parseDouble(dataV[i][j].toString()); }
                        }
                        cantidadFi++;
                }
            }

            ut.clearConsole();
            System.out.println("**********Reporte de Ventas**********");
            System.out.println("--------Entre "+fechaInit+" a "+fechaFin+"------------");
            ut.pintarLine('H', 40);         
            ut.pintarTextHeadBody('H', 3, "ID,DNI,F.Venta,Neto T. S/.,IGV S/.,P.Total S/.");              
            System.out.println(""); 
            ut.pintarLine('H', 40);            
            for (Object[] objects : dataRealRF) {
                String datacontent=""+objects[0]+","+objects[1]+","+objects[2]+","+
                objects[3]+","+objects[4]+","+objects[5];
                ut.pintarTextHeadBody('B', 3, datacontent);
            }  

            ut.pintarLine('H', 40);
            System.out.println(color.render("Resumen: @|red Neto Total:S/. |@ @|green "+(Math.round(netoTotalX*100.0)/100.0)+
            "|@ | @|red IGV: S/.|@ @|green "+(Math.round(igvX*100.0)/100.0)+"|@  | @|red Monto total: S/. |@ @|green "+
            (Math.round(precioTotalX*100.0)/100.0)+"|@"));
            ut.pintarLine('H', 40);
            
        } catch (Exception e) {
            System.out.println("Error-------"+e.getMessage());
        }

    }
    

}
