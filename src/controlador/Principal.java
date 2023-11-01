package controlador;

import vista.*;

public class Principal {
	
	Coordinador miCoordinador;
	VentanaPrincipal miVentanaPrincipal;
	VentanaAlumno miVentanaAlumno;
	VentanaMateria miVentanaMateria;
	VentanaAlumnoBuscar miVentanaAlumnoBuscar;

	public static void main(String[] args) {
		Principal miPrincipal = new Principal();
		miPrincipal.iniciar();
	}

	//metodo iniciar
	private void iniciar() {
	
		//se crean los objetos
		miCoordinador = new Coordinador();
		miVentanaPrincipal = new VentanaPrincipal();
		miVentanaAlumno = new VentanaAlumno();
		miVentanaMateria = new VentanaMateria();
		miVentanaAlumnoBuscar = new VentanaAlumnoBuscar();
		
		//se relaciona el Coordinador con las clases
		miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setMiVentanaAlumno(miVentanaAlumno);
		miCoordinador.setMiVentanaMateria(miVentanaMateria);
		miCoordinador.setMiVentanaAlumnoBuscar(miVentanaAlumnoBuscar);
		
		//se relacionan las clases con el Coordinador
		miVentanaPrincipal.setMiCoordinador(miCoordinador);
		miVentanaAlumno.setMiCoordinador(miCoordinador);
		miVentanaMateria.setMiCoordinador(miCoordinador);
		miVentanaAlumnoBuscar.setMiCoordinador(miCoordinador);
		
		miVentanaPrincipal.setVisible(true);
		
		
		
	}

}
