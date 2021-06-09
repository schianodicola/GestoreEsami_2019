package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Verbale {
	private int id;
	private LocalDate DataApertura;
	private boolean Stato;
	
	private ArrayList<Esame> ListaEsami= new ArrayList<Esame>();

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Verbale(int ID, LocalDate dataApertura, boolean stato, ArrayList<Esame> listaEsami) {
		super();
		id=ID;
		DataApertura = dataApertura;
		Stato = stato;
		ListaEsami = listaEsami;
	}
	public Verbale(int ID, LocalDate dataApertura, boolean stato) {
		super();
		id=ID;
		DataApertura = dataApertura;
		Stato = stato;
		//ListaEsami = listaEsami;
	}

	public LocalDate getDataApertura() {
		return DataApertura;
	}

	public void setDataApertura(LocalDate dataApertura) {
		DataApertura = dataApertura;
	}

	public boolean isStato() {
		return Stato;
	}

	public void setStato(boolean stato) {
		Stato = stato;
	}

	public ArrayList<Esame> getListaEsami() {
		return ListaEsami;
	}

	public void setListaEsami(ArrayList<Esame> listaEsami) {
		ListaEsami = listaEsami;
	}
	
}
