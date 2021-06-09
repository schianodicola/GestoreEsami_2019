package Entity;

public class Esame {
	private int Voto;
	private String ArgomentiTrattati;
	private Studente Studente;
	
	public Esame(int voto, String argomentiTrattati, Studente studente) {
		super();
		Voto = voto;
		ArgomentiTrattati = argomentiTrattati;
		Studente = studente;
	}
	public int getVoto() {
		return Voto;
	}
	public void setVoto(int voto) {
		Voto = voto;
	}
	public String getArgomentiTrattati() {
		return ArgomentiTrattati;
	}
	public void setArgomentiTrattati(String argomentiTrattati) {
		ArgomentiTrattati = argomentiTrattati;
	}
	public Studente getStudente() {
		return Studente;
	}
	public void setStudente(Studente studente) {
		Studente = studente;
	} 
	
	
	
}
