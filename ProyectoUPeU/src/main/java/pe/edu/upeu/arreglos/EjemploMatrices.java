package pe.edu.upeu.arreglos;

import java.util.Scanner;

public class EjemploMatrices{

    public void conceptosMatrices() {
        //defenir una matriz con datos predefinidos
        int [][]maX={
                    {5,6,6},
                    {5,6,2},
                    {5,12,2},
                    {5,6,2}
                    };
        //obtener el tamanho de la fila de la Matriz maX
        System.out.println("Tamanho en fila de Matriz maX="+maX.length);          
        //obtener el tamanho de la columna de la Matriz maX
        System.out.println("Tamanho en columnas de Matriz maX="+maX[0].length); 
        //obteniendo el valor/elemento 12 de la matriz maX
        System.out.println("Mostrar el valor 12 de la matriz maX="+maX[2][1]);
        //Cambiar el elemento 12 de la matriz maX por 16
        maX[2][1]=16;
        Scanner sc=new Scanner(System.in);
       /* System.out.println("Ingrese un valor en los indices 2,2");
        maX[2][2]=sc.nextInt();

        System.out.println("Defina el indice para fila:");
        int iFx=sc.nextInt(); 
        System.out.println("Defina el indice para columna:");
        int iCx=sc.nextInt(); 
        System.out.println("Ingrese un valor en los indices "+iFx+", "+iCx+":");
        maX[iFx][iCx]=sc.nextInt();    */    

        imprimirMatriz(maX);

        //defenir matrices sin dimensiones
        int[][]  matrizN;
        //definiendo dimensiones a una matriz
        System.out.println("Ingrese la dimension en fila para la MatrizN=");
        int inFi=sc.nextInt();
        System.out.println("Ingrese la dimension en columna para la MatrizN=");
        int inCo=sc.nextInt();
        matrizN=new int[inFi][inCo]; 
        int vi=0;
        //Rellenando una matriz con una serie de numeros
        for (int f = 0; f < matrizN.length; f++) {
            for (int c = 0; c < matrizN[0].length; c++) {
                System.out.println("Ingrese un valor en matrizN["+f+"]["+c+"]:=");
                matrizN[f][c]=sc.nextInt();
                vi=vi+2;
            }            
        }      
        System.out.println("la nueva matrizN es de: "+matrizN.length+"x"+matrizN[0].length);
        imprimirMatriz(matrizN);    

    }

    public void imprimirMatriz(int[][] matriz) {
       for (int f = 0; f < matriz.length; f++) {
           for (int c = 0; c < matriz[0].length; c++) {
               System.out.print(matriz[f][c]+"\t");
           }
           System.out.println("");
       } 
    }

    public void imprimirMatriz(Object[][] matriz) {
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length; c++) {
                System.out.print(matriz[f][c]+"\t");
            }
            System.out.println("");
        } 
     }    

    public void reporteProductos() {
        Object[][] mProductos={
                    {"P0001","Manzana",	3.5, 50 },
                    {"P0002","Pera",	4.6, 20 },
                    {"P0003","Naranja",	2, 2 }
                    };
        imprimirMatriz(mProductos);
    }


    public static void main(String[] args) {
       EjemploMatrices objEM=new EjemploMatrices(); 
       //objEM.conceptosMatrices();
       objEM.reporteProductos();
    }

}