package main;

import javax.swing.JOptionPane;

import beans.Endereco;
import beans.Usuario;
import dao.UsuarioDAO;
import exception.Excecao;

public class TesteGravarUsuario {

	public static void main(String[] args) {

		try {	
			System.out.println( new UsuarioDAO().gravar 
					( new Usuario (
							Integer.parseInt(JOptionPane.showInputDialog("Codigo")),
							JOptionPane.showInputDialog("Nome"),
							JOptionPane.showInputDialog("E-mail"),
							JOptionPane.showInputDialog("Senha"),
							JOptionPane.showInputDialog("Sexo"),
							JOptionPane.showInputDialog("Nascimento"),
							JOptionPane.showInputDialog("CPF"),
							Integer.parseInt(JOptionPane.showInputDialog("Tipo de Usuario")),
							new Endereco (
									Integer.parseInt(JOptionPane.showInputDialog("Codigo endereco")),
									JOptionPane.showInputDialog("CEP"),
									JOptionPane.showInputDialog("UF"),
									JOptionPane.showInputDialog("Cidade"),
									JOptionPane.showInputDialog("Logradouro"),
									JOptionPane.showInputDialog("Numero da residencia")
									))));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
