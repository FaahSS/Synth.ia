package beans;

import java.util.ArrayList;
import java.util.List;

public class Nivelamento {
	private int codigo;
	private int acerto;
	private String data;
	private String tipo; //dificuldade
	private Usuario codigoUsuario;
	private List<Questao> questao = new ArrayList<Questao>();
	
	//GetAll
	public String getAll() {
		return "Código.............: "+codigo+"\n"+
			   "Número de Acertos..: "+acerto+"\n"+
			   "Data do Nivelamento: "+data+"\n"+
			   "Tipo do Nivelamento: "+tipo+"\n"+
			   "Usuário............: "+codigoUsuario+"\n"+
			   "Questões...........: "+questao;
	}
	//SetAll
	public void setAll(int codigo, int acerto, String data, String tipo, Usuario codigoUsuario, List<Questao> questao) {
		setCodigo(codigo);
		setAcerto(acerto);
		setData(data);
		setTipo(tipo);
		setCodigoUsuario(codigoUsuario);
		setQuestao(questao);
	}
	
	//Construtores
	public Nivelamento() {
		super();
	}
	public Nivelamento(int codigo, int acerto, String data, String tipo,Usuario codigoUsuario) {
		super();
		setCodigo(codigo);
		setAcerto(acerto);
		setData(data);
		setTipo(tipo);
		setCodigoUsuario(codigoUsuario);
	}
	public Nivelamento(int codigo, int acerto, String data, String tipo,Usuario codigoUsuario, List<Questao> questao) {
		super();
		setCodigo(codigo);
		setAcerto(acerto);
		setData(data);
		setTipo(tipo);
		setCodigoUsuario(codigoUsuario);
		setQuestao(questao);
	}
	
	//Getters & Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getAcerto() {
		return acerto;
	}
	public void setAcerto(int acerto) {
		this.acerto = acerto;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo.toUpperCase();
	}
	public List<Questao> getQuestao() {
		return questao;
	}
	public void setQuestao(List<Questao> questao) {
		this.questao = questao;
	}
	
	
	
	
	
	
}
