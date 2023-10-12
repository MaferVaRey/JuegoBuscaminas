import java.util.Scanner;
class Juego {
    private String nombreJugador;
    private Tablero tablero;
    private boolean juegoTerminado = false;

    public Juego(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.tablero = new Tablero();
    }

    public void iniciar() {
        Scanner lector = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Hola " + nombreJugador + " selecciona una de las siguientes opciones para empezar a jugar.");
            System.out.println("1. Conocer el juego.");
            System.out.println("2. Comenzar Juego.");
            System.out.println("3. Salir.");
            System.out.print("Seleccion: ");
            opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    mostrarReglasDelJuego();
                    break;
                case 2:
                    System.out.println("¡En hora buena " + nombreJugador + "! Es hora de jugar. Prepárate.\n");
                    tablero.inicializarTableros();
                    jugar();
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

    private void mostrarReglasDelJuego() {
        System.out.println("\nDebes tener en cuenta las siguientes reglas: \n");
        System.out.println("* El juego consiste en despejar todas las casillas de una pantalla que no oculten una mina.");
        System.out.println("* Si se descubre una casilla sin número, indica que ninguna de las casillas vecinas tiene mina.");
        System.out.println("* Si se descubre una casilla con una mina, se pierde la partida.");
        System.out.println("* Las minas en el tablero son representadas con el número 9.");
        System.out.println("* Los números 1, 2, 3 indican que alrededor hay 1 mina, 2 o 3, respectivamente.\n");
    }

    private void jugar() {
        while (!juegoTerminado) {
            tablero.mostrarTablero();
            System.out.println("\n Muy bien " + nombreJugador + " elige una de las siguientes opciones:");
            System.out.println("1. Descubrir casilla");
            System.out.println("2. Marcar mina");
            System.out.print("Opción: ");
            Scanner lector = new Scanner(System.in);
            int opcion = lector.nextInt();

            if (opcion == 1) {
                descubrirCasilla();
            } else if (opcion == 2) {
                marcarMina();
            } else {
                System.out.println("Ingresa una opción válida. Elige 1 o 2.");
            }
        }
    }

    private void descubrirCasilla() {
        Scanner lector = new Scanner(System.in);
        System.out.print("Fila: ");
        int fila = lector.nextInt();
        System.out.print("Columna: ");
        int columna = lector.nextInt();

        if (tablero.validarCoordenadas(fila, columna)) {
            fila--;
            columna--;
            if (tablero.descubrirCasilla(fila, columna)) {
                System.out.println("¡Oh no " + nombreJugador + "! Has tenido la mala suerte de seleccionar una mina :(");
                System.out.println("Buena suerte la próxima vez " + nombreJugador + " :)");
                juegoTerminado = true;
            }
        } else {
            System.out.println("Ingresa una posición válida dentro del tablero.");
        }
    }

    private void marcarMina() {
        Scanner lector = new Scanner(System.in);
        System.out.print("Fila para marcar mina: ");
        int fila = lector.nextInt();
        System.out.print("Columna para marcar mina: ");
        int columna = lector.nextInt();

        if (tablero.validarCoordenadas(fila, columna)) {
            fila--;
            columna--;
            tablero.marcarMina(fila, columna);
            if (tablero.haGanado()) {
                tablero.mostrarTablero();
                System.out.println("¡Felicidades, has ganado, " + nombreJugador + "!");
                juegoTerminado = true;
            }
        } else {
            System.out.println("Ingresa una posición válida dentro del tablero.");
        }
    }
}