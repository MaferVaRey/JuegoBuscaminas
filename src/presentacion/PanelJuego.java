package presentacion;
import logicaNegocio.Juego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PanelJuego extends JFrame{
    String nombreJugador;
     private Juego juego;

        public PanelJuego() {
            setTitle("Buscaminas - Panel de Juego");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Configuración del panel de juego, botones, etc.

            pack();
            setLocationRelativeTo(null);
        }

        public void iniciarJuego() {
            // Inicializar el juego y empezar la lógica
            // Similar a cómo lo hacías en el main o método de inicio de juego anteriormente

            juego = new Juego(nombreJugador); // Inicializar el juego
            // Configurar la interfaz gráfica del juego
            // Agregar botones, paneles, etc., según tu diseño

            // Lógica de juego e interacción con el usuario
            // Implementar la lógica del juego y la interacción con los botones u otros elementos gráficos

            // Al terminar el juego:
            preguntarNuevaPartida();
        }

        private void preguntarNuevaPartida() {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres jugar de nuevo?", "Juego Terminado",
                    JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                reiniciarJuego();
            } else {
                cerrarAplicacion();
            }
        }

        private void reiniciarJuego() {
            setVisible(false);
            dispose();

            PanelJuego nuevoPanelJuego = new PanelJuego();
            nuevoPanelJuego.iniciarJuego();
        }

        private void cerrarAplicacion() {
            System.exit(0);
        }

}
