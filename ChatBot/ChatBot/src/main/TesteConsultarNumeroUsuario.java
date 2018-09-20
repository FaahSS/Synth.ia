package main;

import javax.swing.JOptionPane;

import beans.Usuario;
import dao.UsuarioDAO;
import exception.Excecao;

public class TesteConsultarNumeroUsuario {
	public static void main(String[] args) {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario numero = new Usuario();

			numero= dao.consultarPorNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do aluno")));
			System.out.println(numero.getAll());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}
}
