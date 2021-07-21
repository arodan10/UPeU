package pe.edu.upeu.arreglos;

import java.util.Scanner;

/**
 * EjemploVectores
 */
public class EjemploVectores {


    public static void conceptosVectores() {
        //Denifinir un vector
        int[] vectorX;
        int[] vectorY;
        //Definir tamanho de una vector
        vectorX=new int[2];
        vectorX[0]=20;//[0] indice/posicion
        vectorX[1]=8;//[1] indice/posicion
        //vectorX[0]=40;//[0] indice/posicion
        //15-17   int[] vectorX={20,8};

        //vectorX[2]=5;
        System.out.println("Imprimiento valores del vector");
        System.out.println(vectorX[0]);//imprimeinto valor o elemento del vector vectorX[0]
        //Asignando valores directos a un vector
        int[] vA={12,2,3,4,5,6,7,8,9,10};
        int[] vB=new int[]{12,2,3,4,5,6,7,8,9,10, 45, 16, 32};
        //conocer el tamanho de un vector
        System.out.println("Tamanho/longitud del vector vB="+vB.length);        
    }


    //Crea un array de 10 posiciones de números con valores pedidos por teclado. 
    //Muestra por consola el indice y el valor al que corresponde. 
    //Haz dos métodos, uno para rellenar valores y otro para mostrar.


    public static void mostrarValores(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println("v["+i+"]= "+vector[i]+"   Su indice es: "+i+" Su valor es:"+vector[i]);        
        }
    }

    public static int[] rellenarVector(int tv) {
       int[] vector=new int[tv]; 
       Scanner cs=new Scanner(System.in);
        for (int i = 0; i < vector.length; i++) {
            System.out.print("ingrese el valor del indice "+i+":");
            vector[i]=cs.nextInt();
            System.out.println("");
        }
        mostrarValores(vector);
        return vector;
    }


    public static void masEjemploVectores() {
        double[] vectorA={12,15.3,6,2.5,3.6,6.2};
        System.out.println("Tamanho vectorA es:"+vectorA.length);
        String[] vectorB={"A",	"A",	"A",	"A",	"B",	"A",	"2.5",	"A","A","5" };
        System.out.println("Tamanho vectorB es:"+vectorB.length);
        Object[] vectorX={"A",	1,	2.3,	"D",	"E",	"F",	11,	"H",	"I",false,	'T'};
        System.out.println("Tamanho vectorX es:"+vectorX.length);

        char[] vecX={'+',	'/',	'*',	'-', 'A', '2'};
        System.out.println("Tamanho vecX es:"+vecX.length);

    }

    public static void main(String[] args) {
        conceptosVectores();
        System.out.println("Ejercicio 01");
        rellenarVector(10);
        masEjemploVectores();
    }

}