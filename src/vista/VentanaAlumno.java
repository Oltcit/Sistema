package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.AlumnoDAO;
import modelo.AlumnoVO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAlumno extends JFrame {

	private JPanel contentPane;
	Coordinador miCoordinador;
	private JTextField txtDni;
	private JTextField txtNom;
	private JTextField txtFnac;
	JCheckBox chkDoc;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JButton btnAgregar;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnCancelar;
	int accion=0;

	public Coordinador getMiCoordinador() {
		return miCoordinador;
	}

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAlumno frame = new VentanaAlumno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAlumno() {
		setTitle("Ventana Alumno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarAlumno();
			}
		});
		panelSur.add(btnGuardar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				accion=1;
				habilita(true, true, true, true, true, false, false, false, false, true);
			}
		});
		panelSur.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		panelSur.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		panelSur.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miCoordinador.mostrarVentanaAlumnoBuscar();
			}
		});
		panelSur.add(btnBuscar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
			}
		});
		panelSur.add(btnCancelar);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(28, 24, 46, 14);
		panel.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 49, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(28, 74, 112, 14);
		panel.add(lblFechaDeNacimiento);
		
		chkDoc = new JCheckBox("Documentaci\u00F3n");
		chkDoc.setBounds(26, 115, 114, 23);
		panel.add(chkDoc);
		
		txtDni = new JTextField();
		txtDni.setBounds(55, 21, 86, 20);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(84, 46, 86, 20);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		txtFnac = new JTextField();
		txtFnac.setBounds(136, 71, 86, 20);
		panel.add(txtFnac);
		txtFnac.setColumns(10);
		
		limpiar();
	}

	protected void guardarAlumno() {
		try{
		AlumnoVO miAlumnoVO = new AlumnoVO();
		miAlumnoVO.setDni(Integer.valueOf(txtDni.getText()));
		miAlumnoVO.setNom(txtNom.getText());
		miAlumnoVO.setFnac(txtFnac.getText());
		if (chkDoc.isSelected())
			miAlumnoVO.setDoc(1);
		else
			miAlumnoVO.setDoc(0);
		
		AlumnoDAO miAlumnoDAO = new AlumnoDAO();
		miAlumnoDAO.guardarAlumno(miAlumnoVO);
		limpiar();
		
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error en el ingreso de datos");
		}
		
	}
	public void habilita(boolean dni, boolean nom, boolean fecha, boolean doc, boolean bGuardar, boolean bAgregar,
			boolean bModificar, boolean bEliminar, boolean bBuscar, boolean bCancelar){
		
		txtDni.setEditable(dni);
		txtNom.setEditable(nom);
		txtFnac.setEditable(fecha);
		chkDoc.setEnabled(doc);
		btnGuardar.setVisible(bGuardar);
		btnAgregar.setEnabled(bAgregar);
		btnModificar.setEnabled(bModificar);
		btnEliminar.setEnabled(bEliminar);
		btnBuscar.setEnabled(bBuscar);
		btnCancelar.setEnabled(bCancelar);
	}
	public void limpiar(){
		txtDni.setText("");
		txtNom.setText("");
		txtFnac.setText("");
		chkDoc.setSelected(false);
		
		habilita(true, false, false, false, false, true, false, false, true, true);
	}
	
}
