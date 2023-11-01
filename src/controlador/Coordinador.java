package controlador;

import vista.VentanaAlumno;
import vista.VentanaAlumnoBuscar;
import vista.VentanaMateria;
import vista.VentanaPrincipal;

public class Coordinador {

	VentanaPrincipal miVentanaPrincipal;
	VentanaAlumno miVentanaAlumno;
	VentanaMateria miVentanaMateria;
	VentanaAlumnoBuscar miVentanaAlumnoBuscar;
	
	public VentanaAlumnoBuscar getMiVentanaAlumnoBuscar() {
		return miVentanaAlumnoBuscar;
	}
	public void setMiVentanaAlumnoBuscar(VentanaAlumnoBuscar miVentanaAlumnoBuscar) {
		this.miVentanaAlumnoBuscar = miVentanaAlumnoBuscar;
	}
	public VentanaMateria getMiVentanaMateria() {
		return miVentanaMateria;
	}
	public void setMiVentanaMateria(VentanaMateria miVentanaMateria) {
		this.miVentanaMateria = miVentanaMateria;
	}
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaAlumno getMiVentanaAlumno() {
		return miVentanaAlumno;
	}
	public void setMiVentanaAlumno(VentanaAlumno miVentanaAlumno) {
		this.miVentanaAlumno = miVentanaAlumno;
	}
	
	//Mostrar Ventanas
	public void mostrarVentanaAlumno() {
		miVentanaAlumno.setVisible(true);
		
	}
	public void mostrarVentanaAlumnoBuscar() {
		miVentanaAlumnoBuscar.setVisible(true);
		
	}
	
}
