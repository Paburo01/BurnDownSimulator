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
	public JTextField IntroducirHorasRestantes;
	public JLabel lblNewLabel_2;
	public JComboBox comboBox;
	public JButton ActualizarTareaPasarDeDia;
	public JButton FinalizarPasarDeDia;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(64, 71, 61, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Horas restantes");
		lblNewLabel.setBounds(263, 46, 82, 14);
		contentPane.add(lblNewLabel);
		
		IntroducirHorasRestantes = new JTextField();
		IntroducirHorasRestantes.setBounds(259, 72, 86, 20);
		contentPane.add(IntroducirHorasRestantes);
		IntroducirHorasRestantes.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Dia Actual: ");
		lblNewLabel_1.setBounds(64, 161, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(155, 161, 82, 14);
		contentPane.add(lblNewLabel_2);
		
		ActualizarTareaPasarDeDia = new JButton("Actualizar Tarea");
		ActualizarTareaPasarDeDia.setBounds(263, 157, 129, 23);
		contentPane.add(ActualizarTareaPasarDeDia);
		
		FinalizarPasarDeDia = new JButton("Finalizar");
		FinalizarPasarDeDia.setBounds(306, 191, 86, 23);
		contentPane.add(FinalizarPasarDeDia);
	}
	


}
