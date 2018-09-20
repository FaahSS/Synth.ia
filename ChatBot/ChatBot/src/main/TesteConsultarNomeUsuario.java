package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import beans.Usuario;
import dao.UsuarioDAO;
import exception.Excecao;

public class TesteConsultarNomeUsuario {
	public static void main(String[] args) {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			List<Usuario> usuarios = new ArrayList<Usuario>();

			do {

				usuarios=dao.consultarPorNome(JOptionPane.showInputDialog("Digite o Nome").toUpperCase());
				for (Usuario usu : usuarios) {
					System.out.println(usu.getAll());
				}
			}while (JOptionPane.showConfirmDialog(null, "Continuar?","Pergunta",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}
}