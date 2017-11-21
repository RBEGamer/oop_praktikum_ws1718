package de.praktikum3;



public class Main {

    public static void main(String[] args) throws Exception {


        BenutzerVerwaltungAdmin wv = new BenutzerVerwaltungAdmin();
        wv.dbInitialisieren();
        wv.benutzereintragen(new Benutzer("user5", "p4ssw0rd"));
        wv.listBenutzer();
    }



}
