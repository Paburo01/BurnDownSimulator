package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.VistaPrincipal;

import Vista.VistaPrincipal;

public class ControladorPincipal implements ActionListener {
	
	private VistaPrincipal vp;
	
	public ControladorPincipal(){
		this.vp=new VistaPrincipal();
		vp.setSize(600, 400);
		vp.frmBurndownsimulator.setVisible(true);
		addListener();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()) {
			case "Abrir pila":
				break;
			case "Añadir Historia":
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
		vp.Anadir_Historia.addActionListener(this);
		vp.Establecer_Fechas.addActionListener(this);
		vp.Guardar_pila.addActionListener(this);
		vp.Nueva_pila.addActionListener(this);
		vp.Pasar_de_dia.addActionListener(this);
		vp.Visualizar_graficos.addActionListener(this);
	}
	
	
}
