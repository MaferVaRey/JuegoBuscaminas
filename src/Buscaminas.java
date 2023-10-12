import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("\t\t\t\t\t\t\t¡¡BIENVENIDO AL JUEGO DE BUSCAMINAS!\n\n");
        System.out.println("INGRESA TU NOMBRE ");
        String nombreJugador = lector.next();

        Juego juego = new Juego(nombreJugador);
        juego.iniciar();
    }
}