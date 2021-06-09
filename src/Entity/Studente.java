package Entity;

public class Studente {
	private String Matricola;
	private String Nome;
	private String Cognome;
	private String CF;
	public Studente(String matricola, String nome, String cognome, String cF) {
		super();
		Matricola = matricola;
		Nome = nome;
		Cognome = cognome;
		CF = cF;
	}
	public Studente(String matricola, String nome, String cognome) {
		super();
		Matricola = matricola;
		Nome = nome;
		Cognome = cognome;
		//CF = cF;
	}
	
	public String getMatricola() {
		return Matricola;
	}
	public void setMatricola(String matricola) {
		Matricola = matricola;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	
	
}
