import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class examenGUI {
    private JButton agregarBtn;
    private JTextArea txtResultado;
    private JTextField txtCodigo;
    private JPanel pGeneral;
    private JTextField txtNombre;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
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
    private JScrollBar scrollBar1;
    private JScrollBar scrollBar2;
    private YoungAvenger avenger=new YoungAvenger();

    public examenGUI() {
        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo= Integer.parseInt(txtCodigo.getText());
                    String nombre=txtNombre.getText();
                    String poder=txtPoder.getText();
                    String nivelHabilidad=txtHabilidad.getText();
                    int misionActiva=Integer.parseInt(txtMision.getText());

                }catch (Exception ex){
                    txtResultado.setText("Error al registrar el Avenger: " + ex.getMessage());
                }
            }
        });
        mostrarAvengersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo=Integer.parseInt(txtCodigo.getText());




            }
        });
        buscarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int codigo=Integer.parseInt((txtCodigo.getText()));



            }
        });
        avengersSinPoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        avengersConPoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ordenarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        calcularMisionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("examenGUI");
        frame.setContentPane(new examenGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
