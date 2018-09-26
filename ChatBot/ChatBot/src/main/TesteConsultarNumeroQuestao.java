package main;

import javax.swing.JOptionPane;

import beans.Questao;
import dao.QuestaoDAO;
import exception.Excecao;

public class TesteConsultarNumeroQuestao {
	public static void main(String[] args) {
		try {
			QuestaoDAO dao = new QuestaoDAO();
			Questao numero = new Questao();
			
			numero = dao.consultarPorNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o número da questão")));
			System.out.println(numero.getAll());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
