package beans;

public class Peso {
	private int codigo;
	private int gramatica;
	private int vocabulario;
	private int interpretacao;
	private int imersao;
	
	//GetAll
	public String getAll() {
		return "Código.......: "+codigo+"\n"+
			   "Gramática....: "+gramatica+"\n"+
			   "Vocabulário..: "+vocabulario+"\n"+
			   "Interpretação: "+interpretacao+"\n"+
			   "Imersão......: "+imersao;
	}
	
	//SetAll
	public void setAll(int codigo, int gramatica, int vocabulario, int interpretacao, int imersao) {
		setCodigo(codigo);
		setGramatica(gramatica);
		setVocabulario(vocabulario);
		setInterpretacao(interpretacao);
		setImersao(imersao);
	}
	
	//Construtores
	public Peso() {
		super();
	}
	public Peso(int codigo, int gramatica, int vocabulario, int interpretacao, int imersao) {
		super();
		setCodigo(codigo);
		setGramatica(gramatica);
		setVocabulario(vocabulario);
		setInterpretacao(interpretacao);
		setImersao(imersao);
	}
	//Getters & Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getGramatica() {
		return gramatica;
	}
	public void setGramatica(int gramatica) {
		this.gramatica = gramatica;
	}
	public int getVocabulario() {
		return vocabulario;
	}
	public void setVocabulario(int vocabulario) {
		this.vocabulario = vocabulario;
	}
	public int getInterpretacao() {
		return interpretacao;
	}
	public void setInterpretacao(int interpretacao) {
		this.interpretacao = interpretacao;
	}
	public int getImersao() {
		return imersao;
	}
	public void setImersao(int imersao) {
		this.imersao = imersao;
	}
	
	
}
