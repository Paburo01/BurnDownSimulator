package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class EstablecerFechas extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JDateChooser dateChooser;
	public JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstablecerFechas frame = new EstablecerFechas();
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
	public EstablecerFechas() {
		setTitle("Establecer Fechas");
		setBounds(100, 100, 351, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha de inicio");
		lblNewLabel.setBounds(69, 70, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Duracion");
		lblNewLabel_1.setBounds(95, 110, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(172, 107, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(172, 148, 89, 23);
		contentPane.add(btnNewButton);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(172, 70, 86, 20);
		contentPane.add(dateChooser);
	}
	
}
