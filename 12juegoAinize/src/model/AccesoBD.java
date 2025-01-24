package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBD {

	public static final String DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";
	public static final String DRIVER_GENERICO = "sun.jdbc.odbc.JdbcOdbc.Driver";

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	

	// vars conexion
	String bd, user, pass;
	String tipoBD;

	public AccesoBD( String tipoBD, String bd, String user, String pass) {
		super();
		this.bd = bd;
		this.user = user;
		this.pass = pass;
		this.tipoBD = tipoBD;
	}

	public void conectar() throws ClassNotFoundException, SQLException {

		Class.forName(tipoBD);

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+bd, user, pass);
		System.out.println("Conexión establecida");

		st = con.createStatement();
	}

}
