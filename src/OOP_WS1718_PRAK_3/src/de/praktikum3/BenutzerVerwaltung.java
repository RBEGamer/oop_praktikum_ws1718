/**
 interface BenutzerVerwaltung
 @version 1.0
 Interface für die Benutzerverwaltung
 */
package de.praktikum3;
public interface BenutzerVerwaltung {
		/** trägt einen neuen benutzer ein */
		/** @param _benutzer punkt zum checken*/
		/** @return void */
		 void benutzereintragen(Benutzer _benutzer) throws Exception;
		/** schaut ob der benutzer valide ist */
		/** @param _benutzer benutzer zum checken*/
		/** @return boolean if valid the true */
		 boolean benutzerOk(Benutzer _benutzer) throws Exception;
		/** listet alle gespeicherten benutzer auf */
		/** @return void */
		void listBenutzer() throws Exception;

}
