package bo;

import java.util.List;

import beans.Nivelamento;
import beans.Questao;
import dao.NivelamentoDAO;

public class NivelamentoBO {
	public static String novoNivelamento(Nivelamento n, Questao q) throws Exception{
		if(n.getCodigo()<1) {
			return "Código não existe";
		}
		if(n.getTipo().length()<5) {
			return "Tipo muito curto";
		}
		if(n.getTipo().length()>20) {
			return "Tipo muito extenso";
		}
		NivelamentoDAO dao = new NivelamentoDAO();
		Nivelamento result = dao.consultarPorNumero(n.getCodigo());
		if(result.getTipo()!=null) {
			dao.fechar();
			return "Nivelamento já cadastrado!";
		}	

		return "";
	}

}
