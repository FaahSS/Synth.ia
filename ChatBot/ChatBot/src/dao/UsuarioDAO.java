package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Endereco;
import beans.Usuario;
import connection.Conexao;
/**
 * Esta classe manipula a tabela T_SIC_USUARIO
 * possui m�todos para: Cadastrar, consultar, alterar e excluir
 * @author F�bio Salgarella
 * @version 1.0
 * @since 1.0
 * @see UsuarioBO
 * @see UsuarioBeans
 */
public class UsuarioDAO {
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
	public UsuarioDAO() throws Exception {
		con = new Conexao().conectar();
	}
	
	/**
	 * Respons�vel por adicionar uma linha na tabela T_SIC_USUARIO
	 * @param u Recebe um objeto do Tipo Usuario Beans
	 * @return Uma string com a mensagem de confirma��o.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	
	public String gravar(Usuario u) throws Exception{
		PreparedStatement stmt = con.prepareStatement("INSERT INTO T_SIC_USUARIO (CD_CLIENTE, NM_CLIENTE, DS_EMAIL, DS_SENHA, DS_SEXO, DT_NASCIMENTO, NR_CPF, NR_TIPO , CD_ENDERECO   ) VALUES (?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?)");
		
		stmt.setInt(1, u.getCodigo());
		stmt.setString(2, u.getNome());
		stmt.setString(3, u.getEmail());
		stmt.setString(4, u.getSenha());
		stmt.setString(5, u.getSexo());
		stmt.setString(6, u.getNascimento());
		stmt.setString(7, u.getCpf());
		stmt.setInt(8, u.getTipo());
		stmt.setInt(9, u.getEndereco().getCodigo());
		

		
		stmt.executeUpdate();
		
		return "Cadastrado com Sucesso!";
		
		
	}
	
	/**
	 * Respons�vel por consultar uma linha na tabela T_SIC_USUARIO
	 * @param numero Recebe um objeto do Tipo Integer.
	 * @return Uma ocorr�ncia na tabela T_SIC_USUARIO.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	
	public Usuario consultarPorNumero(int numero) throws Exception{
		stmt = con.prepareStatement
				("SELECT* FROM T_SIC_USUARIO INNER JOIN T_SIC_ENDERECO ON (T_SIC_USUARIO.CD_ENDERECO = T_SIC_ENDERECO.CD_ENDERECO) WHERE CD_USUARIO=?");
		
		stmt.setInt(1, numero);
	
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Usuario
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
							);
		}else {
			return new Usuario();
		}
	}
	
	/**
	 * Respons�vel por consultar v�rias linha na tabela T_SIC_USUARIO
	 * @param nome Recebe um objeto do Tipo String.
	 * @return Uma lista na tabela T_SIC_USUARIO.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	public List<Usuario> consultarPorNome(String nome) throws Exception{
		List<Usuario> lista = new ArrayList<Usuario>();
		stmt = con.prepareStatement
				("SELECT * FROM T_SIC_USUARIO INNER JOIN T_SIC_ENDERECO ON (T_SIC_USUARIO.CD_ENDERECO = T_SIC_ENDERECO.CD_ENDERECO) WHERE NM_USUARIO LIKE ?");
		stmt.setString(1, "%" + nome + "%");
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Usuario
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
		}
			return lista;
		
	}
	/**
	 * Respons�vel por apagar uma linha na tabela T_SIC_USUARIO
	 * @param numero Recebe um objeto do Tipo Integer.
	 * @return O n�mero de linhas afetadas.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	
	public int apagar(int numero) throws Exception {
		stmt = con.prepareStatement("DELETE FROM T_SIC_USUARIO WHERE CD_USUARIO=?");
		stmt.setInt(1, numero);
		return stmt.executeUpdate();
	}
	/**
	 * Respons�vel por atualizar uma linha na tabela T_SIC_USUARIO
	 * @param u Recebe um objeto do Tipo Usuario Beans.
	 * @return O n�mero de linhas alteradas.
	 * @throws Exception Chamada da exce��o checked.
	 * @author F�bio Salgarella
	 */
	public String atualizar(Usuario u) throws Exception {
		stmt = con.prepareStatement("UPDATE T_SIC_USUARIO SET NM_USUARIO=?, DS_EMAIL=TO_DATE(?,'DD/MM/YYYY'), DS_SENHA=?, DS_SEXO=?, DT_NASCIMENTO=?, NR_CPF=?, NR_TIPO=?, CD_ENDERECO=? WHERE CD_USUARIO=?");
		stmt.setInt(9, u.getCodigo());
		stmt.setString(1, u.getNome());
		stmt.setString(2, u.getEmail());
		stmt.setString(3, u.getSenha());
		stmt.setString(4, u.getSexo());
		stmt.setString(5, u.getNascimento());
		stmt.setString(6, u.getCpf());
		stmt.setInt(7, u.getTipo());
		stmt.setInt(8, u.getEndereco().getCodigo());
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
