package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Docente;
import Exception.MsgException;

public class DocenteDAO {
	
	public static Docente getDocente(String matricola) throws SQLException, MsgException {
		Connection conn=DBManager.getConnection();
		String query="SELECT * FROM DOCENTI WHERE MATRICOLA=?;";
		
		Docente docente=null; 
		
		try(PreparedStatement stmt=conn.prepareStatement(query) ){
			stmt.setString(1, matricola);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()==true) { 
				String matr=rs.getString("MATRICOLA");
				String nome=rs.getString("COGNOME");
				String cognome=rs.getNString("NOME");
				String settoredisciplinare=rs.getNString("SETTOREDISCIPLINARE");
				
				docente=new Docente(matr,nome,cognome,settoredisciplinare);
			}
			
			else {
				throw new MsgException("Matricola non trovata\n");
			}
			//chiusura connessione
			rs.close();
			DBManager.closeConnection();
		}
		catch(SQLException e) {
			//errore nella sql
			System.out.println("ERRORE nella query docenteDAO"+e.getMessage());
		}
		
		return docente;
	}
}
