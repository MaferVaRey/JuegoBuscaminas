import java.util.Scanner;

public class MatrizPrueba {
    static String NombreJugador;
    static int filas = 9, columnas = 9;
    static Scanner lector = new Scanner(System.in);
    static int[][] tablero = new int[filas][columnas];

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion;
        System.out.println("\t\t\t\t\t\t\t¡¡BIENVENIDO AL JUEGO DE BUSCAMINAS!\n\n");
        System.out.println("INGRESA TU NOMBRE ");
        NombreJugador = lector.next();
        do {
            System.out.println("Hola " + NombreJugador + " selecciona una de las siguientes opciones para empezar a jugar.");
            System.out.println("1.Conocer el juego.");
            System.out.println("2.Comenzar Juego.");
            System.out.println("3.Salir.");
            System.out.print("Seleccion:");
            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\nDebes tener en cuenta las siguientes reglas: \n");
                    System.out.println("* El juego consiste en despejar todas las casillas de una pantalla que no oculten una mina.");
                    System.out.println("* Si se descubre una casilla sin número indica que ninguna de las casillas vecinas tiene mina.");
                    System.out.println("* Si se descubre una casilla con una mina se pierde la partida.");
                    System.out.println("* Las minas en el tablero son representadas con el número 9.");
                    System.out.println("* Los números 1,2,3 indican que alrededor hay 1 mina, 2 o 3 respectivamente.\n");
                    break;
                case 2:
                    System.out.println("¡En hora buena " + NombreJugador + "! es hora de jugar preparado.\n");
                    InicioJuego(tablero);
                    break;
                case 3:
                    System.out.println("Gracias por jugar que tenga un excelente día.");
                    break;
                default:
                    System.out.println("Ingrese una opcion que este dentro del menu.");
                    System.out.println("--------------------------------------------");
                    break;
            }
        } while (opcion != 3);
    }

    public static int InicioJuego(int[][] tablero) {
        int PosicionFila = 0, PosicionColumna = 0;
        String Gano, Perdio;
        Main objeto = new Main();
        objeto.GeneracionDeTablero(tablero);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = tablero[i][j];
            }
        }
        System.out.println("Este es el tablero en el cuál estas jugando.");
        MatrizVacia();
        System.out.println("\nIngresa la posición primero de la fila y despúes la columna.");
        System.out.print("Fila:");
        PosicionFila = lector.nextInt();
        System.out.print("Columna:");
        PosicionColumna = lector.nextInt();
        if (PosicionFila >= 0 && PosicionFila < 9 && PosicionColumna >= 0 && PosicionColumna < 9) {
            if (tablero[PosicionFila][PosicionColumna] == 9) {
                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero.length; j++) {
                        System.out.println("¡Oh no " + NombreJugador + "! Has tenido la mala suerte de seleccionar una mina :(");
                        ImprimirMatriz(tablero);
                        System.out.println("Buena suerte la proxima vez " + NombreJugador + " :)");
                    }
                }
            }
            do {
                if (tablero[PosicionFila][PosicionColumna] != 9) {
                    for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[i].length; j++) {
                            if (tablero[PosicionFila][PosicionColumna] == 0) {
                                if (i >= 0 && i < tablero.length && j >= 0 && j < tablero[0].length) {
                                    if (Math.abs(i - PosicionFila) <= 1 && Math.abs(j - PosicionColumna) <= 1) {
                                        if (tablero[i][j] == 9) {
                                            System.out.print("|*|");
                                        } else
                                            System.out.print("|" + tablero[i][j] + "|");
                                    } else {
                                        System.out.print("|*|");
                                    }
                                }
                            } else {
                                if (Math.abs(i - PosicionFila) <= 1 && Math.abs(j - PosicionColumna) <= 1) {
                                    if (tablero[i][j] == 9) {
                                        System.out.print("|*|");
                                    } else
                                        System.out.print("|" + tablero[i][j] + "|");
                                } else {
                                    System.out.print("|*|");
                                }
                            }
                        }
                        System.out.println();
                    }
                }
            } while (tablero[PosicionFila][PosicionColumna] == 9);

        } else
            System.out.println("Ingrese una posición valida");
        return tablero.length;
    }

    public static void ImprimirMatriz(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print("|" + tablero[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static int MatrizVacia() {
        char[][] MatrizVacia = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("|*|");
            }
            System.out.println();
        }
        return MatrizVacia.length;
    }
}