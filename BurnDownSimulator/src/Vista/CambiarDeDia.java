package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CambiarDeDia extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambiarDeDia frame = new CambiarDeDia();
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
	public CambiarDeDia() {
		setTitle("Cambiar de dia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(84, 46, 30, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Horas restantes");
		lblNewLabel.setBounds(263, 46, 82, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(259, 72, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Dia Actual: ");
		lblNewLabel_1.setBounds(84, 161, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(155, 161, 82, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton aceptarPasarDeDia = new JButton("Aceptar");
		aceptarPasarDeDia.setBounds(263, 157, 89, 23);
		contentPane.add(aceptarPasarDeDia);
	}
	
}
