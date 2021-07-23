package pe.edu.epeu.matrices;
public class Matrices {

    public void sumaMatrices(int[][] mA, int[][] mB) {
        int[][] mR=new int[mA.length][mA[0].length];

        for (int f = 0; f < mA.length; f++) {
            for (int c = 0; c < mA[0].length; c++) {
                mR[f][c]=mA[f][c]+mB[f][c];
            }            
        } 
        imprimirMatriz(mR);
    }
    public void imprimirMatriz(int[][] matriz) {
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length; c++) {
                System.out.print(matriz[f][c]+"\t");
            }
            System.out.println("");
        } 
    }   
    
    public void imprimirMatrizCadena(String[][] matriz) {
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length; c++) {
                if(matriz[f][c]!=null && !matriz[f][c].equals("")){
                    System.out.print(matriz[f][c]+"\t");
                }else{
                    System.out.print("\t");
                }                
            }
            System.out.println("");
        } 
    } 

    /*--------------------------------*/

    public void transformada12(int dimen, int numInit) {
        String[][] matriz=new String[dimen][dimen];// i = Fila; j=Columna
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <= (dimen-1)-i; j++) {
                matriz[i][(dimen-1)-j]=""+numInit;
                numInit++;
            }
        }
        imprimirMatrizCadena(matriz);        
    }

    public void transformada01(int dimen, int valorInicial) {
        int item=0;
        int[][] matriz=new int[dimen][dimen];
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum< matriz.length; colum++) {
                if(colum<dimen-fila){
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

    public void transformada18(int dimen, int numInit) {
        String[][] matriz=new String[dimen][dimen];// i = Fila; j=Columna
        for (int j = matriz [0]. length -1 ; j >=0; j-- ) {
            for (int i = 0; i < (matriz.length)-j; i++) {
                matriz[i][j]=""+numInit;
                numInit++;
            }
        }
        imprimirMatrizCadena(matriz);
    }

    public void transformada21(int dimen, int numInit) {
        String[][] matriz=new String[dimen][dimen];// i = Fila; j=Columna
        for (int j = 0; j < matriz[0].length; j++) {
            if (j%2==0) {
                for (int i = 0; i < matriz.length; i++) {
                    matriz[i][j]=""+numInit;
                    numInit++;
                }
            } else {
                for (int i = matriz.length-1; i >=0 ; i--) {
                    matriz[i][j]=""+numInit;
                    numInit++;
                }                
            } 
        }
        imprimirMatrizCadena(matriz);        
    }

    public void transformada28(int dimen, int numInit) {
        String[][] matriz=new String[dimen][dimen];//j=filas, i=columnas
        for (int j = matriz.length-1; j >=0; j--) {
            if(j%2==0){
                for (int i = 0; i < (matriz[0].length); i++) {            
                    matriz[j][i]=""+numInit;
                    numInit++;
                }
            }else{
                for (int i = matriz[0].length-1; i >=0 ; i--) {            
                    matriz[j][i]=""+numInit;
                    numInit++;
                }
            }
        }
        imprimirMatrizCadena(matriz);
    }

    public void transformada05(int dimen, int valInit) {
        String[][] matriz=new String[dimen][dimen];// i =filas, j=columnas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <= i; j++) {
                matriz[i][(dimen-1)-j]=""+valInit;
                valInit++;
            }
        }
        imprimirMatrizCadena(matriz);  
    }

    public void transformada13(int dimen, int valInit) {
        String[][] matriz=new String[dimen][dimen];// i =filas, j=columnas
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i <= (dimen-1)-j; i++) {
                matriz[i][j]=""+valInit;
                valInit++;
            }
        }         
        imprimirMatrizCadena(matriz);  
    }
    
    public void transformada24(int dimen, int valInit) {
        String[][] matriz=new String[dimen][dimen];// i =filas, j=columnas
        for (int j = matriz[0].length-1; j>=0 ; j--) {
            if(j%2==0){
                for (int i =  matriz.length-1; i >=0; i--) {
                    matriz[i][j]=""+valInit;
                    valInit++;
                }                
            }else{
                for (int i = 0; i < matriz.length; i++) {
                    matriz[i][j]=""+valInit;
                    valInit++;
                }
            }
        }
        imprimirMatrizCadena(matriz);  
    }

    public void transformada02(int dimension, int valorElem) {
        String[][] matriz=new String[dimension][dimension];
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length; c++) {     
                if (c<dimension-f) {
                    matriz[f][c]=""+(valorElem+(f+c)*(f+c+1)/2 + c); 
                }else{
                    matriz[f][c]="";
                }                
            }
        }
        imprimirMatrizCadena(matriz);  
    }

    public void transformada27(int dimen, int valInit) {
        String[][] matriz=new String[dimen][dimen];
        for (int j = matriz[0].length-1; j>=0 ; j--) {
            if(j%2==0){
                for (int i =  matriz.length-1; i >=0; i--) {
                    matriz[j][i]=""+valInit;
                    valInit++;
                }                
            }else{
                for (int i = 0; i < matriz.length; i++) {
                    matriz[j][i]=""+valInit;
                    valInit++;
                }
            }
        }
        imprimirMatrizCadena(matriz);
    }

   


    public static void main(String[] args) {
        Matrices transf=new Matrices();
        transf.transformada12(5, 0);
        System.out.println("");
        transf.transformada01(5, 0);
        System.out.println("");  
        transf.transformada18(5, 0);
        System.out.println("");  
        transf.transformada21(5, 0);
        System.out.println(""); 
        transf.transformada28(5, 0);
        System.out.println("");   
        transf.transformada05(5, 0);
        System.out.println("");  
        transf.transformada13(5, 0);
        System.out.println("");
        transf.transformada24(5, 0);
        System.out.println("");  
        transf.transformada02(5, 0);
        System.out.println(""); 
        transf.transformada27(5, 0);
        System.out.println(""); 
               
    }
    
}