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
