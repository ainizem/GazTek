package model;

import java.sql.SQLException;

import model.ObjetoDTO;

public class AccesoBD2 extends AccesoBD {

	public AccesoBD2() throws ClassNotFoundException, SQLException {
		super(AccesoBD.DRIVER_MYSQL, "inventariobd", "root", "");
	}

}
