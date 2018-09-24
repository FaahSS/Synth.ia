package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Endereco;
import connection.Conexao;

/**
 * Esta classe manipula a tabela T_SIC_ENDERECO
 * possui m�todos para: Cadastrar, consultar, alterar e excluir
 * @author F�bio Salgarella
 * @version 1.0
 * @since 1.0
 * @see EnderecoBO
 * @see EnderecoBeans
 */

public class EnderecoDAO {
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
	public EnderecoDAO() throws Exception {
		con = new Conexao().conectar();
	}
	
	/**
	 * Respons�vel por adicionar uma linha na tabela T_SIC_ENDERECO
	 * @param e Recebe um objeto do Tipo Endereco Beans
	 * @return Uma string com a mensagem de confirma��o.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */

	public String gravar(Endereco e) throws Exception{
		PreparedStatement stmt = con.prepareStatement("INSERT INTO T_SIC_ENDERECO (CD_ENDERECO, NR_CEP, DS_UF, DS_CIDADE, DS_LOGRADOURO, DS_NUMERO) VALUES (?,?,?,?,?,?)");
		
		stmt.setInt(1, e.getCodigo());
		stmt.setString(2, e.getCep());
		stmt.setString(3, e.getUf());
		stmt.setString(4, e.getCidade());
		stmt.setString(5, e.getLogradouro());
		stmt.setString(6, e.getNumero());
		
		stmt.executeUpdate();
		
		return "Cadastrado com Sucesso!";
		
		
	}

	/**
	 * Respons�vel por consultar uma linha na tabela T_SIC_ENDERECO
	 * @param numero Recebe um objeto do Tipo Integer.
	 * @return Uma ocorr�ncia na tabela T_SIC_ENDERECO.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */

	public Endereco consultarPorNumero(int numero) throws Exception{
		stmt = con.prepareStatement
				("SELECT * FROM T_SIC_ENDERECO WHERE CD_ENDERECO=?");
		
		stmt.setInt(1, numero);

		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Endereco
					(rs.getInt("CD_ENDERECO"),
				     rs.getString("NR_CEP"),
					 rs.getString("DS_UF"),
					 rs.getString("DS_CIDADE"),
					 rs.getString("DS_LOGRADOURO"),
					 rs.getString("DS_NUMERO")
							);
		}else {
			return new Endereco();
		}
	}


	/**
	 * Respons�vel por apagar uma linha na tabela T_SIC_ENDERECO
	 * @param numero Recebe um objeto do Tipo Integer.
	 * @return O n�mero de linhas afetadas.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */

	public int apagar(int numero) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SIC_ENDERECO WHERE CD_ENDERECO=?");
		stmt.setInt(1, numero);
		return stmt.executeUpdate();
	}
	/**
	 * Respons�vel por alterar uma linha na tabela T_SIC_ENDERECO
	 * @param e Recebe um objeto do Tipo Questao Beans.
	 * @return O n�mero de linhas alteradas.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	public String atualizar(Endereco e) throws Exception {
		stmt = con.prepareStatement("UPDATE T_SIC_ENDERECO SET NR_CEP=?, DS_UF=?, DS_CIDADE=?, DS_LOGRADOURO=?, DS_NUMERO=? WHERE CD_ENDERECO=?");
		stmt.setInt(6, e.getCodigo());
		stmt.setString(1, e.getCep());
		stmt.setString(2, e.getUf());
		stmt.setString(3, e.getCidade());
		stmt.setString(4, e.getLogradouro());
		stmt.setString(5, e.getNumero());
		
		return stmt.executeUpdate() + " linhas foram afetadas!";
	}
	
	public void fechar() throws Exception {
		con.close();
	}
}
