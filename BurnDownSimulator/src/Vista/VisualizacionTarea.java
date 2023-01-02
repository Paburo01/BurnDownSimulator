package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Tarea;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizacionTarea extends JFrame {

	public JPanel contentPane;
	public JLabel label_Descripcion;
	public JLabel lblTipo;
	public JLabel label_Estado;
	public JLabel label_Tiempo;
	public JLabel label_Tarea;
	public JLabel label_ID;
	public JLabel lblAutor;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VisualizacionTarea(Tarea t) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_ID = new JLabel("ID:" + t.getID());
		label_ID.setFont(new Font("Source Sans Pro Black", Font.BOLD, 16));
		label_ID.setBounds(25, 59, 361, 14);
		contentPane.add(label_ID);
		
		label_Tarea = new JLabel("Tarea: " + t.getTarea());
		label_Tarea.setFont(new Font("Source Sans Pro Black", Font.BOLD, 16));
		label_Tarea.setBounds(25, 95, 361, 14);
		contentPane.add(label_Tarea);
		
		lblTipo = new JLabel("Tipo: " + t.getTipo());
		lblTipo.setFont(new Font("Source Sans Pro Black", Font.BOLD, 16));
		lblTipo.setBounds(25, 207, 361, 21);
		contentPane.add(lblTipo);
		
		lblAutor = new JLabel("Autor: " + t.getResponsable());
		lblAutor.setFont(new Font("Source Sans Pro Black", Font.BOLD, 16));
		lblAutor.setBounds(25, 22, 361, 14);
		contentPane.add(lblAutor);
		
		label_Tiempo = new JLabel("Tiempo restante: " + t.getRestanteUltimo());
		label_Tiempo.setFont(new Font("Source Sans Pro Black", Font.BOLD, 16));
		label_Tiempo.setBounds(25, 130, 361, 21);
		contentPane.add(label_Tiempo);
		
		label_Estado = new JLabel("Estado: " + t.getEstado());
		label_Estado.setFont(new Font("Source Sans Pro Black", Font.BOLD, 16));
		label_Estado.setBounds(25, 171, 361, 14);
		contentPane.add(label_Estado);
		
		label_Descripcion = new JLabel("Descripción: " + t.getDescripcion());
		label_Descripcion.setVerticalTextPosition(SwingConstants.TOP);
		label_Descripcion.setVerticalAlignment(SwingConstants.TOP);
		label_Descripcion.setFont(new Font("Source Sans Pro Black", Font.BOLD, 16));
		label_Descripcion.setBounds(25, 243, 361, 103);
		contentPane.add(label_Descripcion);
	}
}
