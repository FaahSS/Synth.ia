package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Endereco;
import beans.Nivelamento;
import beans.Questao;
import beans.Usuario;
import bo.NivelamentoBO;
import connection.Conexao;

/**
 * Esta classe manipula a tabela T_SIC_NIVELAMENTO
 * possui m�todos para: Cadastrar, consultar, alterar e excluir
 * @author F�bio Salgarella
 * @version 1.0
 * @since 1.0
 * @see NivelamentoBO
 * @see NivelamentoBeans
 */
public class NivelamentoDAO {
	
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
	
	public NivelamentoDAO() throws Exception {
		con = new Conexao().conectar();
	}
	
	
	public String gravarNivQuest(Nivelamento n, Questao q) throws Exception {
		stmt = con.prepareStatement("INSERT INTO T_SIC_NIVELAMENTO_QUESTAO (CD_NIVELAMENTO, CD_USUARIO, CD_QUESTAO) VALUES (?, ?, ?)");
		stmt.setInt(1, n.getCodigo());
		stmt.setInt(2, n.getCodigoUsuario().getCodigo());
		stmt.setInt(3, q.getCodigo());
		
		stmt.executeUpdate();
		
		return "Nivelamento / Quest�o Cadastrado com Sucesso!";
	}
	/**
	 * Respons�vel por adicionar uma linha na tabela T_SIC_NIVELAMENTO
	 * @param n Recebe um objeto do Tipo Nivelamento Beans
	 * @return Uma string com a mensagem de confirma��o.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	
	public String gravar(Nivelamento n) throws Exception{
		PreparedStatement stmt = con.prepareStatement("INSERT INTO T_SIC_NIVELAMENTO (CD_NIVELAMENTO, NR_ACERTO, DT_NIVELAMENTO"
				+ ", DS_TIPO, CD_USUARIO) VALUES (?,?,TO_DATE(?,'DD/MM/YYYY'),?,?)");
		
		stmt.setInt(1, n.getCodigo());
		stmt.setInt(2, n.getAcerto());
		stmt.setString(3, n.getData());
		stmt.setString(4, n.getTipo());
		stmt.setInt(5, n.getCodigoUsuario().getCodigo());
		
		stmt.executeUpdate();
		
		return "Cadastrado com Sucesso!";
		
		
	}
	
	/**
	 * Respons�vel por consultar uma linha na tabela T_SIC_NIVELAMENTO
	 * @param numero Recebe um objeto do Tipo Integer.
	 * @return Uma ocorr�ncia na tabela T_SIC_NIVELAMENTO.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	
	public Nivelamento consultarPorNumero(int numero) throws Exception{
		stmt = con.prepareStatement
				("SELECT* FROM T_SIC_NIVELAMENTO INNER JOIN T_SIC_USUARIO ON (T_SIC_NIVELAMENTO.CD_USUARIO = T_SIC_USUARIO.CD_USUARIO) INNER JOIN T_SIC_ENDERECO ON (T_SIC_USUARIO.CD_ENDERECO = T_SIC_ENDERECO.CD_ENDERECO) WHERE CD_NIVELAMENTO=?");
		
		stmt.setInt(1, numero);
	
		rs = stmt.executeQuery();
		
		if(rs.next()) {	
			return  new Nivelamento
					(rs.getInt("CD_NIVELAMENTO"),
					 rs.getInt("NR_ACERTO"),
					 rs.getString("DT_NIVELAMENTO"),
					 rs.getString("DS_TIPO"),
					new Usuario
					(rs.getInt("NR_CLIENTE"),
				     rs.getString("NM_CLIENTE"),
					 rs.getString("DS_EMAIL"),
					 rs.getString("DS_SENHA"),
					 rs.getString("DS_SEXO"),
					 rs.getString("DT_NASCIMENTO"),
					 rs.getString("NR_CPF"),
					 rs.getInt("NR_TIPO"),
					 new Endereco(
								rs.getInt("CD_ENDERECO"),
								rs.getString("NR_CEP"),
								rs.getString("DS_UF"),
								rs.getString("DS_CIDADE"),
								rs.getString("DS_LOGRADOURO"),
								rs.getString("DS_NUMERO")
								))
							);
		}else {
			return new Nivelamento();
		}
	}
	
	
	/**
	 * Respons�vel por apagar uma linha na tabela T_SIC_NIVELAMENTO
	 * @param numero Recebe um objeto do Tipo Integer.
	 * @return O n�mero de linhas afetadas.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	
	public int apagar(int numero) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SIC_NIVELAMENTO WHERE CD_NIVELAMENTO=?");
		stmt.setInt(1, numero);
		return stmt.executeUpdate();
	}
	/**
	 * Respons�vel por atualizar uma linha na tabela T_SIC_NIVELAMENTO
	 * @param n Recebe um objeto do Tipo Nivelamento Beans.
	 * @return O n�mero de linhas alteradas.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	public String atualizar(Nivelamento n) throws Exception {
		stmt = con.prepareStatement("UPDATE T_SIC_NIVELAMENTO SET NR_ACERTO=?, DT_NIVELAMENTO=?, DS_TIPO=?, CD_USUARIO=? WHERE CD_NIVELAMENTO=?");
		stmt.setInt(5, n.getCodigo());
		stmt.setInt(1, n.getAcerto());
		stmt.setString(2, n.getData());
		stmt.setString(3, n.getTipo());
		stmt.setInt(4, n.getCodigoUsuario().getCodigo());
		
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
