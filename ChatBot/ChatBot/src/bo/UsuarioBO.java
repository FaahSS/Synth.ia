package bo;

import beans.Usuario;

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
		//Regra de Neg�cio
		
		//Valida��o
		if(u.getNome().length()>60) {
			return "Nome muito longo";
		}
		if(u.getSexo().charAt(0)!='M' || u.getSexo().charAt(0)!='F') {
			return "OUTRO";
		}
		if(u.getSenha().length()<6 || u.getSenha().length()>40) {
			return "123";
		}
		if(u.getCpf().length()!=11) {
			return "Cpf Inv�lido";
		}
		return "";
	}

}
