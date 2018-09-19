package beans;


public class PesquisaSatisfacao {
	private int codigo;
	private String data;
	private int infraestrutura; //quantidade de estrelas
	private int professor; 
	private int aula;
	private String comentario;
	private Usuario codigoUsuario;
	
	//GetAll
	public String getAll() {
		return "Código.................:"+codigo+"\n"+
			   "Feedback Data..........:"+data+"\n"+
			   "Feedback Infraestrutura: "+infraestrutura+"\n"+
			   "Feedback Professor.....: "+professor+"\n"+
			   "Feedback Aula..........: "+aula+"\n"+
			   "Comentário.............: "+comentario+"\n"+
			   "Usuário................: "+codigoUsuario;
	}
	
	//SetAll
	public void setAll(int codigo, String data, int infraestrutura, int professor, int aula, String comentario,Usuario codigoUsuario) {
		setCodigo(codigo);
		setData(data);
		setInfraestrutura(infraestrutura);
		setProfessor(professor);
		setAula(aula);
		setComentario(comentario);
		setCodigoUsuario(codigoUsuario);
	}
	
	//Construtores
	public PesquisaSatisfacao() {
		super();
	}
	public PesquisaSatisfacao(int codigo, String data, int infraestrutura, int professor, int aula, String comentario, Usuario codigoUsuario) {
		super();
		setCodigo(codigo);
		setData(data);
		setInfraestrutura(infraestrutura);
		setProfessor(professor);
		setAula(aula);
		setComentario(comentario);
		setCodigoUsuario(codigoUsuario);
	}
	//Getters & Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Usuario getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(Usuario codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getInfraestrutura() {
		return infraestrutura;
	}
	public void setInfraestrutura(int infraestrutura) {
		this.infraestrutura = infraestrutura;
	}
	public int getProfessor() {
		return professor;
	}
	public void setProfessor(int professor) {
		this.professor = professor;
	}
	public int getAula() {
		return aula;
	}
	public void setAula(int aula) {
		this.aula = aula;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

}
