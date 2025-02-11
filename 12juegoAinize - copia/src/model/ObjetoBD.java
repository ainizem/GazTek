package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class ObjetoBD extends AccesoBD {

	public ObjetoBD(String bd, String user, String pass, String tipoBD) {
		super(bd, user, pass, tipoBD);

	}

	public ArrayList<ObjetoDTO> getObjetos() {
		ArrayList<ObjetoDTO> resultado = new ArrayList<ObjetoDTO>();

		try {
			conectar();
			String sql = "SELECT * FROM inventario";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				ObjetoDTO objeto = new ObjetoDTO();
				objeto.setNombre(rs.getString("nombre"));
				objeto.setDescripcion(rs.getNString("descripcion"));

				resultado.add(objeto);

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		}
		return resultado;

	}
}
