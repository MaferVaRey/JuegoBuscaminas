package presentacion;
import logicaNegocio.Juego;
import logicaNegocio.LogicaCasillas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class PanelJuego extends JFrame {

    private Juego juego;
    private JButton[][] botones;
    boolean rightClickActivated = false;

    public PanelJuego() {
        this.juego = new Juego();

        setTitle("Panel de Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(641, 960);
        setLocationRelativeTo(null);
        JPanel panelJuego = new JPanel();
        panelJuego.setLayout(new GridLayout(9, 9));
        botones = new JButton[9][9];
        LogicaCasillas generador = new LogicaCasillas();
        final int filas = 9;
        final int columnas = 9;
        int[][] tableroOculto = new int[filas][columnas];

        // Crear botones y agregarlos al panel
        for (int fila = 0; fila < 9; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                botones[fila][columna] = new JButton();
                panelJuego.add(botones[fila][columna]);
                final int finalFila = fila;
                final int finalColumna = columna;
                final boolean[] imageSet = {false};
                botones[fila][columna].addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            if (!imageSet[0]) {
                                // Si la imagen no está establecida, la establecemos
                                ImageIcon newIcon = new ImageIcon("C:\\Users\\usuario\\IdeaProjects\\JuegoBuscaminas\\src\\imagenes\\img_1.png");
                                botones[finalFila][finalColumna].setIcon(newIcon);
                                imageSet[0] = true; // Actualizamos el estado
                            } else {
                                // Si la imagen está establecida, la quitamos
                                botones[finalFila][finalColumna].setIcon(null); // Quitamos el ícono
                                imageSet[0] = false; // Actualizamos el estado
                            }
                        }
                    }
                });
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