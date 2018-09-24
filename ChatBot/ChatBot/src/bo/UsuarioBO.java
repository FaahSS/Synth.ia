package bo;

import beans.Usuario;
import dao.UsuarioDAO;

/**
 * Classe respons�vel por manipular as regras relacionadas ao Usuario
 * Regras de Neg�cio avaliadas:
 * @param u Recebe um objeto Usuario
 * @return retorna a mesma String que recebe do UsuarioDAO
 * @throws Exception excecao Checked
 * @author F�bio Salgarella
 * 
 */
public class UsuarioBO {
	public static String novoUsuario(Usuario u) throws Exception{
		if(u.getNome().length()>60) {
			return "Nome muito longo";
		}
		if(u.getSexo().charAt(0)!='M' || u.getSexo().charAt(0)!='F') {
			return "OUTRO";
		}
		if(u.getSenha().length()<6 || u.getSenha().length()>40) {
			return "123456";
		}
		if(u.getCpf().length()!=11) {
			return "Cpf Inv�lido";
		}
		if(u.getTipo()<1 || u.getTipo()>3) {
			return "Tipo Inv�lido";
		}
		
		u.setNome(u.getNome().toUpperCase());
		UsuarioDAO dao = new UsuarioDAO();
		Usuario result = dao.consultarPorNumero(u.getCodigo());
		if(result.getEmail()!=null) {
			dao.fechar();
			return "Usu�rio j� cadastrado!";
		}
		
		String novoEnd = EnderecoBO.novoEndereco(u.getEndereco());
		String x = null;
		if(novoEnd.equals("Cadastrado com Sucesso!") || novoEnd.equals(null)) {
			x = dao.gravar(u);
		}
		dao.fechar();
		return x;
	}
	
	
	

}
