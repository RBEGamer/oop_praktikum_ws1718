package de.praktikum3;



public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        test_BenutzerVerwaltung(args);

    }


     public static void test_BenutzerVerwaltung(String[] args) throws Exception {
        BenutzerVerwaltungAdmin vw = new BenutzerVerwaltungAdmin();

        Benutzer testuser = new Benutzer("user","password");
         vw.benutzereintragen(testuser);
         vw.benutzereintragen(new Benutzer("user1","password"));


        //DOPPELTER BENUTZER NAME
        // vw.benutzereintragen(testuser);


         //INVALID USERNAME
         //vw.benutzereintragen(new Benutzer("","password"));

         //INVALID PASSWORD
         //vw.benutzereintragen(new Benutzer("123321","123"));

         //BENUTZER FINDEN OK
         if(vw.benutzerOk(testuser)) {
             System.out.println("User gefunden");
         }

         //BENUTZER FINDEN ERROR
         if(vw.benutzerOk(new Benutzer("user2","password"))) {
             System.out.println("User gefunden");
         }else{
             System.out.println("USER NICHT GEFUNDEN");
         }

         vw.listBenutzer();
         System.out.println("-----------------------");
         //LÖSCHEN OK
         vw.benutzerLoeschen(testuser);
         vw.listBenutzer();


         //LÖSCHEN DOPPELT INVAQLID
         //vw.benutzerLoeschen(testuser);

         //LÖSCHEN UNBEKANNTER BENUTZER
         //vw.benutzerLoeschen(new Benutzer("user2","password"));





    }
}
