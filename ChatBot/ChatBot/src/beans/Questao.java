package beans;

public class Questao implements Comparable<Questao>{
	private int codigo;
	private int tipo;
	private String enunciado;
	private String gabarito;
	private String alternativa;
	private Peso peso;
	
	//CompareTo
		public int compareTo(Questao outraQuest) {
			return this.enunciado.compareTo(outraQuest.enunciado);
		}
		
	//getAll
	public String getAll() {
		return "Código......: "+codigo+"\n"+
				"Tipo.......: "+tipo+"\n"+
				"Enunciado..: "+enunciado+"\n"+
				"Gabarito...: "+gabarito+"\n"+
				"Alternativa: "+alternativa+"\n"+
				"Peso.......: "+peso.getAll();
	}
	
	//SetAll
	public void setAll(int codigo, int tipo, String enunciado, String gabarito, String alternativa, Peso peso) {
		setCodigo(codigo);
		setTipo(tipo);
		setEnunciado(enunciado);
		setGabarito(gabarito);
		setAlternativa(alternativa);
		setPeso(peso);
	}
	//Construtores
	public Questao() {
		super();
	}
	public Questao(int codigo, int tipo, String enunciado, String gabarito, String alternativa,Peso peso) {
		super();
		setCodigo(codigo);
		setTipo(tipo);
		setEnunciado(enunciado);
		setGabarito(gabarito);
		setAlternativa(alternativa);
		setPeso(peso);
	}
	//Getters & Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Peso getPeso() {
		return peso;
	}
	public void setPeso(Peso peso) {
		this.peso = peso;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public String getGabarito() {
		return gabarito;
	}
	public void setGabarito(String gabarito) {
		this.gabarito = gabarito;
	}
	public String getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}
	
	
	

}
