package controlador;

import vista.*;

public class Principal {
	
	Coordinador miCoordinador;
	VentanaPrincipal miVentanaPrincipal;
	VentanaAlumno miVentanaAlumno;
	VentanaMateria miVentanaMateria;

	public static void main(String[] args) {
		Principal miPrincipal = new Principal();
		miPrincipal.iniciar();
	}

	private void iniciar() {
	
		//se crean los objetos
		miCoordinador = new Coordinador();
		miVentanaPrincipal = new VentanaPrincipal();
		miVentanaAlumno = new VentanaAlumno();
		miVentanaMateria = new VentanaMateria();
		
		//se relaciona el Coordinador con las clases
		miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setMiVentanaAlumno(miVentanaAlumno);
		miCoordinador.setMiVentanaMateria(miVentanaMateria);
		
		//se relacionan las clases con el Coordinador
		miVentanaPrincipal.setMiCoordinador(miCoordinador);
		miVentanaAlumno.setMiCoordinador(miCoordinador);
		miVentanaMateria.setMiCoordinador(miCoordinador);
		
		miVentanaPrincipal.setVisible(true);
		
		
		
	}

}
