SELECT s.matricola, s.cognome, s.nome, e.voto, L.lode 

FROM docenti join corsi join  appelli join verbali join esami e join studenti s join lodi L 

WHERE corsi.matricolaDocente='matricola' and corsi.annoaccademico='anno' and appelli.id=corsi.codicecorso 
	and verbali.appello=appelli.id and esami.verbale=verbali.id studenti.matricola=esami.studente 
	and Lodi.id=esame.id