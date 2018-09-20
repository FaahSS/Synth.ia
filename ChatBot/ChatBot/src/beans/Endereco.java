package beans;

public class Endereco {
	private int codigo;
	private String cep;
	private String uf;
	private String cidade;
	private String logradouro;
	private String numero;
	
	
	//GetAll
	public String getAll() {
		return "Código....: "+codigo+"\n"+
			   "CEP.......: "+cep+"\n"+
			   "UF........: "+uf+"\n"+
			   "Cidade....: "+cidade+"\n"+
			   "Logradouro: "+logradouro+"\n"+
			   "Número....: "+numero;
	}
	
	//SetAll
	public void setAll(int codigo, String cep, String uf, String cidade, String logradouro, String numero) {
		setCodigo(codigo);
		setCep(cep);
		setUf(uf);
		setCidade(cidade);
		setLogradouro(logradouro);
		setNumero(numero);
	}
	
	//Construtores
	
	public Endereco() {
		super();
	}
	
	public Endereco(int codigo, String cep, String uf, String cidade, String logradouro, String numero) {
		super();
		setCodigo(codigo);
		setCep(cep);
		setUf(uf);
		setCidade(cidade);
		setLogradouro(logradouro);
		setNumero(numero);
	}
	public Endereco(int codigo) {
		super();
		setCodigo(codigo);
	}
	
	//Getters & Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf.toUpperCase();
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade.toUpperCase();
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro.toUpperCase();
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
