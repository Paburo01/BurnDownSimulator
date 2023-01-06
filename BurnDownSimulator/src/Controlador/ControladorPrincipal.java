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
import javax.swing.filechooser.FileNameExtensionFilter;

import Vista.CambiarDeDia;
import Vista.EstablecerFechas;
import Vista.VistaGrafica;
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
	private Fecha inicio;
	private Fecha actual;
	
	public ControladorPrincipal(){
		this.vp = new VistaPrincipal();
		this.cambiarD= new CambiarDeDia();
		this.vp.tareas = new ArrayList<>();
		vp.dibujarTabla();
		vp.frmBurndownsimulator.setVisible(true);
		addListener();
		currentID = 0;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Abrir pila":
				
				boolean resultado = false;
		        int check = 0;
		        JFileChooser selector = new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("AUTO", "auto");
		        selector.setFileFilter(filter);
		        selector.setCurrentDirectory(new File(System.getProperty("user.dir")));

		        int result = selector.showOpenDialog(null);
				
		        if (result == JFileChooser.APPROVE_OPTION) {
		            File fichero = selector.getSelectedFile();
		            String[] nombre = fichero.getName().split("\\.");

		            if (nombre[1].equals("TSP")) {

		                    try (FileReader fr = new FileReader(fichero); BufferedReader br = new BufferedReader(fr)) {
		                        String lineaActual;
		                        int lineasLeidas = 0;
		                        while ((lineaActual = br.readLine()) != null) {
		                            lineasLeidas++;
		                            String linea[] = lineaActual.split(" ");
		                            switch (linea[0]) {
		                                case "NAME:":
		                                    vp.nombre=linea[1];
		                                    check++;
		                                    break;
		                                case "FECHA_DE_INICIO:":
		                                    vp.FechaDeInicio.setFecha(Integer.parseInt(linea[1]), Integer.parseInt(linea[2]), Integer.parseInt(linea[3]));
		                                    check++;
		                                    break;
		                                case "DURACION:":
		                                    vp.duracion=Integer.parseInt(linea[1]);
		                                    check++;
		                                    break;
		                                case "Tareas:":
		                                	
		                                	
		                                    check++;
		                                    break;
		                                case "FIN":
		                                    check++;
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
				
				
				break;
			case "Añadir tarea":
				vTareas = new VistaTareas();
				controladorS = new ControladorSecundario(vp, cambiarD, vTareas);
				vTareas.setVisible(true);
				break;
			case "Establecer fechas":
				//date.parse(cadena de texto);
				establecerF= new EstablecerFechas();
				controladorS = new ControladorSecundario(vp, establecerF);
				establecerF.setVisible(true);
				break;
			case "Guardar pila":
				String datos = 
				"NAME : " + vp.nombre+"\n"
				+"FECHA_DE_INICIO: " + vp.FechaDeInicio.getDia()+ vp.FechaDeInicio.getMes() + vp.FechaDeInicio.getAnio()
                + "\nDURACION: " + vp.getDuracion()
				 +"\nTAREAS: "+"\n";
				for(int i=0; i<vp.tareas.size();i++) {
						datos += vp.tareas.get(i).getID() + " - " + 
					    vp.tareas.get(i).getTarea() + " - " + 
						vp.tareas.get(i).getTipo() + " - " +
					    vp.tareas.get(i).getEstado() + " - " +
						vp.tareas.get(i).getResponsable() + " - ";
						for(int j=0; j<vp.tareas.get(i).getRestante().size() ;j++) {
							datos += vp.tareas.get(i).getRestante().get(j); 
							if(j+1<vp.tareas.get(i).getRestante().size()) {
								datos +=" * ";
							}
							
						}
						datos+="\n";
				}
				////
				datos += "-1\n"
		                + "EOF";
				
				File file = new File("./",vp.nombre+ ".tsp");
				
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
				
				
				break;
			case "Nueva pila":
				break;
			case "Pasar de día":
				cambiarD= new CambiarDeDia();
				controladorS= new ControladorSecundario(vp, cambiarD, vTareas);
				cambiarD.lblNewLabel_2.setText(vp.diaActual.toString());
				for(int i=0; i<vp.tareas.size(); i++) {
					cambiarD.comboBox.addItem(vp.tareas.get(i).getTarea());
				}
				cambiarD.setVisible(true);
				actual.diaSig();
				break;
			case "Visualizar gráficos":
				inicio = new Fecha(1,1,2023);
				actual = new Fecha (2,1,2023);
				VistaGrafica f = new VistaGrafica(inicio, 10, vp.tareas, actual);
				f.setVisible(true);
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


