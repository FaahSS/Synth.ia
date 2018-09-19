package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public Connection conectar() throws Exception {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "4682500");
	}



}
