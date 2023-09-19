
import java.util.Scanner;

public class MatrizPrueba { // Importamos la clase Scanner desde el paquete java.util para leer la entrada del usuario.

    static String NombreJugador;  // Variable para almacenar el nombre del jugador.
    static int filas = 9, columnas = 9, PosicionFila = 0, PosicionColumna = 0, opcion = 0;  // Definimos las dimensiones del tablero como 9x9.
    static Scanner lector = new Scanner(System.in);// Creamos un objeto Scanner para leer la entrada del usuario.
    static int[][] tableroJuego = new int[filas][columnas]; // Matriz para el tablero visible por el jugador.
    static int[][] tableroOculto = new int[filas][columnas];// Matriz para el tablero con minas (oculto).
    static boolean SigueJugando = true; // Variable para indicar si el juego sigue en curso o no.

    public static void main(String[] args) {
        menu();
    }
    // Método para mostrar el menú inicial del juego y solicitar el nombre del jugador.
    public static void menu() {
        System.out.println("\t\t\t\t\t\t\t¡¡BIENVENIDO AL JUEGO DE BUSCAMINAS!\n\n");
        System.out.println("INGRESA TU NOMBRE ");
        NombreJugador = lector.next();// Lee y almacena el nombre ingresado por el jugador.
        do {   // Bucle do-while para mostrar el menú y procesar la opción elegida por el jugador.
            System.out.println("Hola " + NombreJugador + " selecciona una de las siguientes opciones para empezar a jugar.");
            System.out.println("1.Conocer el juego.");
            System.out.println("2.Comenzar Juego.");
            System.out.println("3.Salir.");
            System.out.print("Seleccion:");
            opcion = lector.nextInt();// Lee y almacena la opción seleccionada por el jugador.
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
        } while (opcion != 3);//En este caso, significa que el juego continuará mostrando el menú y procesando las opciones del jugador
        // hasta que el jugador seleccione la opción "3.Salir". Una vez que el jugador elige salir, el bucle se interrumpe y el programa
        // continúa con el código después del bucle do-while.
    }

    public static void InicioJuego(int[][] tableroOculto) {
        Main objeto = new Main();
        objeto.GeneracionDeTablero(tableroOculto);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tableroOculto[i][j] = tableroOculto[i][j];
            }// tableroOculto[i][j] = tableroOculto[i][j];

            // La variable 'i' es el índice de la fila actual en la iteración.
            // La variable 'j' es el índice de la columna actual en la iteración.

            // El operador '++' incrementa el valor de la variable por 1.
            // Por ejemplo, 'i++' es equivalente a 'i = i + 1'.

            // El operador '<' es un operador de comparación que verifica si el valor a la izquierda es menor que el valor a la derecha.
            // Por ejemplo, 'i < filas' verifica si 'i' es menor que el número de filas.

            // El operador '=' es un operador de asignación que asigna el valor a la derecha a la variable a la izquierda.
            // Por ejemplo, 'i = 0' asigna el valor 0 a la variable 'i'.

            // Los corchetes '[]' se utilizan para acceder a elementos de un arreglo o matriz.
            // Por ejemplo, 'tableroOculto[i][j]' accede al elemento en la fila 'i' y columna 'j' del tablero.
        }
        System.out.println("Este es el tablero en el cuál estas jugando.");
        for (int i = 0; i < filas; i++) {// Bucle externo que itera sobre las filas del tablero.
            for (int j = 0; j < columnas; j++) {// Bucle externo que itera sobre las columnas  del tablero.

                System.out.print("|*|");
                // Se imprime en la consola el carácter '|*|', que parece ser el símbolo que representa una casilla en el tablero.
            }
            System.out.println();
        }
        System.out.println("\nIngresa la posición primero de la fila y despúes la columna.");
        System.out.print("Fila:");// Se imprime en la consola un mensaje pidiendo la fila.
        PosicionFila = lector.nextInt();// Se lee el valor de la fila que el usuario ingresa utilizando el objeto 'lector' (presumiblemente un Scanner).
        System.out.print("Columna:");
        PosicionColumna = lector.nextInt();
        while (SigueJugando) { // El código dentro de este bloque se ejecutará mientras la variable 'SigueJugando' sea verdadera.
            if (PosicionFila >= 0 && PosicionFila < 9 && PosicionColumna >= 0 && PosicionColumna < 9) {
                // Esta condición verifica si la posición ingresada está dentro de los límites de la matriz 9x9.
                if (tableroOculto[PosicionFila][PosicionColumna] == 9) {
                    // Si el valor en la posición seleccionada es 9, se ejecuta el siguiente bloque.
                    EvaluacionPierdeJugador(tableroOculto);
                    SigueJugando = false;   // Si el valor en la posición seleccionada es 9, se ejecuta el siguiente bloque.
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
        opcion = lector.nextInt(); // Se lee la opción que el jugador elige utilizando el objeto 'lector'.
        switch (opcion) {     // Se utiliza una estructura switch para determinar qué acción tomar basado en la opción selecciona
            case 1:
                EvaluacionJugador(tableroOculto);  // Si el jugador elige la opción 1 (Ingresar otra posición), se ejecuta este bloque de código.
                // Se llama a la función 'EvaluacionJugador' y se pasa 'tableroOculto' como argumento.
                break;
            case 2:
                System.out.print("Fila:");
                PosicionFila = lector.nextInt(); // Se lee el valor de la fila que el jugador ingresa utilizando el objeto 'lector'.
                System.out.print("Columna:");
                PosicionColumna = lector.nextInt();
                break;
            default: // Si la opción seleccionada no coincide con ningún caso (1 o 2), se ejecuta este bloque.
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


               // tableroOculto.length se refiere al tamaño (longitud) de la matriz tableroOculto en la dimensión de las filas. En este contexto, tableroOculto.length es el número total de filas en la matriz.
                //i es una variable de control que se inicializa en 0. El bucle se ejecutará mientras i sea menor que el número de filas. En cada iteración, i se incrementa en 1 (debido a i++).
            }// accede al elemento de la matriz en la fila i y columna j.
            //En el contexto del código proporcionado, parece que tableroOculto es una matriz de enteros que probablemente representa un tablero de juego.
            //Se imprime el valor de la casilla en el formato |valor|.
            System.out.println();
        }
    }

    public static void EvaluacionJugador0(int[][] tableroOculto, int[][] tableroJuego, int PosicionFila, int PosicionColumna) {
        for (int i = 0; i < tableroOculto.length; i++) {
            for (int j = 0; j < tableroOculto[i].length; j++) {
                if (Math.abs(i - PosicionFila) <= 1 && Math.abs(j - PosicionColumna) <= 1) {
                    //verifica si la casilla está dentro del rango de 1 celda alrededor de la posición seleccionada.
                    if (tableroOculto[i][j] == 9) {
                        System.out.print("|*|");
                        // Verifica si la casilla en el tableroOculto contiene una mina (valor 9)
                        // Si hay una mina en la casilla, se imprime un '*' para indicar una mina descubierta

                    } else
                        System.out.print("|" + tableroOculto[i][j] + "|");
                    // Si no hay una mina, se imprime el valor de la casilla en el tableroOculto
                } else {
                    System.out.print("|*|");
                    // Si la casilla no está en el rango de 1 celda alrededor de la posición seleccionada, se imprime '*'
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

