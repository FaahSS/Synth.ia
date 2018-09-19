package bo;

import beans.PesquisaSatisfacao;

/**
 * Classe responsável por manipular as regras relacionadas a PesquisaSatisfacao
 * Regras de Negócio avaliadas:
 * @param p Recebe um objeto Usuario
 * @return retorna a mesma String que recebe do UsuarioDAO
 * @throws Exception excecao Checked
 * @author Fábio Salgarella
 * 
 */
public class PesquisaSatisfacaoBO {
	public static String novaPesquisa(PesquisaSatisfacao p) throws Exception{
		if(p.getInfraestrutura()<1 || p.getInfraestrutura()>5) {
			return "Quantidade de estrelas inválida";
		}
		if(p.getProfessor()<1 || p.getProfessor()>5) {
			return "Quantidade de estrelas inválida";
		}
		if(p.getAula()<1 || p.getAula()>5) {
			return "Quantidade de estrelas Inválida";
		}
		if(p.getComentario().length()>200) {
			return "Comentário muito grande!";
		}
		
		return "";
	}
	
}
