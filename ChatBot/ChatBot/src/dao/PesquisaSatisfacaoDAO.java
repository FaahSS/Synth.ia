package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Endereco;
import beans.PesquisaSatisfacao;
import beans.Usuario;
import bo.PesquisaSatisfacaoBO;
import connection.Conexao;

/**
 * Esta classe manipula a tabela T_SIC_PESQUISA_SATISFACAO
 * possui m�todos para: Cadastrar, consultar, alterar e excluir
 * @author F�bio Salgarella
 * @version 1.0
 * @since 1.0
 * @see PesquisaSatisfacaoBO
 * @see PesquisaSatisfacaoBeans
 */

public class PesquisaSatisfacaoDAO {
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
	public PesquisaSatisfacaoDAO() throws Exception {
		con = new Conexao().conectar();
	}
	
	/**
	 * Respons�vel por adicionar uma linha na tabela T_SIC_PESQUISA_SATISFACAO
	 * @param p Recebe um objeto do Tipo PesquisaSatisfacao Beans
	 * @return Uma string com a mensagem de confirma��o.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */

	public String gravar(PesquisaSatisfacao p) throws Exception{
		PreparedStatement stmt = con.prepareStatement("INSERT INTO T_SIC_PESQUISA_SATISFACAO (CD_PESQUISA, DT_PESQUISA, NR_ESTRELA_INFRAESTRUTURA, NR_ESTRELA_PROF, NR_ESTRELA_AULA, DS_COMENTARIO, CD_USUARIO) VALUES (?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,?)");
		
		stmt.setInt(1, p.getCodigo());
		stmt.setString(2, p.getData());
		stmt.setInt(3, p.getInfraestrutura());
		stmt.setInt(4, p.getProfessor());
		stmt.setInt(5, p.getAula());
		stmt.setString(6, p.getComentario());
		stmt.setInt(7, p.getCodigoUsuario().getCodigo());
		
		stmt.executeUpdate();
		
		return "Cadastrado com Sucesso!";
		
		
	}

	/**
	 * Respons�vel por consultar uma linha na tabela T_SIC_PESQUISA_SATISFACAO
	 * @param numero Recebe um objeto do Tipo Integer.
	 * @return Uma ocorr�ncia na tabela T_SIC_PESQUISA_SATISFACAO.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */

	public PesquisaSatisfacao consultarPorNumero(int numero) throws Exception{
		stmt = con.prepareStatement
				("SELECT * FROM T_SIC_PESQUISA_SATISFACAO INNER JOIN T_SIC_USUARIO ON(T_SIC_PESQUISA_SATISFACAO.CD_USUARIO = T_SIC_USUARIO.CD_USUARIO) INNER JOIN T_SIC_ENDERECO ON (T_SIC_USUARIO.CD_ENDERECO = T_SIC_ENDERECO.CD_ENDERECO) WHERE CD_PESQUISA=?");
		
		stmt.setInt(1, numero);

		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new PesquisaSatisfacao
					(rs.getInt("CD_PESQUISA"),
				     rs.getString("DT_PESQUISA"),
					 rs.getInt("NR_ESTRELA_INFRAESTRUTURA"),
					 rs.getInt("NR_ESTRELA_PROF"),
					 rs.getInt("NR_ESTRELA_AULA"),
					 rs.getString("DS_COMENTARIO"),
					 new Usuario
						(rs.getInt("CD_USUARIO"),
					     rs.getString("NM_USUARIO"),
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
										)
							));
		}else {
			return new PesquisaSatisfacao();
		}
	}


	/**
	 * Respons�vel por apagar uma linha na tabela T_SIC_PESQUISA_SATISFACAO
	 * @param numero Recebe um objeto do Tipo Integer.
	 * @return O n�mero de linhas afetadas.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */

	public int apagar(int numero) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SIC_PESQUISA_SATISFACAO WHERE CD_PESQUISA=?");
		stmt.setInt(1, numero);
		return stmt.executeUpdate();
	}
	/**
	 * Respons�vel por alterar uma linha na tabela T_SIC_PESQUISA_SATISFACAO
	 * @param e Recebe um objeto do Tipo PesquisaSatisfacao Beans.
	 * @return O n�mero de linhas alteradas.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	public String atualizar(PesquisaSatisfacao p) throws Exception {
		stmt = con.prepareStatement("UPDATE T_SIC_PESQUISA_SATISFACAO SET DT_PESQUISA=?, NR_ESTRELA_INFRAESTRUTURA=?, NR_ESTRELA_PROF=?, NR_ESTRELA_AULA=?, DS_COMENTARIO=?, CD_USUARIO=? WHERE CD_PESQUISA=?");
		stmt.setInt(7, p.getCodigo());
		stmt.setString(1, p.getData());
		stmt.setInt(2, p.getInfraestrutura());
		stmt.setInt(3, p.getProfessor());
		stmt.setInt(4, p.getAula());
		stmt.setString(5, p.getComentario());
		stmt.setInt(6, p.getCodigoUsuario().getCodigo());
		
		return stmt.executeUpdate() + " linhas foram afetadas!";
	}
}
