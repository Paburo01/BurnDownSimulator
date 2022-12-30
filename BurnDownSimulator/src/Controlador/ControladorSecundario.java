package Controlador;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vista.CambiarDeDia;
import Vista.VistaPrincipal;
import Vista.VistaTareas;

import java.awt.event.ActionEvent;

public class ControladorSecundario implements ActionListener{
	
	private CambiarDeDia cambiarD=null;
	private ControladorPincipal controladorP;
	private VistaPrincipal vp;
	
	ControladorSecundario(){
		addListener();
	}
	
	ControladorSecundario(VistaPrincipal vp, CambiarDeDia cambiarD){
		this.cambiarD=cambiarD;
		this.vp=vp;
		addListener();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== cambiarD.ActualizarTareaPasarDeDia) {
			int seleccionComboBox=cambiarD.comboBox.getSelectedIndex();
			vp.tareas.get(seleccionComboBox).addRestante(vp.tareas.get(seleccionComboBox).getRestanteUltimo()- Integer.parseInt(cambiarD.IntroducirHorasRestantes.getText()) );
		}else if(e.getSource()== cambiarD.FinalizarPasarDeDia) {
			cambiarD.setVisible(false);
			
			for(int i=0; i<5 ; i++) {
				System.out.println(""+vp.tareas.get(i).getRestanteUltimo());
				
			}
			
			}
	}

	
	
	public void addListener(){
		if(cambiarD!=null) {
			cambiarD.ActualizarTareaPasarDeDia.addActionListener(this);
			cambiarD.FinalizarPasarDeDia.addActionListener(this);
		}
		
	}
}