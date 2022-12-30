package Modelo;

import java.util.ArrayList;

public class Tarea {
	
	private int ID;
	private String tarea;
	private String tipo;
	private String estado;
	private String responsable;
	private ArrayList<Integer> restante;
	
	public Tarea() {
		this.restante = new ArrayList<Integer>();
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public ArrayList<Integer> getRestante() {
		return restante;
	}
	public int getRestante(int pos) {
		return restante.get(pos);
	}
	
	public int getRestanteUltimo() {
		return restante.get(restante.size()-1);
	}
	
	public void addRestante(int restante) {
		this.restante.add(restante);
	}
}
