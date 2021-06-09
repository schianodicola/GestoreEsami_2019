
CREATE TABLE DOCENTI(
    matricola varchar(8) primary key,
    cognome varchar(30),
    nome varchar(20),
    settoredisciplinare varchar(20)
	
);

CREATE TABLE CORSI(
    codice varchar(10) primary key,
    nome varchar(30),
    cfu integer,
    annoaccademico varchar(4),
    
	docente varchar(10),
	constraint docenti_fk foreign key (docente) references docenti(matricola)
);




CREATE TABLE APPELLI(
    id integer primary key,
	dataappello date,
    sede varchar(20),
    datascadenzaprenotazione date,
    note varchar(50),
    
    corso varchar(10),
	constraint corsi_fk foreign key (corso) references corsi(codice)

);

CREATE TABLE ESAMI(
	id integer primary key,
	voto integer,
	argomentitrattati varchar(50),
  
	studente varchar(10),
	verbale integer,
	constraint studenti_fk foreign key (studente) references studenti (matricola),
	constraint verbali_fk foreign key (verbale) references verbali (id)
	
);


CREATE TABLE VERBALI(
    id integer primary key ,
    datacreazione date,
    stato boolean,
	
    appello integer,
	constraint appelli_fk foreign key (appello) references appelli (id)

);


CREATE TABLE STUDENTI(
    matricola varchar(10) primary key,
    nome varchar(20),
    cognome varchar(30),
	cf varchar(16),
    residenza varchar(30)
    
);

CREATE TABLE LODE(
    id integer primary key,
    lode boolean,
    
    constraint esami_fk foreign key (id) references esami (id)
);


