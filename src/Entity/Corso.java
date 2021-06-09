package Entity;

import java.util.ArrayList;

public class Corso {
	private String Codice;
	private String Nome;
	private int CFU;
	private String AnnoAccademico;
	private ArrayList<Appello> ListaAppelli= new ArrayList<Appello>();
	
	public Corso(String codice, String nome, int cFU, String annoAccademico) {
		super();
		Codice = codice;
		Nome = nome;
		CFU = cFU;
		AnnoAccademico = annoAccademico;
		//ListaAppelli = listaAppelli;
	}

	public String getCodice() {
		return Codice;
	}

	public void setCodice(String codice) {
		Codice = codice;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getCFU() {
		return CFU;
	}

	public void setCFU(int cFU) {
		CFU = cFU;
	}

	
	public String getAnnoAccademico() {
		return AnnoAccademico;
	}

	public void setAnnoAccademico(String annoAccademico) {
		AnnoAccademico = annoAccademico;
	}

	public ArrayList<Appello> getListaAppelli() {
		return ListaAppelli;
	}

	public void setListaAppelli(ArrayList<Appello> listaAppelli) {
		ListaAppelli = listaAppelli;
	}
	
}
