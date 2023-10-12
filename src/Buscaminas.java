import java.util.Scanner;

/**
 * Clase main, ejecutable.
 */
public class Buscaminas {

    /**
     * Método main donde funciona el juego
     * @param args
     *
     * Complejidad temporal: complejidad cuadrática O(N^2) (Complejidad máxima usada en los métodos que
     * se ejecutanen todo el programa)
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("\t\t\t\t\t\t\t¡¡BIENVENIDO AL JUEGO DE BUSCAMINAS!\n\n");
        System.out.println("INGRESA TU NOMBRE ");
        String nombreJugador = lector.next();

        Juego juego = new Juego(nombreJugador);
        juego.iniciar();
    }
}