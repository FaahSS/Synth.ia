package main;

import javax.swing.JOptionPane;

import beans.Endereco;
import dao.EnderecoDAO;
import exception.Excecao;

public class TesteConsultarNumeroEndereco {
	public static void main(String[] args) {
		try {
			EnderecoDAO dao = new EnderecoDAO();
			Endereco endereco = new Endereco();

			endereco= dao.consultarPorNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do endereco")));
			System.out.println(endereco.getAll());
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}
}
