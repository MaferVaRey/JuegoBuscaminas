import java.util.Scanner;
import java.util.Random;
public class Main {
    static int filas = 9, columnas = 9;
    static int[][] tablero = new int[filas][columnas];
    public static void main(String[] args) {
        GeneracionDeTablero(tablero);

    }
    public static int GeneracionDeTablero(int[][]tablero){
        //Solo general el nivel 1 (Tablero 9 x 9 y 10 bombas)

        /**Declaración de variables para el tamaño de la matriz
         * Declaración de matriz
         * Declaración de Scanner y de Random
         */
        Scanner sc = new Scanner(System.in);
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

        /**FOR 2:
         * el primer y segundo for es para recorrer la matris por filas (el for de arriba) y colomnas (el for anidado)
         * el primer if evalua la posiciion, si hay un 9 procedse a sumar 1 a todas las posiciones adyacentes (menos las que ya tienen 9)
         * devido a que 9 es la bombastic
         * en el caso en el que la bomba este en alguna de las paredes de la matriz (incluyendo esquinas)
         * va a pasar por una cadena de if que evalua cual es el caso y se salta la posiciones que esten por fuera de la matriz
         */

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == 9) {
                    if (i - 1 < 0) {
                        if (j - 1 < 0) {
                            if(tablero[i + 1][j] != 9)
                                tablero[i + 1][j] += 1;
                            if (tablero[i + 1][j + 1] != 9)
                                tablero[i + 1][j + 1]+= 1;
                            if (tablero[i][j + 1] != 9)
                                tablero[i][j + 1]+= 1;
                        } else if (j + 1 > columnas - 1) {
                            if (tablero[i + 1][j] != 9)
                                tablero[i + 1][j]+= 1;
                            if (tablero[i + 1][j - 1] != 9)
                                tablero[i + 1][j - 1]+= 1;
                            if (tablero[i][j - 1] !=9)
                                tablero[i][j - 1]+= 1;
                        } else {
                            if (tablero[i + 1][j] != 9)
                                tablero[i + 1][j]+= 1;
                            if (tablero[i + 1][j + 1] !=9)
                                tablero[i + 1][j + 1]+= 1;
                            if (tablero[i + 1][j - 1] !=9)
                                tablero[i + 1][j - 1]+= 1;
                            if (tablero[i][j + 1] != 9)
                                tablero[i][j + 1]+= 1;
                            if (tablero[i][j - 1] != 9)
                                tablero[i][j - 1]+= 1;
                        }
                    } else if (i + 1 > filas - 1) {
                        if (j - 1 < 0) {
                            if (tablero[i - 1][j] !=9)
                                tablero[i - 1][j]+= 1;
                            if (tablero[i - 1][j + 1] !=9)
                                tablero[i - 1][j + 1]+= 1;
                            if (tablero[i][j + 1] !=9)
                                tablero[i][j + 1]+= 1;
                        } else if (j + 1 > columnas - 1) {
                            if (tablero[i - 1][j] != 9)
                                tablero[i - 1][j]+= 1;
                            if (tablero[i - 1][j - 1] !=9)
                                tablero[i - 1][j - 1]+= 1;
                            if (tablero[i][j - 1] !=9)
                                tablero[i][j - 1]+= 1;
                        } else {
                            if (tablero[i - 1][j] != 9)
                                tablero[i - 1][j]+= 1;
                            if (tablero[i - 1][j + 1] !=9)
                                tablero[i - 1][j + 1]+= 1;
                            if (tablero[i - 1][j - 1] != 9)
                                tablero[i - 1][j - 1]+= 1;
                            if (tablero[i][j + 1] != 9)
                                tablero[i][j + 1]+= 1;
                            if (tablero[i][j - 1] != 9)
                                tablero[i][j - 1]+= 1;
                        }
                    } else if (j - 1 < 0) {
                        if (i - 1 < 0) {
                            if (tablero[i + 1][j] != 9)
                                tablero[i + 1][j]+= 1;
                            if (tablero[i + 1][j + 1] !=9)
                                tablero[i + 1][j + 1]+= 1;
                            if (tablero[i][j + 1] != 9)
                                tablero[i][j + 1]+= 1;
                        } else if (i + 1 > columnas - 1) {
                            if (tablero[i - 1][j] != 9)
                                tablero[i - 1][j]+= 1;
                            if (tablero[i - 1][j + 1] !=9)
                                tablero[i - 1][j + 1] +=1;
                            if (tablero[i][j + 1] !=9)
                                tablero[i][j + 1] += 1;
                        } else {
                            if (tablero[i + 1][j] !=9)
                                tablero[i + 1][j] +=1;
                            if (tablero[i + 1][j + 1] !=9)
                                tablero[i + 1][j + 1] +=1;
                            if (tablero[i - 1][j] !=9)
                                tablero[i - 1][j] += 1;
                            if (tablero[i - 1][j + 1] != 9)
                                tablero[i - 1][j + 1] += 1;
                            if (tablero[i - 1][j + 1] !=9)
                                tablero[i - 1][j + 1] += 1;
                            if (tablero[i][j + 1] != 9)
                                tablero[i][j + 1] += 1;
                        }
                    } else if (j + 1 > columnas - 1) {
                        if (i - 1 < 0) {
                            if (tablero[i + 1][j] != 9)
                                tablero[i + 1][j] += 1;
                            if (tablero[i + 1][j - 1] != 9)
                                tablero[i][j - 1] += 1;
                        } else if (i + 1 > columnas - 1) {
                            if (tablero[i - 1][j] != 9)
                                tablero[i - 1][j - 1] += 1;
                            if (tablero[i][j - 1] !=9)
                                tablero[i][j - 1] += 1;
                        } else {
                            if (tablero[i + 1][j] !=9)
                                tablero[i + 1][j] += 1;
                            if (tablero[i + 1][j - 1] != 9)
                                tablero[i + 1][j - 1] +=1;
                            if (tablero[i - 1][j] != 9)
                                tablero[i - 1][j] += 1;
                            if (tablero[i - 1][j - 1] != 9)
                                tablero[i - 1][j - 1] +=1;
                            if (tablero[i][j - 1] != 9)
                                tablero[i][j - 1] += 1;
                        }
                    } else {
                        if (tablero[i + 1][j] != 9)
                            tablero[i + 1][j] += 1;
                        if (tablero[i + 1][j + 1] != 9)
                            tablero[i + 1][j + 1] += 1;
                        if (tablero[i + 1][j - 1] != 9)
                            tablero[i + 1][j - 1] += 1;
                        if (tablero[i - 1][j] != 9)
                            tablero[i - 1][j] += 1;
                        if (tablero[i - 1][j + 1] != 9)
                            tablero[i - 1][j + 1] += 1;
                        if (tablero[i - 1][j - 1] != 9)
                            tablero[i - 1][j - 1] += 1;
                        if (tablero[i][j + 1] != 9)
                            tablero[i][j + 1] += 1;
                        if (tablero[i][j - 1] != 9)
                            tablero[i][j - 1] += 1;
                    }
                }
            }
        }
        /**
         * Se usó el número 9 porque a la hora de generar los demás números,
         * el más alto que puede existir es el 8, que son las 8 posiciones que rodean a la bomba
         * UwU
         */
        return tablero.length;
    }
}