package main;

import javax.swing.JOptionPane;

import dao.UsuarioDAO;
import exception.Excecao;

public class TesteApagarUsuario {
	public static void main(String[] args) {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do usuario a ser deletado"));
			
			dao.apagar(numero);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
