package presentacion;
import logicaNegocio.Juego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class PanelJuego extends JFrame {

    private Juego juego;
    private JButton[][] botones;

    public PanelJuego() {
        this.juego = new Juego();

        setTitle("Panel de Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(641, 960);
        setLocationRelativeTo(null);
        JPanel panelJuego = new JPanel();
        panelJuego.setLayout(new GridLayout(9, 9));
        botones = new JButton[9][9];

        // Crear botones y agregarlos al panel
        for (int fila = 0; fila < 9; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                botones[fila][columna] = new JButton();
                panelJuego.add(botones[fila][columna]);
                final int finalFila = fila;
                final int finalColumna = columna;
                botones[fila][columna].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Clic en el botón en la posición " + finalFila + ", " + finalColumna);
                    }
                });
            }
        }
        setContentPane(panelJuego);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PanelJuego pantallaJuego = new PanelJuego();
                pantallaJuego.setVisible(true);
            }
        });
    }
}