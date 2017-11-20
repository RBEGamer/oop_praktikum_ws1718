package de.marcelochsendorf;



public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        test_BenutzerVerwaltung(args);

    }


     public static void test_BenutzerVerwaltung(String[] args) throws Exception {
        BenutzerVerwaltung vw = new BenutzerVerwaltungAdmin();

        //DOPPELTER BENUTZER NAME
        Benutzer tesuser = new Benutzer("user","password");
        vw.benutzereintragen(tesuser);
        tesuser = new Benutzer("user","123");
        vw.benutzereintragen(tesuser);

         //UNGÜLTIGES ZU KuRZES PASSWORT
         tesuser = new Benutzer("user1","passw");
         vw.benutzereintragen(tesuser);

         //UNGÜLTIGER BENUTZERNAME
         tesuser = new Benutzer("","passw");
         vw.benutzereintragen(tesuser);

         //BENUTZER EXISTIERT NICHT
         vw.benutzerOk(new Benutzer("123","456"));

         //BENUTZER EXISTIERT!
         vw.benutzerOk(new Benutzer("user","password"));




         vw.listBenutzer();
    }
}
