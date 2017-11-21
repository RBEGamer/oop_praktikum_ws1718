package de.praktikum3;

import org.junit.Test;

import static org.junit.Assert.*;

public class BenutzerVerwaltungAdminTest {


    /** testet die methode des Eintragens eines neuen Benutzers durch den admin */
    /** @param */
    /** @return void */


    private  BenutzerVerwaltungAdmin testAdmin = new BenutzerVerwaltungAdmin();




    @Test(expected = IllegalArgumentException.class)
    public void benutzereingetragenNull () throws Exception {
        Benutzer testuserNull = new Benutzer(null, "123123131");
        testAdmin.benutzereintragen(testuserNull);
    }


    @Test(expected = IllegalArgumentException.class)
    public void benutzereingabeNameTooShort () throws Exception {
        Benutzer testuserNameTooShort = new Benutzer("alf", "1233122131");
        testAdmin.benutzereintragen(testuserNameTooShort);
    }


    @Test(expected = IllegalArgumentException.class)
    public void benutzereingabePasswordTooShort () throws Exception {
        Benutzer testuserPasswordTooShort = new Benutzer("alf", "12312312131");
        testAdmin.benutzereintragen(testuserPasswordTooShort);
    }


    @Test public void benutzereintragenOk () throws Exception {
        Benutzer testuserok = new Benutzer("alf", "12312312123");
        testAdmin.benutzereintragen(testuserok);
    }

    @Test public void benutzereintragenOk () throws Exception {
        Benutzer testuserok = new Benutzer("alf", "12312312123");
        testAdmin.benutzereintragen(testuserok);
    }

}
