package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Entity.Verbale;
import Exception.MsgException;

public class VerbaleDAO {
	public static ArrayList<Verbale> getVerbali(int codiceAppello)throws MsgException, SQLException{
		
		Connection conn=DBManager.getConnection();
		String query=("SELECT V.ID, V.STATO, V.DATACREAZIONE FROM VERBALI V JOIN APPELLI A ON V.APPELLO=A.ID WHERE A.ID=?;");
		ArrayList<Verbale> ListaVerbali= new ArrayList<Verbale>();
		
		try(PreparedStatement stmt=conn.prepareStatement(query) ){
			stmt.setInt(1, codiceAppello);				
			ResultSet rs=stmt.executeQuery();		//esegui la query
			
			while(rs.next()==true) {				
				int id=rs.getInt("ID");	
				boolean stato=rs.getBoolean("STATO");
				LocalDate datacreazione=rs.getDate("DATACREAZIONE").toLocalDate();
			
				Verbale verbale=new Verbale(id,datacreazione,stato);
				ListaVerbali.add(verbale);
			}
			
			if(ListaVerbali.size()==0) {
				throw new MsgException("Nessun Verbale disponibile");
			}
			
			rs.close();
			DBManager.closeConnection();
		}
		catch(SQLException e) {
			 throw new MsgException("Errore dentro VerbaleDAO: "+e.getMessage());
			 //errore nella sql
		 }
		
		
		return ListaVerbali;
	}
	
}
