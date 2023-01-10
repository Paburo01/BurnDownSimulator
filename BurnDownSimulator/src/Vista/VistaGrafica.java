package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Fecha;
import Modelo.Tarea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingConstants;

public class VistaGrafica extends JFrame {

	public JPanel contentPane;
	public JLabel lblNewLabel;
	public ArrayList<Tarea> tareas;
	public Fecha inicial;
	public Fecha actual;
	public int limite;

	public VistaGrafica(Fecha inicial, int dias, ArrayList<Tarea> tareas, Fecha actual) {
		this.tareas = tareas;
		this.inicial = inicial;
		this.limite = dias;
		this.actual = actual;
		repaint();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*lblNewLabel = new JLabel("PROGRESO DÍAS " + Integer.toString(inicial.get(Calendar.DATE)) + "/" + 
				Integer.toString(inicial.get(Calendar.MONTH)) + "/" + Integer.toString(inicial.get(Calendar.YEAR)) + " - "
				+ Integer.toString(actual.get(Calendar.DATE)) + "/" + (Integer.toString(actual.get(Calendar.MONTH)) + 1) + "/" +
				Integer.toString(actual.get(Calendar.YEAR)));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Source Sans Pro Black", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 564, 29);
		contentPane.add(lblNewLabel);*/
	}

	public void paint(Graphics g) {
		int cantidadAnterior = 0;
		g.setColor(Color.black);
		g.drawLine(50,80,50,300);
		g.drawLine(50, 300, 550, 300);
		g.drawString("PROGRESO DÍAS " + inicial.getDia() + "/" + inicial.getMes() + 
				"/" + inicial.getAnio() + " - " + actual.getDia() + "/" + 
				actual.getMes() + "/" + actual.getAnio(), 180, 65);
		for (int i = 0; i < limite; i++)
			g.drawLine(50+(550/limite)*i, 300, 50+(550/limite)*i, 305);
		g.setColor(Color.orange);
		int total = 0;
		for (int j = 0; j < tareas.size(); j++)
			total += tareas.get(j).getRestante(0);
		g.drawLine(50, 300-(total), 50+(550/limite)*(limite-1), 300);
		g.drawString("Progresión ideal", 50, 330);
		g.setColor(Color.green);
		g.drawString("Progresión actual", 50, 360);
		int diastranscurridos = actual.getNumDiasTotales() - inicial.getNumDiasTotales() + 1;
		for	(int i = 0; i < diastranscurridos; i++) {
			int cantidad = 0;
			for (int j = 0; j < tareas.size(); j++)
				cantidad += tareas.get(j).getRestante(i);
			g.drawOval(50+(550/limite)*i, 300-cantidad, 5, 5);
			if (i == 0)
				cantidadAnterior = cantidad;
			if (i != 0) {
				g.drawLine(50+(550/limite)*(i-1), 300-cantidadAnterior, 50+(550/limite)*i, 300-cantidad);
				cantidadAnterior = cantidad;
			}
		}
	}
	
}
