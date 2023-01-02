package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import Vista.CambiarDeDia;
import Vista.EstablecerFechas;
import Vista.VistaPrincipal;
import Vista.VistaTareas;
import Vista.VisualizacionTarea;
import Modelo.Tarea;

public class ControladorPincipal implements ActionListener {
	
	private VistaPrincipal vp;
	private int currentID;
	private CambiarDeDia cambiarD;
	private ControladorSecundario controladorS;
	private VistaTareas vTareas;
	private EstablecerFechas establecerF;
	
	public ControladorPincipal(){
		this.vp = new VistaPrincipal();
		this.cambiarD= new CambiarDeDia();
		this.vp.tareas = new ArrayList<>();
		for(int i=0 ; i<5; i++) {
			Tarea t=new Tarea();
			t.setTarea(i+" tarea");
			t.addRestante(20);
			vp.tareas.add(t);
		}
		vp.dibujarTabla();
		vp.frmBurndownsimulator.setVisible(true);
		addListener();
		currentID = 0;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Abrir pila":
				break;
			case "Añadir tarea":
				vTareas = new VistaTareas();
				controladorS = new ControladorSecundario(vp, cambiarD, vTareas);
				vTareas.setVisible(true);
				break;				
			case "Establecer fechas":
				establecerF= new EstablecerFechas();
				controladorS = new ControladorSecundario(vp, establecerF);
				establecerF.setVisible(true);
				break;
			case "Guardar pila":
				break;
			case "Nueva pila":
				break;
			case "Pasar de día":
				cambiarD= new CambiarDeDia();
				controladorS= new ControladorSecundario(vp, cambiarD, vTareas);
				cambiarD.lblNewLabel_2.setText(vp.getDiaActual());
				for(int i=0; i<vp.tareas.size(); i++) {
					cambiarD.comboBox.addItem(vp.tareas.get(i).getTarea());
				}
				cambiarD.setVisible(true);
				break;
			case "Visualizar gráficos":
				
				break;
		}
	}
	
	public void addListener(){
		vp.Abrir_pila.addActionListener(this);
		vp.Anadir_tarea.addActionListener(this);
		vp.Establecer_fechas.addActionListener(this);
		vp.Guardar_pila.addActionListener(this);
		vp.Nueva_pila.addActionListener(this);
		vp.Pasar_de_dia.addActionListener(this);
		vp.Visualizar_graficos.addActionListener(this);
		vp.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				clickadoTabla(evt);
			}
		});
	}
	
	public void mostrarTareas() {
		System.out.println(" ID /        TAREA        /    TIPO    /  ESTADO  / RESPONSABLE /     ESFUERZO");
		for(int i = 0; i < vp.tareas.size(); i++) {
			System.out.print(" " + vp.tareas.get(i).getID() + "  " + vp.tareas.get(i).getTarea() + "   " + vp.tareas.get(i).getTipo() +
					"   " + vp.tareas.get(i).getEstado() + "   " + vp.tareas.get(i).getResponsable() + "  ");
			for (int j = 0; j < vp.tareas.get(i).getRestante().size(); j++)
				System.out.print(vp.tareas.get(i).getRestante(j) + " / ");
			System.out.println("");
		}
	}
	
	public void clickadoTabla(MouseEvent evt) {
		if (vp.table.getSelectedRow() != 0) {
			VisualizacionTarea t = new VisualizacionTarea(vp.tareas.get(vp.table.getSelectedRow() - 1));
			t.setVisible(true);
		}
	}
}


