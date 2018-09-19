package main;

import javax.swing.JOptionPane;

import beans.Peso;
import beans.Questao;
import dao.QuestaoDAO;
import exception.Excecao;

public class TesteAlterarQuestao {
public static void main(String[] args) {
	try {
		QuestaoDAO dao = new QuestaoDAO();
		Questao obj = new Questao();
		
		obj.setAll(Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo da Questao que deseja Alterar")),
				Integer.parseInt(JOptionPane.showInputDialog("Novo Tipo")),
				JOptionPane.showInputDialog("Novo Enunciado"),
				JOptionPane.showInputDialog("Novo Gabarito"),
				JOptionPane.showInputDialog("Nova Alternativa"),
				new Peso(Integer.parseInt(JOptionPane.showInputDialog("Novo Peso")))
				);
		System.out.println(dao.atualizar(obj));
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println(Excecao.tratarExcecao(e));
	}
}
}