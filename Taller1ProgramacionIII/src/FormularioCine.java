import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FormularioCine {
    private JPanel principal;
    private JComboBox<String> cboPelicula;
    private JComboBox<Integer> cboCantidad;
    private JButton cboComprar;
    private JTextArea txtEntradas;
    private JButton btnPelicula1;
    private JButton btnPelicula2;
    private JLabel txtAutor;
    private Cine cine;

    public FormularioCine() {
        try {
            String a = "", b = "";
            do {
                b = JOptionPane.showInputDialog("Ingrese su número de cédula real");
                a = JOptionPane.showInputDialog("Ingrese su nombre real");
            } while (b.length() < 10);
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Taller1ProgramacionIII.dat"));
            o.writeObject(a + b);
            o.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        cine = new Cine();

        // Inicializando los JComboBox
        cboPelicula = new JComboBox<>();
        cboCantidad = new JComboBox<>();

        // Poniendo los valores para los JComboBox
        cboPelicula.addItem("Película 1");
        cboPelicula.addItem("Película 2");

        cboCantidad.addItem(1);
        cboCantidad.addItem(2);
        cboCantidad.addItem(3);

        cboComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String peliculaSeleccionada = (String) cboPelicula.getSelectedItem();
                int cantidadSeleccionada = (Integer) cboCantidad.getSelectedItem();

                // Crear un nuevo asistente con la película y cantidad seleccionada
                Asistente asistente = new Asistente(peliculaSeleccionada, cantidadSeleccionada);

                // Verificar si hay suficientes entradas disponibles
                if (cine.entradasDisponibles() >= cantidadSeleccionada) {
                    // Agregar el asistente a la cola del cine
                    cine.encolar(asistente);

                    // Actualizar el JTextArea con la información de las entradas vendidas
                    txtEntradas.append(asistente.toString() + "\n");

                    // Actualizar la cantidad de entradas disponibles
                    txtEntradas.append("Entradas disponibles: " + cine.entradasDisponibles() + "\n");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay suficientes entradas disponibles.");
                }
            }
        });

        btnPelicula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Entradas disponibles para Película 1: " + cine.entradasDisponibles());
            }
        });

        btnPelicula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Entradas disponibles para Película 2: " + cine.entradasDisponibles());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormularioCine");
        frame.setContentPane(new FormularioCine().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
    }
}
