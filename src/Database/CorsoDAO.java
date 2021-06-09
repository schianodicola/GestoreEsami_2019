package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Corso;
import Exception.MsgException;

public class CorsoDAO {
	public static ArrayList<Corso> getCorsi(String matricoladocente, String annoaccademico)throws SQLException, MsgException{
		
		Connection conn=DBManager.getConnection();
		String query=("SELECT * FROM CORSI WHERE DOCENTE=? AND ANNOACCADEMICO=?;");
		ArrayList<Corso> ListaCorsi= new ArrayList<Corso>();
		
		
		try(PreparedStatement stmt=conn.prepareStatement(query) ){
			stmt.setString(1, matricoladocente); //sto mettendo  la matricola al posto dei punti interrogativi 
			stmt.setString(2, annoaccademico);
			ResultSet rs=stmt.executeQuery();	//esegui la query
			
			while(rs.next()==true) {//se la query mi ha generato almeno una tupla 
				String codice=rs.getString("CODICE");//gli sto passando il nome della colonna
				String denominazione=rs.getString("NOME");
				int CFU=rs.getInt("CFU");
				String annoAccademico=rs.getString("ANNOACCADEMICO");
			
				Corso corso=new Corso(codice,denominazione,CFU,annoAccademico);
				ListaCorsi.add(corso);
				
			}
			if(ListaCorsi.size()==0) {
				throw new MsgException("Nessun Corso Assegnato al docente \n");
			}
			
			rs.close();
			DBManager.closeConnection();
		}
		catch(SQLException e) {
			 throw new MsgException("Errore dentro CorsoDAO:  "+e.getMessage());
			 //errore nella sql
		 }
		
		
		return ListaCorsi;
		}
}
