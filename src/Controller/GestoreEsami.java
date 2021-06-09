package Controller;

import java.util.ArrayList;

import Database.AppelloDAO;
import Database.CorsoDAO;
import Database.DocenteDAO;
import Database.EsameDAO;
import Database.VerbaleDAO;
import Entity.Appello;
import Entity.Corso;
import Entity.Docente;
import Entity.Esame;
import Entity.Verbale;
import Exception.MsgException;

public class GestoreEsami {
	public static GestoreEsami gestore=null;

	protected GestoreEsami() {
		
	}

	public static GestoreEsami getIstance() {
		if(gestore==null)
			gestore=new GestoreEsami();
		return gestore;
	}

	public ArrayList<Esame> StampaVerbale(String matricola, String annoaccademico){

		ArrayList<Esame> ReportVerbali = new ArrayList<Esame>();
		try{
			//per ogni docente di un corso in quell'anno
			//per ogni appello di quel corso
			//per ogni verbale di quell'appello
			//per ogni esame di quel verbale
			Docente docente = DocenteDAO.getDocente(matricola);
			ArrayList<Corso> ListaCorsi = CorsoDAO.getCorsi(docente.getMatricola(), annoaccademico);
			for(Corso corso: ListaCorsi) {
				ArrayList<Appello> ListaAppelli = AppelloDAO.getAppelli(corso.getCodice(),corso.getAnnoAccademico());
				for(Appello appello: ListaAppelli) {
					ArrayList<Verbale> listaVerbali = VerbaleDAO.getVerbali(appello.getId());
					for(Verbale verbale: listaVerbali) {
						ArrayList<Esame> esami = EsameDAO.getEsami(verbale.getId());
						ReportVerbali.addAll(esami); //aggiungo ogni esame alla lista Report verbali (di tipo esame)

					}
				}
			}
		}	
		catch(MsgException e ) {
			System.out.print("Errore:  ");
			System.out.println(e.getMessage());
		}
		catch(Exception e) {

			System.out.println("Report Verbale: Non ci sono Esami - ");
			System.out.println(e.getMessage());
		}
		return ReportVerbali;
	}
}
