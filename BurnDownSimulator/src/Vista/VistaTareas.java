package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaTareas extends JFrame {

	private JPanel contentPane;
	public JTextField campo_nombre;
	public JTextField campo_responsable;
	public JTextField campo_tipo;
	public JTextField campo_esfuerzo;
	public JTextField campo_descripcion;
	public JButton boton_enviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaTareas frame = new VistaTareas();
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
	public VistaTareas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 347, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Responsable");
		lblNewLabel.setBounds(32, 59, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setBounds(32, 98, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Esfuerzo");
		lblNewLabel_2.setBounds(32, 137, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre de la tarea");
		lblNewLabel_3.setBounds(32, 22, 127, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Descripción");
		lblNewLabel_4.setBounds(32, 178, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		campo_nombre = new JTextField();
		campo_nombre.setBounds(142, 19, 146, 20);
		contentPane.add(campo_nombre);
		campo_nombre.setColumns(10);
		
		campo_responsable = new JTextField();
		campo_responsable.setBounds(142, 56, 146, 20);
		contentPane.add(campo_responsable);
		campo_responsable.setColumns(10);
		
		campo_tipo = new JTextField();
		campo_tipo.setBounds(142, 95, 146, 20);
		contentPane.add(campo_tipo);
		campo_tipo.setColumns(10);
		
		campo_esfuerzo = new JTextField();
		campo_esfuerzo.setBounds(142, 134, 146, 20);
		contentPane.add(campo_esfuerzo);
		campo_esfuerzo.setColumns(10);
		
		campo_descripcion = new JTextField();
		campo_descripcion.setBounds(142, 175, 146, 20);
		contentPane.add(campo_descripcion);
		campo_descripcion.setColumns(10);
		
		boton_enviar = new JButton("Enviar");
		boton_enviar.setActionCommand("boton_enviar");
		boton_enviar.setBounds(32, 216, 89, 23);
		contentPane.add(boton_enviar);
	}
}
