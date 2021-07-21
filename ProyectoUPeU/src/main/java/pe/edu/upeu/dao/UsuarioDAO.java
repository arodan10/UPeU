package pe.edu.upeu.dao;

import java.io.Console;

import pe.edu.upeu.data.AppCrud;
import pe.edu.upeu.modelo.UsuarioTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.TecladoRead;
import pe.edu.upeu.util.UtilsX;

public class UsuarioDAO extends AppCrud{
    LeerArchivo lar;
    UsuarioTO usuTO;
    
    TecladoRead  tre=new TecladoRead();
    UtilsX ut=new UtilsX(); 
    
    public void registrarUsuario() {
        usuTO=new UsuarioTO();
        String usuario=tre.read("", "Ingrese un Usuario:").toLowerCase();
        if(validExist(usuario)){
            usuTO.setUsuario(usuario);
            usuTO.setPerfil(tre.read("", "Ingrese el perfil (ADMIN, VENDEDOR, CAJERO):").toUpperCase());
            lar=new LeerArchivo("Usuario.txt");
            usuTO.setIdUsuario(generarId(lar, 0, "U", 1));
            Console cons=System.console();
            System.out.println("Ingrese su clave:");
            char[] clave=cons.readPassword();
            usuTO.setClave(String.valueOf(clave));
            lar=new LeerArchivo("Usuario.txt");
            agregarContenido(lar, usuTO);
        }else{
            System.out.println("El usuario ya existe .....Pruebe con cntro usuario!!");
            registrarUsuario();
        }

    }
    public boolean eliminarUsuario() {
        ut.clearConsole();
        lar=new LeerArchivo("Usuario.txt");
        imprimirLista(listarContenido(lar));
        lar=new LeerArchivo("Usuario.txt");
        String idU=tre.read("", "Ingrese el Id del usuario que desea eliminar:");
        eliminarRegistros(lar, 0, idU);
        return false;
    }

    public boolean validExist(String usuario) {
        lar=new LeerArchivo("Usuario.txt");
        Object[][] data=buscarContenido(lar, 1, usuario);
        if (data!=null && data.length>0) {
            return false;
        }else{
            return true;
        }       
        
    }


    public boolean login(String usuario, char[] clave) {
        lar=new LeerArchivo("Usuario.txt");
        Object[][] data=buscarContenido(lar, 1, usuario);
        if (data!=null && data.length==1 && data[0][2].equals(String.valueOf(clave))) {
            return true;
        }
        return false;
    }
    

}
