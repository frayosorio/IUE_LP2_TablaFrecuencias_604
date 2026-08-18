import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class FrmTablaFrecuencias extends JFrame {

    // variables globales
    private String[] variable = { "Excelente", "Buena", "Regular", "Mala" };
    private String[] encabezados = { "Variable",
            "Frecuencia absoluta (f)",
            "Frecuencia acumulada (F)",
            "Frecuencia relativa (fr)",
            "Frecuencia porcentual (%f)" };
    private String[][] datosFrecuencias;
    JComboBox cmbRespuesta;
    JList lstRespuestas;
    JTable tblFrecuencias;

    // metodo constructor (dibujado de la interfaz gráfica)
    public FrmTablaFrecuencias() {
        // definir tamaño de la ventana
        setSize(500, 500);
        // asignar titulo
        setTitle("Tabla de Frecuencias");
        // operación de cierre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // quitar distribucion
        setLayout(null);

        JLabel lblPregunta = new JLabel("Pregunta:");
        lblPregunta.setBounds(10, 10, 100, 25);
        add(lblPregunta);

        JTextArea txtPregunta = new JTextArea(
                "¿Cómo considera la calidad de la señal de internet que entra al barrio?");
        txtPregunta.setBounds(120, 10, 310, 50);
        txtPregunta.setEditable(false);
        txtPregunta.setLineWrap(true);
        add(txtPregunta);

        JLabel lblRespuesta = new JLabel("Respuesta:");
        lblRespuesta.setBounds(10, 60, 100, 25);
        add(lblRespuesta);

        // declarar la lista desplegable para leer la respuesta
        // que está basada en los valores de la VARIABLE
        cmbRespuesta = new JComboBox();
        cmbRespuesta.setBounds(120, 60, 100, 25);
        cmbRespuesta.setModel(new DefaultComboBoxModel(variable)); // definir fuente de opciones de la lista desplegable
        add(cmbRespuesta);

        JButton btnAgregar = new JButton(">>");
        btnAgregar.setBounds(120, 95, 100, 25);
        add(btnAgregar);

        JButton btnQuitar = new JButton("<<");
        btnQuitar.setBounds(120, 130, 100, 25);
        add(btnQuitar);

        // declarar la lista que mostrará todas las respuestas agregadas
        lstRespuestas = new JList();
        JScrollPane spRespuestas = new JScrollPane(lstRespuestas);
        spRespuestas.setBounds(230, 60, 100, 100);
        add(spRespuestas);

        JButton btnCalcular = new JButton("Calcular Frecuencias");
        btnCalcular.setBounds(10, 170, 200, 25);
        add(btnCalcular);

        // declarar la tabla donde se mostrará el análisis de las frecuencias de las
        // respuestas
        tblFrecuencias = new JTable();
        JScrollPane spFrecuencias = new JScrollPane(tblFrecuencias);
        spFrecuencias.setBounds(10, 205, 460, 200);
        add(spFrecuencias);

        // definir el contenido inicial de la tabla
        datosFrecuencias = new String[variable.length][5];
        for (int i = 0; i < variable.length; i++) {
            datosFrecuencias[i][0] = variable[i];
        }
        DefaultTableModel dtm = new DefaultTableModel(datosFrecuencias, encabezados);
        tblFrecuencias.setModel(dtm);

    }
}
