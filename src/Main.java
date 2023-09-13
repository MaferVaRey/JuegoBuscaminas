import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {

        //Solo general el nivel 1 (Tablero 9 x 9 y 10 bombas)

        /**Declaración de variables para el tamaño de la matriz
         * Declaración de matriz
         * Declaración de Scanner y de Random
         */
        Scanner sc = new Scanner(System.in);
        int filas = 9, columnas = 9;
        int tablero[][] = new int[filas][columnas];
        Random random = new Random();

        /**FOR 1: Va de 0 a menor estricto que 10 para poner las 10, en función de las 10
         * bombas del nivel 1.
         * Se declaran dos enteros para que guarden dos valores aleatorios
         * Una variable se tomará como la posición en y y la otra como posición en x
         * IF dentro del FOR1: evalúa si la posición
         * de las variables aleatorias declaradas anteriormente
         * ya fue usada previamente
         * Si no fue usada: asignará el valor 9 a ese espacio
         * Si ya fue usada: restará 1 al valor de i para que repita el ciclo desde donde estaba
         * Asegurando así que las 10 posiciones necesarias se usen.
         */

        for(int i = 0; i < 10; i++){
            int RandColumna = random.nextInt(filas);
            int RandFila = random.nextInt(columnas);

            if (tablero[RandFila][RandColumna] == 0){
                tablero[RandFila][RandColumna] = 9;
            }
            else i -= 1;
        }

        /**
         * Imprime la matriz
         */
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        /**
         * Se usó el número 9 porque a la hora de generar losdemás números,
         * El más alto que puede existir es el 8, que son las 8 posiciones que rodean a la comba
         * UwU
         */
    }
}