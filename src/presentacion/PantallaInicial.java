package presentacion;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class PantallaInicial extends JFrame{
    private JPanel panel1;
    private JButton nuevoJuegoButton;
    private JButton reglasButton;
    private JButton salirButton;

    private PanelJuego panelJuego;

    public PantallaInicial() {
        setTitle("Pantalla Inicial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setContentPane(panel1);

        nuevoJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelJuego pantallaJuego = new PanelJuego();
                pantallaJuego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                pantallaJuego.setVisible(true);
            }
        });
        nuevoJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelJuego pantallaJuego = new PanelJuego();
                pantallaJuego.setVisible(true);
                pantallaJuego.setLocationRelativeTo(null);
                setVisible(false);
            }
        });

        reglasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarReglas();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void mostrarReglas() {
        JFrame reglasFrame = new JFrame("Reglas del Juego");
        System.out.println(getClass().getResource("/imagenes/img_3.png"));
        ImageIcon imagenReglas = new ImageIcon(getClass().getResource("/imagenes/img_3.png"));
        JLabel imagenLabel = new JLabel(imagenReglas);
        reglasFrame.add(imagenLabel, BorderLayout.CENTER);

        JTextArea reglasTextArea = new JTextArea(
                "Debes tener en cuenta las siguientes reglas:\n" +
                        "- El juego consiste en despejar todas las casillas de una pantalla que no oculten una mina.\n" +
                        "- Si se descubre una casilla sin número, indica que ninguna de las casillas vecinas tiene mina.\n" +
                        "- Si se descubre una casilla con una mina, se pierde la partida.\n" +
                        "- Los números 1, 2, 3 indican que alrededor hay 1 mina, 2 o 3, respectivamente."
        );
        reglasTextArea.setEditable(false);
        reglasFrame.add(reglasTextArea);
        reglasFrame.setLocationRelativeTo(null);
        reglasFrame.setSize(600, 300);
        reglasFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PantallaInicial pantallaInicial = new PantallaInicial();
                pantallaInicial.setVisible(true);
            }
        });
    }
}