package bo;

import beans.Questao;
import dao.QuestaoDAO;

/**
 * Classe responsável por manipular as regras relacionadas a Questao
 * Regras de Negócio avaliadas:
 * @param u Recebe um objeto Usuario
 * @return retorna a mesma String que recebe do UsuarioDAO
 * @throws Exception excecao Checked
 * @author Fábio Salgarella
 * 
 */
public class QuestaoBO {
 public static String novaQuestao(Questao q) throws Exception{
	 if (q.getTipo()<1 || q.getTipo()>2) {
		 return "Tipo inválido!";
	 }
	 if(q.getTipo()==2 && q.getAlternativa()==null) {
		 return "É necessário cadastrar a Alternativa!";
	 }
	 if(q.getEnunciado().length()>255) {
		 return "Enunciado muito extenso!";
	 }
	 if(q.getPeso().getCodigo()<1) {
		 return "Peso não existe!";
	 }
	 QuestaoDAO dao = new QuestaoDAO();
	 Questao quest = dao.consultarPorNumero(q.getCodigo());
	 String result = null;
	 
	 if(quest.getCodigo()==0) {
		 result = dao.gravar(q);
	 }
	 dao.fechar();
	 return result;
 }
}
