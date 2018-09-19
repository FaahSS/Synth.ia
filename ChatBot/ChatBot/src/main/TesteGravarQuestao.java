package main;

import javax.swing.JOptionPane;

import beans.Peso;
import beans.Questao;
import dao.QuestaoDAO;
import exception.Excecao;

public class TesteGravarQuestao {
	public static void main(String[] args) {
		try {
			System.out.println(new QuestaoDAO().gravar
					(new Questao(
						Integer.parseInt(JOptionPane.showInputDialog("Codigo")),
						Integer.parseInt(JOptionPane.showInputDialog("Tipo")),
						JOptionPane.showInputDialog("Enunciado"),
						JOptionPane.showInputDialog("Gabarito"),
						JOptionPane.showInputDialog("Alternativa"),
						new Peso(
								Integer.parseInt(JOptionPane.showInputDialog("Codigo Peso")),
								Integer.parseInt(JOptionPane.showInputDialog("Nivel Gramatica")),
								Integer.parseInt(JOptionPane.showInputDialog("Nivel Vocabulario")),
								Integer.parseInt(JOptionPane.showInputDialog("Nivel Interpretação")),
								Integer.parseInt(JOptionPane.showInputDialog("Nivel Imersão"))
								
								)
					)));
					
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
			
		}
		
	}
}
