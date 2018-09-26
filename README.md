# Synth.ia

ChatBot desenvolvido no ProjetoAM do Primeiro Ano do Curso de Análise e Desenvolvimento de Sistemas da FIAP.


# Classe Conexão
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public Connection conectar() throws Exception {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "usuario", "senha");
	}



}

# Classe Conexão Web/Servlet
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	String url = "jdbc:oracle:thin:@localhost:1521:xe"

	public Connection conectar() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, "usuario", "senha");
	}



}
