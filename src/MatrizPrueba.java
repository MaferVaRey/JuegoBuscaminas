
import java.util.Scanner;

public class MatrizPrueba {
    static String NombreJugador;
    static int filas = 9, columnas = 9, PosicionFila = 0, PosicionColumna = 0, opcion = 0;
    static Scanner lector = new Scanner(System.in);
    static int[][] tableroJuego = new int[filas][columnas];
    static int[][] tableroOculto = new int[filas][columnas];
    static boolean SigueJugando = true;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
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
                    InicioJuego(tableroOculto);
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

    public static void InicioJuego(int[][] tableroOculto) {
        Main objeto = new Main();
        objeto.GeneracionDeTablero(tableroOculto);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tableroOculto[i][j] = tableroOculto[i][j];
            }
        }
        System.out.println("Este es el tablero en el cuál estas jugando.");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("|*|");
            }
            System.out.println();
        }
        System.out.println("\nIngresa la posición primero de la fila y despúes la columna.");
        System.out.print("Fila:");
        PosicionFila = lector.nextInt();
        System.out.print("Columna:");
        PosicionColumna = lector.nextInt();
        while (SigueJugando) {
            if (PosicionFila >= 0 && PosicionFila < 9 && PosicionColumna >= 0 && PosicionColumna < 9) {
                if (tableroOculto[PosicionFila][PosicionColumna] == 9) {
                    EvaluacionPierdeJugador(tableroOculto);
                    SigueJugando = false;
                } else if (tableroOculto[PosicionFila][PosicionColumna] == 0) {

                    MenuDeJugador(tableroOculto);
                    SigueJugando = false;
                } else {
                    EvaluacionJugador(tableroOculto);
                    MenuDeJugador(tableroOculto);
                    SigueJugando = false;
                }
            }
        }
    }

    public static void MenuDeJugador(int[][] tableroOculto) {
        System.out.println("Muy bien " + NombreJugador + " elige una de las siguientes opciones.");
        System.out.println("1. Ingresar otra posición.");
        System.out.println("2. Marcar una mina.");
        opcion = lector.nextInt();
        switch (opcion) {
            case 1:
                EvaluacionJugador(tableroOculto);
                break;
            case 2:
                System.out.print("Fila:");
                PosicionFila = lector.nextInt();
                System.out.print("Columna:");
                PosicionColumna = lector.nextInt();
                break;
            default:
                System.out.println("Ingrese una opcion que este dentro del menu.");
                System.out.println("--------------------------------------------");
                break;
        }

    }

    public static void EvaluacionPierdeJugador(int[][] tableroOculto) {
        System.out.println("¡Oh no " + NombreJugador + "! Has tenido la mala suerte de seleccionar una mina :(");
        System.out.println("Buena suerte la proxima vez " + NombreJugador + " :)");
        for (int i = 0; i < tableroOculto.length; i++) {
            for (int j = 0; j < tableroOculto.length; j++) {
                System.out.print("|" + tableroOculto[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static void EvaluacionJugador0(int[][] tableroOculto, int[][] tableroJuego, int PosicionFila, int PosicionColumna) {
        for (int i = 0; i < tableroOculto.length; i++) {
            for (int j = 0; j < tableroOculto[i].length; j++) {
                if (Math.abs(i - PosicionFila) <= 1 && Math.abs(j - PosicionColumna) <= 1) {
                    if (tableroOculto[i][j] == 9) {
                        System.out.print("|*|");
                    } else
                        System.out.print("|" + tableroOculto[i][j] + "|");
                } else {
                    System.out.print("|*|");
                }
            }
            System.out.println();
        }

    }

    public static void EvaluacionJugador(int[][] tableroOculto) {
        for (int i = 0; i < tableroOculto.length; i++) {
            for (int j = 0; j < tableroOculto.length; j++) {
                if (i == PosicionFila && j == PosicionColumna) {
                    System.out.print("|" + tableroOculto[i][j] + "|");
                } else
                    System.out.print("|*|");

            }
            System.out.println();
        }
    }
}

