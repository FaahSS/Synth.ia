package main;

import javax.swing.JOptionPane;

import beans.Endereco;
import dao.EnderecoDAO;
import exception.Excecao;

public class TesteGravarEndereco {
public static void main(String[] args) {
	try {
		System.out.println(new EnderecoDAO().gravar
				(new Endereco (
						Integer.parseInt(JOptionPane.showInputDialog("Codigo endereco")),
						JOptionPane.showInputDialog("CEP"),
						JOptionPane.showInputDialog("UF"),
						JOptionPane.showInputDialog("Cidade"),
						JOptionPane.showInputDialog("Logradouro"),
						JOptionPane.showInputDialog("Numero da residencia")			
						) 
				
				
				));
		
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println(Excecao.tratarExcecao(e));
	}
}
}
