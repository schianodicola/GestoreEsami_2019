package Entity;

public class Docente {
	private String Matricola;
	private String Nome;
	private String Cognome;
	private String SettoreDisciplinare;
	
	
	public Docente(String matricola, String nome, String cognome, String settoreDisciplinare) {
		super();
		Matricola = matricola;
		Nome = nome;
		Cognome = cognome;
		SettoreDisciplinare = settoreDisciplinare;
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
	public String getSettoreDisciplinare() {
		return SettoreDisciplinare;
	}
	public void setSettoreDisciplinare(String settoreDisciplinare) {
		SettoreDisciplinare = settoreDisciplinare;
	}
	
	
}
