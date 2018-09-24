package bo;

import beans.Endereco;
import dao.EnderecoDAO;

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
		return "CEP Inválido! Verifique se inseriu '-' antes dos 3 números finais!";
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
		EnderecoDAO dao = new EnderecoDAO();
		Endereco ende = dao.consultarPorNumero(e.getCodigo());
		String result = null;
		
		if(ende.getCodigo()==0) {
			result = dao.gravar(e);
		}
		dao.fechar();
		return result;
		
	}

}
