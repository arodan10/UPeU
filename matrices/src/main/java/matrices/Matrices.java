package matrices;
public class Matrices {
    
    
    
    public void transformada01(int dimension, int valorInicial) {
        int item=0;
        int[][] matriz=new int[dimension][dimension];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum< matriz.length; colum++) {
                if(colum<dimension-fila){
                item=valorInicial+(fila+colum)*(fila+colum+1)/2 + fila; 
                matriz[fila][colum]=item;
                }
            }
        }        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if(j<matriz.length-i){
                System.out.print(matriz[i][j]+"\t");
                }else{
                System.out.print("\t");
                }
            }
            System.out.println("");
        }          
    }
    /*public static void main(String[] args) {    
        Matrices tm=new Matrices();  
        tm.transformada01(10, 1);  
    } */  

    public void transformada12(int dimen, int numInit) {
        String[][] matriz=new String[dimen][dimen];// i = Fila; j=Columna
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <= (dimen-1)-i; j++) {
                matriz[i][(dimen-1)-j]=""+numInit;
                numInit++;
            }
        }
        Transformadas tm=new Transformadas();  
        tm.imprimirContenidoMatrizCadena(matriz);        
     } 
    
    

    public static void main(String[] args) {    
        Matrices tm=new Matrices();  
        tm.transformada12(5, 1);     
}
}
