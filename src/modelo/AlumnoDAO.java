package modelo;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AlumnoDAO {

	public void guardarAlumno(AlumnoVO miAlumnoVO) {
		try{
			Conexion conex = new Conexion();
			Statement estatuto=conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO alumno VALUES ('"+miAlumnoVO.getDni()+"','"+miAlumnoVO.getNom()+"','"+
			miAlumnoVO.getFnac()+"','"+miAlumnoVO.getDoc()+"')");
			
			JOptionPane.showMessageDialog(null, "Se registró");
			estatuto.close();
			conex.desconectar();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "No se registró");
		}
		
	}

}
