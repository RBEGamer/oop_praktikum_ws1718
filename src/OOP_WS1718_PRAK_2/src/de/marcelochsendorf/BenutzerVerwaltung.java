/**
 interface BenutzerVerwaltung
 @version 1.0
 creation_date 20.11.2017
 source_url https://github.com/RBEGamer/oop_praktikum_ws1718
 desc Interface für die Benutzerverwaltung
 */
package de.marcelochsendorf;
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
