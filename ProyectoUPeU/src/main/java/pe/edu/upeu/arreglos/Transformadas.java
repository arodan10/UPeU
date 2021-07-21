package pe.edu.upeu.arreglos;

public class Transformadas {

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

    public void transformada01(int dimen, int numInit) {
        String[][] matriz=new String[dimen][dimen];//i=filas, j=columnas
        for (int i = 0; i < matriz.length; i++) {
             for (int j = 0; j < matriz[0].length; j++) {
                if(j<dimen-i){
                    matriz[i][j]=""+(numInit+(i+j)*(i+j+1)/2 + i);
                }                
             }
        }
        imprimirMatrizCadena(matriz);
    }

    public void transformada05(int dimen, int numInit) {
        String[][] matriz=new String[dimen][dimen];//i=filas, j=columnas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <= i; j++) {
                matriz[i][(dimen-1)-j]=""+numInit;
                numInit++;//numInit+=1; numInit=numInit+1
            }
        }
        imprimirMatrizCadena(matriz);
    }

    public void transformada18(int dimen, int numInit) {
        String[][] matriz=new String[dimen][dimen];//i=filas, j=columnas
        for (int j = matriz[0].length-1; j >=0; j--) {
            for (int i = 0; i < (matriz.length)-j; i++) {            
                matriz[i][j]=""+numInit;
                numInit++;//numInit+=1; numInit=numInit+1
            }
        }
        imprimirMatrizCadena(matriz);
    }

    public void transformada21(int dimen, int numInit) {
        String[][] matriz=new String[dimen][dimen];//i=filas, j=columnas
        for (int j = 0; j <matriz[0].length; j++) {
            if(j%2==0){
                for (int i = 0; i < (matriz.length); i++) {            
                    matriz[i][j]=""+numInit;
                    numInit++;
                }
            }else{
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


    public static void main(String[] args) {
        Transformadas transf=new Transformadas();
        transf.transformada01(5, 0);
        System.out.println("");
        transf.transformada05(5, 0);
        System.out.println("");
        transf.transformada18(5, 0);
        System.out.println("");
        transf.transformada21(5, 0);       
        System.out.println("");
        transf.transformada28(5, 0);             
      /*  int mA[][]={
            {7,	10,	1},
            {5,	6,	5},
            {4,	3,	7}           
            };
        int mB[][]={
            {9,	10,	7},
            {1,	1,	1},
            {6,	10,	5}           
            }; 
        
        tansf.sumaMatrices(mA, mB);  */  
    }
    
}