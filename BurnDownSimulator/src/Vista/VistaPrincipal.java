package Vista;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.util.ArrayList;

import Modelo.Tarea;
public class VistaPrincipal extends javax.swing.JFrame{

	public JFrame frmBurndownsimulator;
	public JMenuItem Anadir_tarea;
	public JMenuItem Pasar_de_dia;
	public JMenuItem Visualizar_graficos;
	public JMenuItem Establecer_fechas;
	public JMenuItem Nueva_pila;
	public JMenuItem Abrir_pila;
	public JMenuItem Guardar_pila;
	public JMenu mnNewMenu;
	public JTable table;
	public DefaultTableModel modeloTabla;
	public ArrayList<Tarea> tareas;
	public String diaActual;
	
	
	/**
	 * Create the application.
	 */
	public VistaPrincipal() {
		//prueba---borrar
		diaActual="22/12/22";
		//------------------
		modeloTabla = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
		tareas= new ArrayList<>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBurndownsimulator = new JFrame();
		frmBurndownsimulator.setTitle("BurnDownSimulator");
		frmBurndownsimulator.setBounds(100, 100, 800, 600);
		frmBurndownsimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmBurndownsimulator.setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Funciones");
		menuBar.add(mnNewMenu);
		
	    Anadir_tarea = new JMenuItem("Añadir tarea");
		mnNewMenu.add(Anadir_tarea);
		
		Pasar_de_dia = new JMenuItem("Pasar de día");
		mnNewMenu.add(Pasar_de_dia);
		
		Visualizar_graficos = new JMenuItem("Visualizar gráficos");
		mnNewMenu.add(Visualizar_graficos);
		
		Establecer_fechas = new JMenuItem("Establecer fechas");
		mnNewMenu.add(Establecer_fechas);
		
		JMenu mnNewMenu_1 = new JMenu("Archivos");
		menuBar.add(mnNewMenu_1);
		
		Nueva_pila = new JMenuItem("Nueva pila");
		mnNewMenu_1.add(Nueva_pila);
		
		Abrir_pila = new JMenuItem("Abrir pila");
		mnNewMenu_1.add(Abrir_pila);
		
		Guardar_pila = new JMenuItem("Guardar pila");
		mnNewMenu_1.add(Guardar_pila);
		
		table = new JTable();
		table.setModel(modeloTabla);
        
		frmBurndownsimulator.getContentPane().add(table, BorderLayout.CENTER);
		
	}
	
	public void dibujarTabla() {
		String[] columnasTabla = {"ID","Tarea","Tipo","Estado","Responsable","Tiempo restante"};
        modeloTabla.setColumnIdentifiers(columnasTabla);
        
        table.getTableHeader().setResizingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);

        modeloTabla.addRow(columnasTabla);
	}
	
	public void actualizarTabla() {
		while (modeloTabla.getRowCount() > 1)
			modeloTabla.removeRow(1);
		
		Object[] fila = new Object[6];
        for (int i = 0; i < tareas.size(); i++) {
        	fila[0] = tareas.get(i).getID();
        	fila[1] = tareas.get(i).getTarea();
        	fila[2] = tareas.get(i).getTipo();
        	fila[3] = tareas.get(i).getEstado();
        	fila[4] = tareas.get(i).getResponsable();
        	String tiempo = "";
        	for (int j = 0; j < tareas.get(i).getRestante().size(); j++)
        		tiempo += tareas.get(i).getRestante(j) + " | ";
        	fila[5] = tiempo;
        	modeloTabla.addRow(fila);
        }
	}
}
