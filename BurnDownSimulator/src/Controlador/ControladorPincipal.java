package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import Vista.VistaPrincipal;
import Modelo.Tarea;

public class ControladorPincipal implements ActionListener {
	
	private VistaPrincipal vp;
	private ArrayList<Tarea> tareas;
	private int currentID;
	
	public ControladorPincipal(){
		this.vp = new VistaPrincipal();
		this.tareas = new ArrayList<Tarea>();
		vp.frmBurndownsimulator.setVisible(true);
		addListener();
		currentID = 1;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Abrir pila":
				break;
			case "Añadir tarea":
				Tarea nueva = new Tarea();
				Scanner sc = new Scanner(System.in);
				Scanner num = new Scanner(System.in);
				nueva.setID(currentID++);
				System.out.println("Introduzca la descripción o nombre de la tarea: ");
				nueva.setTarea(sc.nextLine());
				System.out.println("Introduzca el tipo de la tarea (o -1 para dejar vacío): ");
				String tipo;
				tipo = sc.nextLine();
				if (tipo.equals("-1"))
					nueva.setTipo("Campo vacío");
				else nueva.setTipo(tipo);
				nueva.setEstado("Pendiente");
				System.out.println("Introduzca el responsable de la tarea: ");
				nueva.setResponsable(sc.nextLine());
				System.out.println("Introduzca el esfuerzo estimado de la tarea: ");
				nueva.addRestante(num.nextInt());
				tareas.add(nueva);
				mostrarTareas();
				break;
			case "Establecer Fechas":
				break;
			case "Guardar pila":
				break;
			case "Nueva pila":
				break;
			case "Pasar de día":
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
	}
	
	public void mostrarTareas() {
		System.out.println(" ID /        TAREA        /    TIPO    /  ESTADO  / RESPONSABLE /     ESFUERZO");
		for(int i = 0; i < tareas.size(); i++) {
			System.out.print(" " + tareas.get(i).getID() + "  " + tareas.get(i).getTarea() + "   " + tareas.get(i).getTipo() +
					"   " + tareas.get(i).getEstado() + "   " + tareas.get(i).getResponsable() + "  ");
			for (int j = 0; j < tareas.get(i).getRestante().size(); j++)
				System.out.print(tareas.get(i).getRestante(j) + " / ");
			System.out.println("");
		}
	}
}
