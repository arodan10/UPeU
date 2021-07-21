package pe.edu.upeu.app;

import pe.edu.upeu.dao.CategoriaDAO;
import pe.edu.upeu.dao.ClienteDAO;
import pe.edu.upeu.dao.ProductoDAO;
import pe.edu.upeu.dao.UsuarioDAO;
import pe.edu.upeu.dao.VentaDAO;
import pe.edu.upeu.gui.MainGUI;
import pe.edu.upeu.util.TecladoRead;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.Color.*;

public class App{
    static Ansi color=new Ansi();

    public static void menuMain() {
        String mensaje="Seleccion el algoritmo que desea probar:"+
        "\n1=Registrar Categoria"+
        "\n11=Reportar Categoria"+
        "\n2=Registrar Producto"+
        "\n21=Reportar Producto"+
        "\n3=Registrar Usuario"+
        "\n31=Eliminar Usuario"+
        "\n4=Registrar Venta"+
        "\n41=Reporte Ventas por fechas"+
        "\n5=registrarCliente"+
        "\n0=Salir del sistema"
        ;     
        CategoriaDAO daoCat;   
        UsuarioDAO daoUso;
        ProductoDAO proDao;
        VentaDAO ventDao;
        ClienteDAO cliDAO;
        TecladoRead tre=new TecladoRead();
        int opciones=tre.read(0, mensaje);         
        do {
            switch (opciones) {
                case 1: daoCat=new CategoriaDAO(); daoCat.registrarCategoria(); break;
                case 11: daoCat=new CategoriaDAO(); daoCat.reporteCategoria(); break;
                case 2: proDao=new ProductoDAO(); proDao.registrarProducto(); break;
                case 21: proDao=new ProductoDAO(); proDao.reporteProducto(); break;
                case 3: daoUso=new UsuarioDAO(); daoUso.registrarUsuario();  break; 
                case 31:daoUso=new UsuarioDAO(); daoUso.eliminarUsuario(); break;    
                case 4: ventDao=new VentaDAO(); ventDao.registroVentaGeneral(); break;   
                case 41: ventDao=new VentaDAO(); ventDao.reportarVentasRangoFecha(); break;
                case 5: cliDAO=new ClienteDAO(); cliDAO.RegistrarCliente(); break;   
                default:System.out.println("Opcion no existe"); break;
            }       
                 
            if (opciones!=0){ 
            System.out.println();
            String continuar=tre.read("","Desea continuar en el sistemas? SI=S/NO=N ")
            .toUpperCase();
            if(continuar.charAt(0)=='S'){
                opciones=tre.read(0, mensaje); 
            }else{ opciones=0;}            
            }

        }while (opciones!=0);
        
    }

    public static void validAccessSystem() {
        TecladoRead tr=new TecladoRead();
        UsuarioDAO uDao=new UsuarioDAO();
        String usuario=tr.read("", "Ingrese su Usuario:");
        System.out.println("Ingres su clave:");
        char[] clave=System.console().readPassword();
        if (uDao.login(usuario,clave)) {
            menuMain();
        } else {
            System.out.println(color.fgRed().a("Error de autentifiacion.......Intetente nuevamente!!").reset());
            validAccessSystem();
        }
    }


    public static void main( String[] args ){
        AnsiConsole.systemInstall();  
        Ansi color=new Ansi();
        System.out.println(color.bgBright(WHITE).fgBlack().a("***************Ingreso al Sistema***************").reset());              
        validAccessSystem();        
    }
}
