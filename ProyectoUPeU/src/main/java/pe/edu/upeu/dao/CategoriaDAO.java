package pe.edu.upeu.dao;

import pe.edu.upeu.data.AppCrud;
import pe.edu.upeu.modelo.CategoriaTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.TecladoRead;
import pe.edu.upeu.util.UtilsX;

public class CategoriaDAO extends AppCrud{
   
    LeerArchivo lar;
    CategoriaTO catTO;
    
    TecladoRead tre=new TecladoRead();
    UtilsX ut=new UtilsX();

    public void registrarCategoria() {
        catTO=new CategoriaTO();
        lar=new LeerArchivo("Categoria.txt");
        catTO.setIdCateg(generarId(lar, 0, "C", 1)); 
        catTO.setNombre(tre.read("", "Ingrese nombre categoria:"));
        agregarContenido(lar, catTO);
    }
    
    public void reporteCategoria() {
        System.out.println("-------------Reporte de Categoria------------");
        lar=new LeerArchivo("Categoria.txt");
       Object[][] data=listarContenido(lar);
        String dataX="";
        ut.pintarLine('H',13);
        ut.pintarTextHeadBody('H', 3, "ID,Nombre"); 
        System.out.println("");
        ut.pintarLine('H',13);
       
       for (int i = 0; i < data.length; i++) {
           for (int j = 0; j < data[0].length; j++) {
               if(j==0){
                dataX+=""+data[i][j];
               }else{
                dataX+=","+data[i][j]; 
               }               
           }
           ut.pintarTextHeadBody('B', 3, dataX);  
           dataX="";
       }        
    } 

}
