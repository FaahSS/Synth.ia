package main;

import javax.swing.JOptionPane;

import dao.QuestaoDAO;
import exception.Excecao;

public class TesteApagarQuestao {
	public static void main(String[] args) {
		try {
			QuestaoDAO dao = new QuestaoDAO();
			int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da questão a ser deletada"));
			
			dao.apagar(numero);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}
}
