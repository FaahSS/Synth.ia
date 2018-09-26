package main;

import javax.swing.JOptionPane;

import beans.Endereco;
import beans.Usuario;
import dao.UsuarioDAO;
import exception.Excecao;

public class TesteAlterarUsuario {
	public static void main(String[] args) {
		try {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario usu = new Usuario();
			
			usu.setAll(Integer.parseInt(JOptionPane.showInputDialog("Digite o Codigo do aluno que deseja Alterar")),
					JOptionPane.showInputDialog("Novo Nome"), 
					JOptionPane.showInputDialog("Novo Email"), 
					JOptionPane.showInputDialog("Nova Senha"), 
					JOptionPane.showInputDialog("Sexo"), 
					JOptionPane.showInputDialog("Nova data de nascimento"), 
					JOptionPane.showInputDialog("Novo CPF"), 
					Integer.parseInt(JOptionPane.showInputDialog("Novo Tipo")), 
					new Endereco (Integer.parseInt(JOptionPane.showInputDialog("Novo codigo de endereço")))
					);
			System.out.println(dao.atualizar(usu));
		} catch (Exception e ) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
