package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Peso;
import beans.Questao;
import connection.Conexao;

/**
 * Esta classe manipula a tabela T_SIC_QUESTAO
 * possui m�todos para: Cadastrar, consultar, alterar e excluir
 * @author F�bio Salgarella
 * @version 1.0
 * @since 1.0
 * @see QuestaoBO
 * @see QuestaoBeans
 */
public class QuestaoDAO {
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

	public QuestaoDAO() throws Exception {
		con = new Conexao().conectar();
	}


	/**
	 * Respons�vel por adicionar uma linha na tabela T_SIC_QUESTAO
	 * @param q Recebe um objeto do Tipo Questao Beans
	 * @return Uma string com a mensagem de confirma��o.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */

	public String gravar(Questao q) throws Exception{
		PreparedStatement stmt = con.prepareStatement("INSERT INTO T_SIC_QUESTAO (CD_QUESTAO, DS_TIPO, DS_ENUNCIADO, DS_GABARITO, DS_ALTERNATIVA, CD_PESO) VALUES (?,?,?,?,?,?)");

		stmt.setInt(1, q.getCodigo());
		stmt.setInt(2, q.getTipo());
		stmt.setString(3, q.getEnunciado());
		stmt.setString(4, q.getGabarito());
		stmt.setString(5, q.getAlternativa());
		stmt.setInt(6, q.getPeso().getCodigo());

		stmt.executeUpdate();

		return "Cadastrado com Sucesso!";


	}

	/**
	 * Respons�vel por consultar uma linha na tabela T_SIC_QUESTAO
	 * @param numero Recebe um objeto do Tipo Integer.
	 * @return Uma ocorr�ncia na tabela T_SIC_QUESTAO.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */

	public Questao consultarPorNumero(int numero) throws Exception{
		stmt = con.prepareStatement
				("SELECT * FROM T_SIC_QUESTAO INNER JOIN T_SIC_PESO ON (T_SIC_QUESTAO.CD_PESO = T_SIC_PESO.CD_PESO) WHERE CD_QUESTAO=?");

		stmt.setInt(1, numero);

		rs = stmt.executeQuery();

		if(rs.next()) {
			return new Questao
					(rs.getInt("CD_QUESTAO"),
							rs.getInt("DS_TIPO"),
							rs.getString("DS_ENUNCIADO"),
							rs.getString("DS_GABARITO"),
							rs.getString("DS_ALTERNATIVA"),
							new Peso(
									rs.getInt("CD_PESO"),
									rs.getInt("NR_NIVEL_GRAMATICA"),
									rs.getInt("NR_NIVEL_VOCABULARIO"),
									rs.getInt("NR_NIVEL_INTERPRETACAO"),
									rs.getInt("NR_NIVEL_IMERSAO"))
							);
		}else {
			return new Questao();
		}
	}


	/**
	 * Respons�vel por apagar uma linha na tabela T_SIC_QUESTAO
	 * @param numero Recebe um objeto do Tipo Integer.
	 * @return O n�mero de linhas afetadas.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */

	public int apagar(int numero) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SIC_QUESTAO WHERE CD_QUESTAO=?");
		stmt.setInt(1, numero);
		return stmt.executeUpdate();
	}
	/**
	 * Respons�vel por alterar uma linha na tabela T_SIC_QUESTAO
	 * @param q Recebe um objeto do Tipo Questao Beans.
	 * @return O n�mero de linhas alteradas.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	public String atualizar(Questao q) throws Exception {
		stmt = con.prepareStatement("UPDATE T_SIC_QUESTAO SET DS_TIPO=?, DS_ENUNCIADO=?, DS_GABARITO=?, DS_ALTERNATIVA=?, CD_PESO=? WHERE CD_QUESTAO=?");
		stmt.setInt(6, q.getCodigo());
		stmt.setInt(1, q.getTipo());
		stmt.setString(2, q.getEnunciado());
		stmt.setString(3, q.getGabarito());
		stmt.setString(4, q.getAlternativa());
		stmt.setInt(5, q.getPeso().getCodigo());

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
