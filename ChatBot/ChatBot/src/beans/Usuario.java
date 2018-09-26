package beans;

public class Usuario implements Comparable<Usuario>{
	private int codigo;
	private String nome;
	private String email;
	private String senha;
	private String sexo;
	private String nascimento;
	private String cpf;
	private int tipo;
	private Endereco endereco;
	
	//CompareTo
		public int compareTo(Usuario outroUsuario) {
			return this.nome.compareTo(outroUsuario.nome);
		}
	
	
	//GetAll
	public String getAll() {
		return "Código............: "+codigo+"\n"+
	           "Nome..............: "+nome+"\n"+
			   "Email.............: "+email+"\n"+
	           "Senha.............: "+senha+"\n"+
	           "Sexo..............: "+sexo+"\n"+
			   "Data de Nascimento: "+nascimento+"\n"+
	           "CPF...............: "+cpf+"\n"+
	           "Tipo..............: "+tipo+"\n"+
			   "Endereço..........: "+endereco;
	           
	}
	
	//SetAll
	public void setAll(int codigo, String nome, String email, String senha, String sexo, String nascimento, String cpf, int tipo,Endereco endereco) {
		setCodigo(codigo);
		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setSexo(sexo);
		setNascimento(nascimento);
		setCpf(cpf);
		setTipo(tipo);
		setEndereco(endereco);
	}
	//Construtores
	public Usuario() {
		super();
	}
	public Usuario(int codigo, String nome, String email, String senha, String sexo, String nascimento, String cpf, int tipo,Endereco endereco) {
		setCodigo(codigo);
		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setSexo(sexo);
		setNascimento(nascimento);
		setCpf(cpf);
		setTipo(tipo);
		setEndereco(endereco);
		
	}
	
	//Getters & Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo.toUpperCase();
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	
	

}
