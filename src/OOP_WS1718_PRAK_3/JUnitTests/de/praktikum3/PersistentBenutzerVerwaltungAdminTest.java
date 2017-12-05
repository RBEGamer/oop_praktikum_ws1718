package de.praktikum3;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;



public class PersistentBenutzerVerwaltungAdminTest {


    /** testet die methode des Eintragens eines neuen Benutzers durch den admin */
    /** @param */
    /** @return void */


    private  BenutzerVerwaltungAdmin testAdmin = new BenutzerVerwaltungAdmin();

    @Test
    public void stage_1istVorhanden()throws Exception {
        File   testfile = new File(testAdmin.getDB_PATH());
        assertEquals(true,testfile.exists() && !testfile.isDirectory());
        }

    @Test(expected = NullPointerException.class)
    public void stage_2benutzereingetragenNull () throws Exception {
        Benutzer testuserNull = new Benutzer(null, "123123131");
        testAdmin.benutzereintragen(testuserNull);
    }


    @Test(expected = IllegalArgumentException.class)
    public void stage_3benutzereingabeNameTooShort () throws Exception {
        Benutzer testuserNameTooShort = new Benutzer("al", "frisstgernekatzen");
        testAdmin.benutzereintragen(testuserNameTooShort);
    }


    @Test(expected = IllegalArgumentException.class)
    public void stage_4benutzereingabePasswordTooShort () throws Exception {
        Benutzer testuserPasswordTooShort = new Benutzer("alf", "123");
        testAdmin.benutzereintragen(testuserPasswordTooShort);
    }


    @Test public void stage_5benutzereintragenOk () throws Exception {
        Benutzer testuserok = new Benutzer("albert", "magkatzensehrgerne");
        testAdmin.benutzereintragen(testuserok);
    }

    @Test public void stage_6benutzerfinden () throws Exception {
        Benutzer testuserok = new Benutzer("albert", "magkatzensehrgerne");
        testAdmin.benutzerOk(testuserok);
        testAdmin.listBenutzer();
    }


    @Test
    public void stage_7benutzerLoeschen() throws Exception {

        Benutzer testuserloeschen = new Benutzer("albert", "magkatzensehrgerne");
        testAdmin.benutzerLoeschen(testuserloeschen);
    }

    @Test(expected = Exception_Datenbankfehler.class)
    public void stage_8benutzerNichtMehrVohanden() throws Exception {

        Benutzer testuserloeschen = new Benutzer("albert", "magkatzensehrgerne");
        testAdmin.listBenutzer();
        testAdmin.benutzerLoeschen(testuserloeschen);
    }
}