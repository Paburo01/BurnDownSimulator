package Controlador;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.Tarea;
import Vista.CambiarDeDia;
import Vista.VistaPrincipal;
import Vista.VistaTareas;

import java.awt.event.ActionEvent;

public class ControladorSecundario implements ActionListener {

	private CambiarDeDia cambiarD = null;
	private VistaTareas vTareas;
	private VistaPrincipal vp;
	private int currentID;

	ControladorSecundario() {
		addListener();
		currentID = 0;
	}

	ControladorSecundario(VistaPrincipal vp, CambiarDeDia cambiarD, VistaTareas vTareas) {
		this.cambiarD = cambiarD;
		this.vp = vp;
		this.vTareas = vTareas;
		addListener();
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Finalizar":
			cambiarD.setVisible(false);
			for (int i = 0; i < vp.tareas.size(); i++) {
				System.out.println("" + vp.tareas.get(i).getRestanteUltimo());
			}
			break;
		case "Actualizar Tarea":
			int seleccionComboBox = cambiarD.comboBox.getSelectedIndex();
			vp.tareas.get(seleccionComboBox).addRestante(Integer.parseInt(cambiarD.IntroducirHorasRestantes.getText()));
			break;
		case "boton_enviar":
			if (vTareas.campo_responsable.getText().equals("") || vTareas.campo_esfuerzo.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Los campos Responsable y Esfuerzo son obligatorios", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
			}
			else {
				Tarea nueva = new Tarea();
				nueva.setID(currentID++);
				nueva.setTarea(vTareas.campo_nombre.getText());
				nueva.setTipo(vTareas.campo_tipo.getText());
				nueva.setEstado("Pendiente");
				nueva.setResponsable(vTareas.campo_responsable.getText());
				nueva.setDescripcion(vTareas.campo_descripcion.getText());
				nueva.addRestante(Integer.parseInt(vTareas.campo_esfuerzo.getText()));
				vp.tareas.add(nueva);
			}
			vTareas.setVisible(false);
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
	}
}