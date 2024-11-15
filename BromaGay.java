import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BromaGay extends JFrame {
    private JButton botonNo;
    private Random random = new Random();

    public BromaGay() {
        // Configurar la ventana principal
        setTitle("Pregunta Importante");
        setSize(600, 400);
        setResizable(false);
        setLayout(null);

        // Evitar que se cierre con la X
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Crear panel principal con fondo blanco
        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBounds(0, 0, 600, 400);

        // Crear y añadir la etiqueta con la pregunta
        JLabel pregunta = new JLabel("¿Eres gay?", SwingConstants.CENTER);
        pregunta.setFont(new Font("Dialog", Font.BOLD, 28));
        pregunta.setBounds(150, 50, 300, 40);
        mainPanel.add(pregunta);

        // Crear y añadir el botón "Sí" más grande
        JButton botonSi = new JButton("Sí");
        botonSi.setFont(new Font("Dialog", Font.BOLD, 18));
        botonSi.setBounds(250, 120, 100, 50);
        botonSi.setFocusPainted(false);
        botonSi.addActionListener(e -> System.exit(0));
        mainPanel.add(botonSi);

        // Crear y añadir el botón "No"
        botonNo = new JButton("No");
        botonNo.setFont(new Font("Dialog", Font.PLAIN, 14));
        botonNo.setBounds(260, 200, 80, 30);
        botonNo.setFocusPainted(false);

        // Añadir el listener para detectar cuando el mouse se acerca
        botonNo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                moverBoton();
            }
        });
        mainPanel.add(botonNo);

        // Añadir el panel principal a la ventana
        add(mainPanel);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Añadir listener para la X de cerrar
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // No hace nada, evitando que se cierre
            }
        });

        // Evitar Alt+F4
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F4 && e.isAltDown()) {
                    return true; // Consumir el evento Alt+F4
                }
                return false;
            }
        });
    }

    private void moverBoton() {
        // Obtener dimensiones de la ventana
        int maxX = getWidth() - botonNo.getWidth() - 20;
        int maxY = getHeight() - botonNo.getHeight() - 40;

        // Generar nueva posición aleatoria
        int newX = random.nextInt(maxX);
        int newY = random.nextInt(maxY);

        // Mover el botón
        botonNo.setLocation(newX, newY);
    }

    public static void main(String[] args) {
        try {
            // Establecer look and feel del sistema
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ejecutar la aplicación
        SwingUtilities.invokeLater(() -> {
            BromaGay ventana = new BromaGay();
            ventana.setVisible(true);
        });
    }
}