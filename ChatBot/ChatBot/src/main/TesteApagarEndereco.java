package main;

import javax.swing.JOptionPane;

import dao.EnderecoDAO;
import exception.Excecao;

public class TesteApagarEndereco {
	public static void main(String[] args) {
		try {
			EnderecoDAO dao = new EnderecoDAO();
			int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do endereço a ser deletado"));

			dao.apagar(numero);

		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}
}
