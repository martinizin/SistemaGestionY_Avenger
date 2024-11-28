import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class examenGUI {
    private JButton agregarBtn;
    private JTextArea txtResultado;
    private JTextField txtCodigo;
    private JPanel pGeneral;
    private JTextField txtNombre;
    private JComboBox<String> comboBox1; // Poder
    private JComboBox<Integer> comboBox2; // Nivel de habilidad
    private JComboBox<Integer> comboBox3; // Misión activa
    private JButton buscarBtn;
    private JTable table1;
    private JButton ordenarBtn;
    private JButton avengersConPoderButton;
    private JButton avengersSinPoderButton;
    private JButton mostrarAvengersButton;
    private JButton calcularMisionesButton;
    private JLabel txtPoder;
    private JLabel txtHabilidad;
    private JLabel txtMision;

    private YoungAvenger avenger = new YoungAvenger();

    public examenGUI() {

        // Agregamos niveles de habilidad (1 a 5)
        for (int i = 1; i <= 5; i++) {
            comboBox2.addItem(i);
        }

        // Agregamos misiones activas (0 a 5)
        for (int i = 0; i <= 5; i++) {
            comboBox3.addItem(i);
        }

        // Configuramos la tabla
        String[] columnNames = {"Código", "Nombre", "Poder", "Nivel de Habilidad", "Misión Activa"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table1.setModel(model);

        // Acción para el botón "Agregar"
        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener los datos del formulario
                    int codigo = Integer.parseInt(txtCodigo.getText());  // Convierte el código a Integer
                    String nombre = txtNombre.getText();
                    String poder = (String) comboBox1.getSelectedItem();  // Obtén el poder como String
                    String nivelHabilidad = (String) comboBox2.getSelectedItem();  // Obtén el nivel de habilidad como Integer
                    Integer misionActiva = (Integer) comboBox3.getSelectedItem();  // Obtén la misión activa como Integer

                    // Crear el nuevo YoungAvenger
                    YoungAvenger nuevoAvenger = new YoungAvenger(codigo, nombre, poder, nivelHabilidad, misionActiva);

                    // Agregar el Avenger a la lista
                    avenger.agregarAvenger(nuevoAvenger);

                    // Actualizar la tabla
                    actualizarTabla();
                } catch (Exception ex) {
                    // Mostrar error en el JTextArea
                    txtResultado.setText("Error al registrar el Avenger: " + ex.getMessage());
                }
            }
        });

        // Mostrar Avengers
        mostrarAvengersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avenger.mostrarAvenger(txtResultado);
            }
        });

        // Buscar Avengers
        buscarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    int posicion = avenger.buscarAvenger(codigo);
                    if (posicion != -1) {
                        txtResultado.setText("Avenger encontrado en la posición: " + posicion);
                    } else {
                        txtResultado.setText("Avenger no encontrado.");
                    }
                } catch (Exception ex) {
                    txtResultado.setText("Error: " + ex.getMessage());
                }
            }
        });

        // Avengers con poder
        avengersConPoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avenger.avengersConPoder(txtResultado);
            }
        });

        // Avengers sin poder
        avengersSinPoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avenger.avengersSinPoder(txtResultado);
            }
        });

        // Ordenar Avengers
        ordenarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avenger.ordenarAvengers();
                txtResultado.setText("Lista de Avengers ordenada.");
                actualizarTabla();
            }
        });

        // Calcular misiones activas
        calcularMisionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int misionesActivas = avenger.calcularMisionesActivas();
                txtResultado.setText("Número de misiones activas: " + misionesActivas);
            }
        });
    }

    // Actualiza la tabla con los Avengers
    private void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

        NodoAvengers actual = avenger.inicio;
        while (actual != null) {
            model.addRow(new Object[] {
                    actual.dato.codigo,
                    actual.dato.nombre,
                    actual.dato.poder,
                    actual.dato.nivelHabilidad,
                    actual.dato.misionActiva
            });
            actual = actual.sig;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("examenGUI");
        frame.setContentPane(new examenGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
