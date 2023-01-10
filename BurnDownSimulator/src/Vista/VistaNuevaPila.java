package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class VistaNuevaPila extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JDateChooser dateChooser;
	public JButton btnNewButton;

	public VistaNuevaPila() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 381, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Día de inicio: ");
		lblNewLabel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 34, 170, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Duración:");
		lblNewLabel_1.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 85, 112, 13);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(127, 83, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Crear pila");
		btnNewButton.setActionCommand("Crear_pila");
		btnNewButton.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(233, 81, 96, 21);
		contentPane.add(btnNewButton);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(127, 34, 202, 19);
		contentPane.add(dateChooser);
	}
}
