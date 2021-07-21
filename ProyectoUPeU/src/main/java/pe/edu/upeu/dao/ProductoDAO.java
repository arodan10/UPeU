package pe.edu.upeu.dao;

import pe.edu.upeu.data.AppCrud;
import pe.edu.upeu.modelo.CategoriaTO;
import pe.edu.upeu.modelo.ProductoTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.TecladoRead;
import pe.edu.upeu.util.UtilsX;

public class ProductoDAO extends AppCrud{
    LeerArchivo  lar;
    CategoriaTO catTO;
    ProductoTO proTO;
    
    TecladoRead tre=new TecladoRead();
    UtilsX ut=new UtilsX();
    
    public void registrarProducto() {
        System.out.println("******Regisrto de Productos*******");
        mostrarCategoria();
        proTO=new ProductoTO();
        proTO.setIdCateg(tre.read("", "Seleccion el ID categoria:"));        
        lar=new LeerArchivo("Producto.txt");
        proTO.setIdProducto(generarId(lar, 0, "P", 1));
        proTO.setNombre(tre.read("", "Ingrese el nombre del Producto:"));
        proTO.setUnidadMed(tre.read("","Ingrese Unidad de Medidad:"));
        proTO.setPreUnitario(tre.read(0.0, "Ingrese el Precio Unitario:"));
        proTO.setPorcentUtil(tre.read(0.0, "Ingrese el % de Utilidad:"));
        proTO.setStock(tre.read(0.0, "Ingrese el Stock:"));
        lar=new LeerArchivo("Producto.txt");
        agregarContenido(lar, proTO);
    }

    public void mostrarCategoria() {
        lar=new LeerArchivo("Categoria.txt");
        Object[][] data=listarContenido(lar);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i][0]+"="+data[i][1]+", ");
        }
        System.out.println("");
    }
    public void reporteProducto() {
        System.out.println("-------------Reporte de Categoria------------");
        lar=new LeerArchivo("Producto.txt");
       Object[][] data=listarContenido(lar);
        String dataX="";
        ut.pintarLine('H',35);
        ut.pintarTextHeadBody('H', 2, "ID,Noombre,U.Medida,IdCat,P.Unit,%.Util,Stock"); 
        System.out.println("");
        ut.pintarLine('H',35);
       
       for (int i = 0; i < data.length; i++) {
           for (int j = 0; j < data[0].length; j++) {
               if(j==0){
                dataX+=""+data[i][j];
               }else{
                dataX+=","+data[i][j]; 
               }               
           }
           ut.pintarTextHeadBody('B', 2, dataX);  
           dataX="";
       }            
    }
    
}
