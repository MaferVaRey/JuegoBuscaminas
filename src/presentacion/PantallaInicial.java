package presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaInicial extends JFrame{
    public PantallaInicial() {
        setTitle("Buscaminas - Menú de Opciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar elementos de la pantalla inicial (botones, texto, etc.)
        // Agregar ActionListener para los botones que inician el juego o cierran la aplicación
        JButton nuevoJuegoButton = new JButton("Nuevo Juego");
        JButton salirButton = new JButton("Salir");

        nuevoJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarNuevoJuego();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarAplicacion();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1)); // Dos botones uno arriba del otro
        panel.add(nuevoJuegoButton);
        panel.add(salirButton);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarNuevoJuego() {
        // Cerrar esta ventana y abrir el panel de juego
        setVisible(false);
        dispose(); // Liberar recursos de la ventana actual

        PanelJuego panelJuego = new PanelJuego();
        panelJuego.iniciarJuego();
    }

    private void cerrarAplicacion() {
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PantallaInicial());
    }
}

