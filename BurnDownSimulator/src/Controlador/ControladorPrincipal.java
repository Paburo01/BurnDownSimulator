package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Vista.CambiarDeDia;
import Vista.EstablecerFechas;
import Vista.VistaGrafica;
import Vista.VistaNuevaPila;
import Vista.VistaPrincipal;
import Vista.VistaTareas;
import Vista.VisualizacionTarea;
import Modelo.Fecha;
import Modelo.Tarea;

public class ControladorPrincipal implements ActionListener {

	private VistaPrincipal vp;
	private int currentID;
	private CambiarDeDia cambiarD;
	private ControladorSecundario controladorS;
	private VistaTareas vTareas;
	private EstablecerFechas establecerF;
	private boolean pilaAbierta;
	private boolean primerPaso;
	private VistaNuevaPila vNueva;

	public ControladorPrincipal() {
		this.vp = new VistaPrincipal();
		this.cambiarD = new CambiarDeDia();
		this.vp.tareas = new ArrayList<>();
		vp.dibujarTabla();
		vp.frmBurndownsimulator.setVisible(true);
		addListener();
		currentID = 0;
		pilaAbierta = false;
		primerPaso = false;
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Abrir pila":

			boolean resultado = false;
			int check = 0;
			JFileChooser selector = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TSP", "tsp");
			selector.setFileFilter(filter);
			selector.setCurrentDirectory(new File(System.getProperty("user.dir")));

			int result = selector.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				File fichero = selector.getSelectedFile();
				String[] nombre = fichero.getName().split("\\.");

				if (nombre[1].equals("tsp")) {
					System.out.println("hola");
					try (FileReader fr = new FileReader(fichero); BufferedReader br = new BufferedReader(fr)) {
						String lineaActual;
						int lineasLeidas = 0;
						while ((lineaActual = br.readLine()) != null) {
							lineasLeidas++;
							String linea[] = lineaActual.split(" ");
							switch (linea[0]) {
							case "NAME:":
								vp.nombre = linea[1];
								check++;
								break;
							case "FECHA_DE_INICIO:":
								vp.FechaDeInicio.setFecha(Integer.parseInt(linea[1]), Integer.parseInt(linea[2]),
										Integer.parseInt(linea[3]));
								check++;
								break;
							case "DURACION:":
								vp.duracion = Integer.parseInt(linea[1]);
								check++;
								break;
							case "TAREAS:":
								check++;
								break;
							case "EOF":
								check++;
								break;

							default:
								String Tarea[] = lineaActual.split(" ");
								Tarea tarea = new Tarea();
								tarea.setID(Integer.parseInt(Tarea[0]));

								tarea.setTarea(Tarea[1]);
								tarea.setTipo(Tarea[2]);
								tarea.setEstado(Tarea[3]);
								tarea.setResponsable(Tarea[4]);

								ArrayList<Integer> horasRestantes = new ArrayList();
								String[] datos = Tarea[5].split(",");

								for (String dato1 : datos) {
									tarea.addRestante(Integer.parseInt(dato1));
								}

								vp.tareas.add(tarea);

								break;
							}
						}
						resultado = (check == 5);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} else if (result == JFileChooser.CANCEL_OPTION) {
				System.out.println("error" + "No se ha seleccionado ningún fichero.");
			}
			pilaAbierta = true;
			// System.out.print(" aqui "+vp.tareas.get(0).getTarea());
			vp.actualizarTabla();
			break;
		case "Añadir tarea":
			if (pilaAbierta) {
				if (!primerPaso) {
					vTareas = new VistaTareas();
					controladorS = new ControladorSecundario(vp, cambiarD, vTareas, currentID, vNueva);
					vTareas.setVisible(true);
					currentID++;
				} else
					JOptionPane.showMessageDialog(null,
							"No se pueden añadir tareas una vez se ha comenzado el proyecto", "Proyecto comenzado",
							JOptionPane.ERROR_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Debe abrir o crear una nueva pila para trabajar",
						"Pila inexistente", JOptionPane.ERROR_MESSAGE);
			break;
		case "Establecer fechas":
			if (pilaAbierta) {
				// date.parse(cadena de texto);
				establecerF = new EstablecerFechas();
				controladorS = new ControladorSecundario(vp, establecerF);
				establecerF.setVisible(true);
			} else
				JOptionPane.showMessageDialog(null, "Debe abrir o crear una nueva pila para trabajar",
						"Pila inexistente", JOptionPane.ERROR_MESSAGE);
			break;
		case "Guardar pila":
			if (pilaAbierta) {
				String datos = "NAME: " + vp.nombre + "\n" + "FECHA_DE_INICIO: " + vp.FechaDeInicio.getDia() + " "
						+ vp.FechaDeInicio.getMes() + " " + vp.FechaDeInicio.getAnio() + "\nDURACION: "
						+ vp.getDuracion() + "\nTAREAS: " + "\n";
				for (int i = 0; i < vp.tareas.size(); i++) {
					datos += vp.tareas.get(i).getID() + " " + vp.tareas.get(i).getTarea() + " "
							+ vp.tareas.get(i).getTipo() + " " + vp.tareas.get(i).getEstado() + " "
							+ vp.tareas.get(i).getResponsable() + " ";
					for (int j = 0; j < vp.tareas.get(i).getRestante().size(); j++) {
						datos += vp.tareas.get(i).getRestante().get(j);
						if (j + 1 < vp.tareas.get(i).getRestante().size()) {
							datos += ",";
						}

					}
					datos += "\n";
				}

				datos += "EOF";
				datos += "-1\n" + "EOF";

				File file = new File("./", vp.nombre + ".tsp");

				if (!file.exists()) {
					try {
						file.createNewFile();
						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(datos);
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			} else
				JOptionPane.showMessageDialog(null, "Debe abrir o crear una nueva pila para poder guardarla",
						"Pila inexistente", JOptionPane.ERROR_MESSAGE);
			break;
		case "Nueva pila":
			vNueva = new VistaNuevaPila();
			controladorS = new ControladorSecundario(vp, cambiarD, vTareas, currentID, vNueva);
			vNueva.setVisible(true);
			pilaAbierta = true;
			break;
		case "Pasar de día":
			if (pilaAbierta) {
				cambiarD = new CambiarDeDia();
				controladorS = new ControladorSecundario(vp, cambiarD, vTareas, currentID, vNueva);
				cambiarD.lblNewLabel_2.setText(vp.diaActual.toString());
				for (int i = 0; i < vp.tareas.size(); i++) {
					cambiarD.comboBox.addItem(vp.tareas.get(i).getTarea());
				}
				cambiarD.setVisible(true);
				vp.setDiaActual(vp.getDiaActual().diaSig());
				primerPaso = true;
			} else
				JOptionPane.showMessageDialog(null, "Debe abrir o crear una nueva pila para poder guardarla",
						"Pila inexistente", JOptionPane.ERROR_MESSAGE);
			break;
		case "Visualizar gráficos":
			if (pilaAbierta) {
				VistaGrafica f = new VistaGrafica(vp.FechaDeInicio, vp.duracion, vp.tareas, vp.diaActual);
				f.setVisible(true);
			} else
				JOptionPane.showMessageDialog(null, "Debe abrir o crear una nueva pila para poder guardarla",
						"Pila inexistente", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

	public void addListener() {
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
		for (int i = 0; i < vp.tareas.size(); i++) {
			System.out.print(" " + vp.tareas.get(i).getID() + "  " + vp.tareas.get(i).getTarea() + "   "
					+ vp.tareas.get(i).getTipo() + "   " + vp.tareas.get(i).getEstado() + "   "
					+ vp.tareas.get(i).getResponsable() + "  ");
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
