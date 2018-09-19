package bo;

import beans.PesquisaSatisfacao;

/**
 * Classe respons�vel por manipular as regras relacionadas a PesquisaSatisfacao
 * Regras de Neg�cio avaliadas:
 * @param p Recebe um objeto Usuario
 * @return retorna a mesma String que recebe do UsuarioDAO
 * @throws Exception excecao Checked
 * @author F�bio Salgarella
 * 
 */
public class PesquisaSatisfacaoBO {
	public static String novaPesquisa(PesquisaSatisfacao p) throws Exception{
		if(p.getInfraestrutura()<1 || p.getInfraestrutura()>5) {
			return "Quantidade de estrelas inv�lida";
		}
		if(p.getProfessor()<1 || p.getProfessor()>5) {
			return "Quantidade de estrelas inv�lida";
		}
		if(p.getAula()<1 || p.getAula()>5) {
			return "Quantidade de estrelas Inv�lida";
		}
		if(p.getComentario().length()>200) {
			return "Coment�rio muito grande!";
		}
		
		return "";
	}
	
}
