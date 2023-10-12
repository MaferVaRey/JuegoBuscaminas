
import java.util.Scanner;

public class JuegoBuscaminas {
    static String nombreJugador;
    static int filas = 9, columnas = 9, opcion = 0;
    static int[][] tableroOculto = new int[filas][columnas];
    static char[][] tableroVisible = new char[10][10];
    static boolean juegoTerminado = false;
    static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("\t\t\t\t\t\t\t¡¡BIENVENIDO AL JUEGO DE BUSCAMINAS!\n\n");
        System.out.println("INGRESA TU NOMBRE ");
        nombreJugador = lector.next();
        do {
            System.out.println("Hola " + nombreJugador + " selecciona una de las siguientes opciones para empezar a jugar.");
            System.out.println("1.Conocer el juego.");
            System.out.println("2.Comenzar Juego.");
            System.out.println("3.Salir.");
            System.out.print("Seleccion: ");
            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\nDebes tener en cuenta las siguientes reglas: \n");
                    System.out.println("* El juego consiste en despejar todas las casillas de una pantalla que no oculten una mina.");
                    System.out.println("* Si se descubre una casilla sin número indica que ninguna de las casillas vecinas tiene mina.");
                    System.out.println("* Si se descubre una casilla con una mina se pierde la partida.");
                    System.out.println("* Las minas en el tablero son representadas con el número 9.");
                    System.out.println("* Los números 1, 2, 3 indican que alrededor hay 1 mina, 2 o 3 respectivamente.\n");
                    break;
                case 2:
                    System.out.println("¡En hora buena " + nombreJugador + "! Es hora de jugar. Prepárate.\n");
                    inicializarTableros();
                    inicioJuego();
                    break;
                case 3:
                    System.out.println("Gracias por jugar, que tengas un excelente día.");
                    break;
                default:
                    System.out.println("Ingrese una opción que esté dentro del menú.");
                    System.out.println("--------------------------------------------");
                    break;
            }
        } while (opcion != 3);
    }

    public static void inicializarTableros() {
        // Llamamos a la clase Tablero la cual genera un tablero aleatorio
        //y le pasamos sus componentes a la matriz tableroOculto.
        GeneracionTablero objeto = new GeneracionTablero();
        GeneracionTablero.GeneracionDeTablero(tableroOculto);

        // Inicializamos el nuevo tableroVisible que se le muestra al usuario.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0) {
                    tableroVisible[i][j] = (char) ('0' + j);
                } else if (j == 0) {
                    tableroVisible[i][j] = (char) ('0' + i);
                } else {
                    tableroVisible[i][j] = '*';
                }
            }
        }
    }
    //   Este método inicia el juego de buscaminas a partir de las dos matrices creadas.
    public static void inicioJuego() {
        while (!juegoTerminado) {
            mostrarTablero();
            System.out.println("\n Muy bien "+nombreJugador+" elije una de las siguientes opcines:");
            System.out.println("1. Descubrir casilla");
            System.out.println("2. Marcar mina");
            System.out.print("Opción: ");
            opcion = lector.nextInt();
            if (opcion == 1) {
                System.out.print("Fila: ");
                int fila = lector.nextInt();
                System.out.print("Columna: ");
                int columna = lector.nextInt();
                if (fila >= 1 && fila <= filas && columna >= 1 && columna <= columnas) {
                    fila--;
                    columna--;
                    if (tableroOculto[fila][columna] == 9) {
                        tableroVisible[fila + 1][columna + 1] = 'X'; // Mina marcada
                        mostrarTablero();
                        System.out.println("¡Oh no " + nombreJugador + "! Has tenido la mala suerte de seleccionar una mina :(");
                        System.out.println("Buena suerte la proxima vez " + nombreJugador + " :)");
                        juegoTerminado = true;
                    } else if (tableroVisible[fila + 1][columna + 1] != '*') {
                        System.out.println("Esta casilla ya ha sido descubierta elige otra.");
                    } else if (tableroOculto[fila][columna] == 0) {
                        descubrirCasillasVacias(fila, columna);
                    } else {
                        tableroVisible[fila + 1][columna + 1] = (char) (tableroOculto[fila][columna] + '0');
                    }
                } else {
                    System.out.println("Ingresa una posición válida dentro del tablero.");
                }
            } else if (opcion == 2) {
                System.out.print("Fila para marcar mina: ");
                int fila = lector.nextInt();
                System.out.print("Columna para marcar mina: ");
                int columna = lector.nextInt();
                if (fila >= 1 && fila <= filas && columna >= 1 && columna <= columnas) {
                    fila--;
                    columna--;
                    if (tableroVisible[fila + 1][columna + 1] == '*') {
                        tableroVisible[fila + 1][columna + 1] = 'M'; // Marcar mina
                    } else {
                        System.out.println("Esta casilla ya ha sido descubierta elige otra.");
                    }
                } else {
                    System.out.println("Ingresa una posición válida dentro del tablero.");
                }
                if (haGanado()) {
                    mostrarTablero();
                    System.out.println("¡Felicidades, has ganado!"+nombreJugador);
                    juegoTerminado = true;
                }
            } else {
                System.out.println("Ingresa una opción que este dentro del menú; Elige 1 o 2.");
            }
        }
    }
    public static void descubrirCasillasVacias(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas || tableroVisible[fila + 1][columna + 1] != '*') {
            return;
        }
        tableroVisible[fila + 1][columna + 1] = (char) (tableroOculto[fila][columna] + '0');
        if (tableroOculto[fila][columna] == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    descubrirCasillasVacias(fila + i, columna + j);
                }
            }
        }
    }

    public static boolean haGanado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tableroVisible[i + 1][j + 1] == '*' && tableroOculto[i][j] != 9) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void mostrarTablero() {
        System.out.println("Este es el tablero en el cuál estas jugando " + nombreJugador + ":");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("[" + tableroVisible[i][j] + "]");
            }
            System.out.println();
        }
    }
}