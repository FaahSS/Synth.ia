package bo;

import beans.Peso;

/**
 * Classe respons�vel por manipular as regras relacionadas a Peso
 * Regras de Neg�cio avaliadas:
 * @param p Recebe um objeto Usuario
 * @return retorna a mesma String que recebe do UsuarioDAO
 * @throws Exception excecao Checked
 * @author F�bio Salgarella
 * 
 */
public class PesoBO {
 public static String novoPeso(Peso p) throws Exception  {
	 if(p.getGramatica()<0 || p.getGramatica()>10) {
		 return "Peso inv�lido!";
	 }
	 if(p.getVocabulario()<0 || p.getVocabulario()>10) {
		 return "Peso inv�lido!";
	 }
	 if(p.getInterpretacao()<0 || p.getInterpretacao()>10) {
		 return "Peso inv�lido!";
	 }
	 if(p.getImersao()<0 || p.getImersao()>10) {
		 return "Peso inv�lido!";
	 }
	 
	 return "";
	 
 }
}
