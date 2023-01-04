package Controlador;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import Modelo.Tarea;
import Vista.CambiarDeDia;
import Vista.EstablecerFechas;
import Vista.VistaPrincipal;
import Vista.VistaTareas;

import java.awt.event.ActionEvent;

public class ControladorSecundario implements ActionListener {

	private CambiarDeDia cambiarD = null;
	private VistaTareas vTareas;
	private VistaPrincipal vp;
	private int currentID;
	private ArrayList<Integer> modded;
	private EstablecerFechas establecerF;

	ControladorSecundario() {
		addListener();
		modded = new ArrayList<Integer>();
		currentID = 0;
	}

	ControladorSecundario(VistaPrincipal vp, CambiarDeDia cambiarD, VistaTareas vTareas) {
		this.cambiarD = cambiarD;
		this.vp = vp;
		this.vTareas = vTareas;
		modded = new ArrayList<Integer>();
		addListener();
	}
	
	ControladorSecundario(VistaPrincipal vp, EstablecerFechas establecerF) {
		this.establecerF = establecerF;
		this.vp = vp;
		modded = new ArrayList<Integer>();
		addListener();
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Finalizar":
			cambiarD.setVisible(false);
			for (int i = 0; i < vp.tareas.size(); i++)
				if (!modded.contains(i))
					vp.tareas.get(i).addRestante(vp.tareas.get(i).getRestanteUltimo());
			vp.actualizarTabla();
			break;
		case "Actualizar Tarea":
			int seleccionComboBox = cambiarD.comboBox.getSelectedIndex();
			if(Integer.parseInt(cambiarD.IntroducirHorasRestantes.getText()) < vp.tareas.get(seleccionComboBox).getRestanteUltimo()) {
				cambiarD.comboBox.removeItemAt(seleccionComboBox);
				if (!modded.contains(seleccionComboBox)) {
					vp.tareas.get(seleccionComboBox)
							.addRestante(Integer.parseInt(cambiarD.IntroducirHorasRestantes.getText()));
					modded.add(seleccionComboBox);
					if (Integer.parseInt(cambiarD.IntroducirHorasRestantes.getText()) == 0)
						vp.tareas.get(seleccionComboBox).setEstado("Finalizado");
					else vp.tareas.get(seleccionComboBox).setEstado("En progreso");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Las horas introducidas tiene que ser menor que las horas que le quedan a la tarea",
						"Error horas", JOptionPane.ERROR_MESSAGE);
			}
			
			break;
		case "boton_enviar":
			if (vTareas.campo_responsable.getText().equals("") || vTareas.campo_esfuerzo.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Los campos Responsable y Esfuerzo son obligatorios",
						"Campos vacíos", JOptionPane.ERROR_MESSAGE);
			} else {
				Tarea nueva = new Tarea();
				nueva.setID(currentID++);
				nueva.setTarea(vTareas.campo_nombre.getText());
				nueva.setTipo(vTareas.campo_tipo.getText());
				nueva.setEstado("Pendiente");
				nueva.setResponsable(vTareas.campo_responsable.getText());
				nueva.setDescripcion(vTareas.campo_descripcion.getText());
				nueva.addRestante(Integer.parseInt(vTareas.campo_esfuerzo.getText()));
				vp.tareas.add(nueva);
				vp.actualizarTabla();
			}
			vTareas.setVisible(false);
			break;
			
		case "Aceptar":
			int anio = establecerF.dateChooser.getCalendar().get(java.util.Calendar.YEAR);
			int mes = establecerF.dateChooser.getCalendar().get(java.util.Calendar.MONTH)+1;
			int dia = establecerF.dateChooser.getCalendar().get(java.util.Calendar.DATE);
			String fechaAct=dia+"/"+mes+"/"+anio;
			vp.setDiaActual(fechaAct);
			vp.FechaDeInicio=fechaAct;
			vp.setDuracion( Integer.parseInt(establecerF.textField.getText()) );
			establecerF.setVisible(false);
			break;
		}
	}

	public void addListener() {
		if (vTareas != null)
			vTareas.boton_enviar.addActionListener(this);
		if (cambiarD != null) {
			cambiarD.ActualizarTareaPasarDeDia.addActionListener(this);
			cambiarD.FinalizarPasarDeDia.addActionListener(this);
		}
		if(establecerF != null) {
			establecerF.btnNewButton.addActionListener(this);
		}
	}
}