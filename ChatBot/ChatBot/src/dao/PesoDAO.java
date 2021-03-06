package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Peso;
import connection.Conexao;

/**
 * Esta classe manipula a tabela T_SIC_PESO
 * possui m�todos para: Cadastrar, consultar, alterar e excluir
 * @author F�bio Salgarella
 * @version 1.0
 * @since 1.0
 * @see PesoBO
 * @see PesoBeans
 */
public class PesoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	/**
	 * Neste m�todo construtor, estabelecemos a comunica��o com o banco de dados.
	 * @author F�bio Salgarella
	 * @param n�o possui par�metros
	 * @eturn n�o h� retorno
	 * @throws Exception Chamada da exce��o checked SQLException
	 */
	
	public PesoDAO() throws Exception {
		con = new Conexao().conectar();
	}
	
	/**
	 * Respons�vel por adicionar uma linha na tabela T_SIC_PESO
	 * @param p Recebe um objeto do Tipo Peso Beans
	 * @return Uma string com a mensagem de confirma��o.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */

	public String gravar(Peso p) throws Exception{
		PreparedStatement stmt = con.prepareStatement("INSERT INTO T_SIC_PESO (CD_PESO, NR_PESO_GRAMATICA, NR_PESO_VOCABULARIO, NR_PESO_INTERPRETACAO, NR_PESO_IMERSAO) VALUES (?,?,?,?,?)");
		
		stmt.setInt(1, p.getCodigo());
		stmt.setInt(2, p.getGramatica());
		stmt.setInt(3, p.getVocabulario());
		stmt.setInt(4, p.getInterpretacao());
		stmt.setInt(5, p.getImersao());
		
		stmt.executeUpdate();
		
		return "Cadastrado com Sucesso!";
		
		
	}

	/**
	 * Respons�vel por consultar uma linha na tabela T_SIC_PESO
	 * @param numero Recebe um objeto do Tipo Integer.
	 * @return Uma ocorr�ncia na tabela T_SIC_PESO.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */

	public Peso consultarPorNumero(int numero) throws Exception{
		stmt = con.prepareStatement
				("SELECT * FROM T_SIC_PESO WHERE CD_PESO=?");
		
		stmt.setInt(1, numero);

		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return   new Peso(
							 rs.getInt("CD_PESO"),
							 rs.getInt("NR_PESO_GRAMATICA"),
							 rs.getInt("NR_PESO_VOCABULARIO"),
							 rs.getInt("NR_PESO_INTERPRETACAO"),
							 rs.getInt("NR_PESO_IMERSAO")
							);
		}else {
			return new Peso();
		}
	}


	/**
	 * Respons�vel por apagar uma linha na tabela T_SIC_PESO
	 * @param numero Recebe um objeto do Tipo Integer.
	 * @return O n�mero de linhas afetadas.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */

	public int apagar(int numero) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SIC_PESO WHERE CD_PESO=?");
		stmt.setInt(1, numero);
		return stmt.executeUpdate();
	}
	/**
	 * Respons�vel por alterar uma linha na tabela T_SIC_PESO
	 * @param p Recebe um objeto do Tipo Peso Beans.
	 * @return O n�mero de linhas alteradas.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	public String atualizar(Peso p) throws Exception {
		stmt = con.prepareStatement("UPDATE T_SIC_PESO SET NR_PESO_GRAMATICA=?, NR_PESO_VOCABULARIO=?, NR_PESO_INTERPRETACAO=?, NR_PESO_IMERSAO=? WHERE CD_PESO=?");
		stmt.setInt(5, p.getCodigo());
		stmt.setInt(1, p.getGramatica());
		stmt.setInt(2, p.getVocabulario());
		stmt.setInt(3, p.getInterpretacao());
		stmt.setInt(4, p.getImersao());
		
		return stmt.executeUpdate() + " linhas foram afetadas!";
	}
	
	/**
	 * Respons�vel por fechar conex�o com o banco
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	public void fechar() throws Exception {
		con.close();
	}
}
