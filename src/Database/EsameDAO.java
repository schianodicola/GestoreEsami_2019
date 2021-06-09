package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Esame;
import Entity.Studente;
import Exception.MsgException;

public class EsameDAO {
	public static ArrayList<Esame> getEsami(int codiceVerbale)throws SQLException, MsgException{
		
		Connection conn=DBManager.getConnection();
		String query=("SELECT E.VOTO, E.ARGOMENTITRATTATI, E.STUDENTE, S.NOME, S.COGNOME  FROM (ESAMI E JOIN VERBALI V ON E.VERBALE=V.ID) JOIN STUDENTI S ON E.STUDENTE=S.MATRICOLA WHERE E.VERBALE=?;");
		ArrayList<Esame> ListaEsami= new ArrayList<Esame>();
		
		try(PreparedStatement stmt=conn.prepareStatement(query) ){
			stmt.setInt(1, codiceVerbale);				
			ResultSet rs=stmt.executeQuery();		//esegui la query
			
			while(rs.next()==true) {				
				int voto=rs.getInt("VOTO");
				String argomentiTrattati=rs.getString("ARGOMENTITRATTATI");	//nome colonna
				String nomestudente=rs.getString("NOME");
				String cognomestudente=rs.getString("COGNOME");
				String matricola=rs.getString("STUDENTE");
				
				
				Studente studente=new Studente(matricola,nomestudente,cognomestudente); //richiamo costruttori
				Esame es=new Esame(voto,argomentiTrattati,studente);
				ListaEsami.add(es);
			}
			
			if(ListaEsami.size()==0) {
				throw new MsgException("Lista esami Vuota. ");
			}
			
			rs.close();
			DBManager.closeConnection();
		}
		catch(SQLException e) {
			 throw new MsgException("Errore dentro EsameDAO: "+e.getMessage());
			 //errore nella sql
		 }
		
		
		return ListaEsami;
		}
}
