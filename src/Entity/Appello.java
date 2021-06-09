package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Appello {
	private int id;
	private LocalDate DataAppello;
	private String Sede;
	private LocalDate DataScadenzaPrenotazione;
	private String Note;
	
	private ArrayList<Verbale> ListaVerbali= new ArrayList<Verbale>();

	public Appello(int ID, LocalDate dataAppello, String sede, LocalDate dataScadenzaPrenotazione, String note) {
		super();
		id= ID;
		DataAppello = dataAppello;
		Sede = sede;
		DataScadenzaPrenotazione = dataScadenzaPrenotazione;
		Note = note;
		//ListaVerbali = listaVerbali;
	}

	public LocalDate getDataAppello() {
		return DataAppello;
	}

	public void setDataAppello(LocalDate dataAppello) {
		DataAppello = dataAppello;
	}

	public String getSede() {
		return Sede;
	}

	public void setSede(String sede) {
		Sede = sede;
	}

	public LocalDate getDataScadenzaPrenotazione() {
		return DataScadenzaPrenotazione;
	}

	public void setDataScadenzapPrenotazione(LocalDate dataScadenzaPrenotazione) {
		DataScadenzaPrenotazione = dataScadenzaPrenotazione;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public ArrayList<Verbale> getListaVerbali() {
		return ListaVerbali;
	}

	public void setListaVerbali(ArrayList<Verbale> listaVerbali) {
		ListaVerbali = listaVerbali;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


}
