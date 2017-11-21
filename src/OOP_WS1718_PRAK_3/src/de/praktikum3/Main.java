package de.praktikum3;



public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        BenutzerVerwaltungAdmin wv = new BenutzerVerwaltungAdmin();

       // wv.benutzereintragen(new Benutzer("useqwer1", "password3"));
       // wv.benutzereintragen(new Benutzer("useewqr2", "password2"));
       // wv.benutzereintragen(new Benutzer("useqwer3", "password1"));
        wv.dbInitialisieren();
        System.out.println("------------------------------");
        wv.benutzereintragen(new Benutzer("user5", "p44assword3"));
        wv.benutzereintragen(new Benutzer("user5", "p44assword3"));


    }



}
