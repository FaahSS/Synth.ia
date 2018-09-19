package exception;

public class Excecao {
	public static String tratarExcecao(Exception e) {
		if(e.getClass().getName().equals("java.sql.SQLException")) {
			return "Ocorreu um erro ao conectar no banco!";
		} else if(e.getClass().getName().equals("java.lang.NumberFormatException")) {
			return "Número inválido!";
		} else {
			return "Não sei do que se trata!";
		}
	}
}
