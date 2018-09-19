package bo;

import beans.Endereco;

/**
 * Classe responsável por manipular as regras relacionadas ao Endereco
 * Regras de Negócio avaliadas:
 * @param p Recebe um objeto Usuario
 * @return retorna a mesma String que recebe do UsuarioDAO
 * @throws Exception excecao Checked
 * @author Fábio Salgarella
 * 
 */
public class EnderecoBO {
	public static String novoEndereco(Endereco e) throws Exception {
	if(e.getCep().length()!=9) {
		return /*x= e.getCep().substring(7, e.getCep().length());
			      e.getCep().substring(7) = "-";	*/
				"CEP Inválido!";
	}
	if(e.getUf().length()!=2) {
		return "UF inválida";
	}
	if(e.getCidade().length()>30) {
		return "Cidade muito grande!";
	}
	if(e.getLogradouro().length()<5 || e.getLogradouro().length()>120) {
		return "Rua inválida";
	}
	if(e.getNumero().length()<1 || e.getNumero().length()>8) {
		return "Numero invalido!";
	}
		
		return"";
	}

}
