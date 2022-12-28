package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class VistaPrincipal extends javax.swing.JFrame{

	public JFrame frmBurndownsimulator;
	private JTable table;
	public JMenuItem Anadir_Historia;
	public JMenuItem Pasar_de_dia;
	public JMenuItem Visualizar_graficos;
	public JMenuItem Establecer_Fechas;
	public JMenuItem Nueva_pila;
	public JMenuItem Abrir_pila;
	public JMenuItem Guardar_pila;
	public JMenu mnNewMenu;
	

	/**
	 * Create the application.
	 */
	public VistaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBurndownsimulator = new JFrame();
		frmBurndownsimulator.setTitle("BurnDownSimulator");
		frmBurndownsimulator.setBounds(100, 100, 450, 300);
		frmBurndownsimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmBurndownsimulator.setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Funciones");
		menuBar.add(mnNewMenu);
		
	    Anadir_Historia = new JMenuItem("Añadir Historia");
		mnNewMenu.add(Anadir_Historia);
		
		
		Pasar_de_dia = new JMenuItem("Pasar de día");
		mnNewMenu.add(Pasar_de_dia);
		
		Visualizar_graficos = new JMenuItem("Visualizar gráficos");
		mnNewMenu.add(Visualizar_graficos);
		
		Establecer_Fechas = new JMenuItem("Establecer Fechas");
		mnNewMenu.add(Establecer_Fechas);
		
		JMenu mnNewMenu_1 = new JMenu("Archivos");
		menuBar.add(mnNewMenu_1);
		
		Nueva_pila = new JMenuItem("Nueva pila");
		mnNewMenu_1.add(Nueva_pila);
		
		Abrir_pila = new JMenuItem("Abrir pila");
		mnNewMenu_1.add(Abrir_pila);
		
		Guardar_pila = new JMenuItem("Guardar pila");
		mnNewMenu_1.add(Guardar_pila);
		
	    table = new JTable();
		frmBurndownsimulator.getContentPane().add(table, BorderLayout.CENTER);
		
		table = new JTable();
		frmBurndownsimulator.getContentPane().add(table, BorderLayout.CENTER);
	}

	
	
}
