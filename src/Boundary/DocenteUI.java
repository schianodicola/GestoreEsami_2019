package Boundary;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.GestoreEsami;
import Entity.Esame;


public class DocenteUI {

	public static void main(String[] args) {
		String matricola;
		String annoaccademico;
		Scanner buffer= new Scanner(System.in); 
		System.out.println("***************************************");
		System.out.println("***Benvenuto Nel Gestore Degli Esami***");
		System.out.println("***************************************");
		while(true){
			
			System.out.print("Vuoi Visualizzare il ReportVerbali? [Yes=1/No=2]: ");
			
			int scelta=buffer.nextInt();
			buffer.nextLine();
			GestoreEsami gestoreesami= GestoreEsami.getIstance();
			if (scelta==2) break;
			if(scelta==1) {
					//System.out.print("Stampa Report\n");
					System.out.println("Matricola Docente: ");
					matricola=buffer.nextLine();
					System.out.println("Anno Accademico: ");
					annoaccademico=buffer.nextLine();
					ArrayList<Esame> es= gestoreesami.StampaVerbale(matricola,annoaccademico);
					if(es != null) {

						System.out.println("");
						
						System.out.print("Matricola\tNome\tCognome\tVoto\n");
						for(Esame e: es) {
							System.out.print(e.getStudente().getMatricola());
							System.out.print("\t");
							System.out.print(e.getStudente().getNome());
							System.out.print("\t");
							System.out.print(e.getStudente().getCognome());
							System.out.print("\t");
							System.out.print(e.getVoto());
							
						}
						System.out.println("");
						System.out.println("");
					
					}
					else {
						System.out.println("Non ci sono Report per quel docente in quell'anno.");
					}
					break;
					
			}
			else {
				System.out.println("Inserisci 1=continua o 2=stop");
			}
		}	
		System.out.println("Sto Terminando... ");

	}
}
