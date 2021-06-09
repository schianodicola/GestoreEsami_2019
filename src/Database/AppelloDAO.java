package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Entity.Appello;
import Exception.MsgException;

public class AppelloDAO {
	public static ArrayList<Appello> getAppelli(String codicecorso, String annoaaccademico)throws SQLException, MsgException{
		
		
		Connection conn=DBManager.getConnection();
		String query=("SELECT A.ID, A.DATAAPPELLO, A.SEDE, A.NOTE, A.DATASCADENZAPRENOTAZIONE FROM CORSI C JOIN APPELLI A ON C.CODICE=A.CORSO WHERE C.CODICE=? AND C.ANNOACCADEMICO=?;");
		ArrayList<Appello> ListaAppelli= new ArrayList<Appello>();
		
		try(PreparedStatement stmt=conn.prepareStatement(query) ){
			stmt.setString(1, codicecorso);				//sto mettendo  la matricola al posto dei punti interrogativi 
			stmt.setString(2, annoaaccademico);
			ResultSet rs=stmt.executeQuery();		//esegui la query
			
			while(rs.next()==true) {				//se la query mi ha generato almeno una tupla 
				int id=rs.getInt("ID");	//gli sto passando il nome della colonna
				//LocalDate o Date?
				LocalDate data=rs.getDate("DATAAPPELLO").toLocalDate();
				String sede=rs.getString("SEDE");
				String note=rs.getNString("NOTE");
				LocalDate datescadenzaprenotazioni=rs.getDate("DATASCADENZAPRENOTAZIONE").toLocalDate();
			
				Appello appello=new Appello(id,data,sede,datescadenzaprenotazioni,note);
				ListaAppelli.add(appello);
			}
			
			if(ListaAppelli.size()==0) {
				throw new MsgException("Nessun Appello disponibile per il corso "+codicecorso);
			}
			
			rs.close();
			DBManager.closeConnection();
		}
		catch(SQLException e) {
			 throw new MsgException("Errore dentro AppelloDAO: "+e.getMessage());
			 //errore nella sql
		 }
		
		
		return ListaAppelli;
		}
}
