/**
 klasse BenutzerVerwaltungAdmin
 interface BenutzerVerwaltung
 @version 1.0
 desc klasse zum bearbeiten und speichern der benutzertablle
 */
package de.praktikum2;
import java.util.*;
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {



		private ArrayList<Benutzer> users;


		/** DEFAULT KONST **/
		public BenutzerVerwaltungAdmin(){
				users =new ArrayList<Benutzer>();
				users.clear();
		}
		/** trägt einen neuen benutzer ein */
		/** @param _benutzer punkt zum checken*/
		/** @return void */
		public void benutzereintragen(Benutzer _benutzer) throws Exception{
				//CHECK NULL
				if (_benutzer == null) {
						throw new IllegalArgumentException("[" + this.getClass().toString() +"]" + " benutzereintragen got parameter with NULL");
				}
				//CHECK IF USERNAME VALID
				if(_benutzer.userId == "" || _benutzer.userId.length() < 3 ){
						throw new IllegalArgumentException("[" + this.getClass().toString() +"]" + " benutzereintragen invalid or empty username username has to be 3 chars min");
				}
				//CHECK IF USERNAME EXISTS 3 CHARS
				int ret= find_user_index_by_userid(_benutzer.userId);
				if(ret >= 0){
						throw new IllegalArgumentException("[" + this.getClass().toString() +"]" + " username already exists");
				}
				//CHECK IF PASSWROD VALID 8 CHARS or empty alternativ String.copyValueOf(_benutzer.passWort).toString() == ""
				if(String.copyValueOf(_benutzer.passWort).toString().isEmpty() || String.copyValueOf(_benutzer.passWort).length() < 8 ){
						throw new IllegalArgumentException("[" + this.getClass().toString() +"]" + " benutzereintragen invalid or empty password username has to be 8 chars min");
				}
				//USER EINTRAGEN
				users.add(_benutzer);
		}
		/** schaut ob der benutzer valide ist */
		/** @param _benutzer benutzer zum checken*/
		/** @return boolean if valid the true */
		public boolean benutzerOk(Benutzer _benutzer) throws Exception{
				// check null
				if (_benutzer == null) {
						throw new IllegalArgumentException("[" + this.getClass().toString() +"]" + " benutzerok got parameter with NULL");
				}
				//EXISTS USER IN LIST
				int ret= find_user_index_by_userid(_benutzer.userId);
				if(ret < 0){
						return false;
				}

			    if (!users.get(ret).equals(_benutzer)) {
				throw new Exception_Datenbankfehler	("[" + this.getClass().toString() +"]" + " user id exists, but with different data for user");
			    }
			    //return true when found
			    return true;
		}

		/** schaut ob zwei benutzer gleich sind */
		/** @param _benutzer Benutzer  zum löschen */
		/** @return void */
		public void benutzerLoeschen(Benutzer _benutzer) throws Exception{
				// check null alternativ Objects.nonNull(reference) liefert automatisch illegalargumentexception


				if (_benutzer == null) {
						throw new IllegalArgumentException("[" + this.getClass().toString() +"] " +getClass().getEnclosingMethod().getName() + " got parameter with NULL");
				}
				//EXISTS NO USER IN LIST
				int ret= find_user_index_by_userid(_benutzer.userId);
				if(ret < 0){
						throw new Exception_Datenbankfehler("[" + this.getClass().toString() +"]" + " benutzbenutzerLöschenerok user not registered for delete");
				}
				//CHECK EQUALS ObjeCT
				if(!users.get(ret).equals(_benutzer)){
						throw new Exception_Datenbankfehler("[" + this.getClass().toString() +"]" + " benutzbenutzerLöschenerok user not equals with the register");
				}
				//REMOVE USER
				users.remove(ret);
		}


		/** listet alle registrierten benutzer auf */
		public void listBenutzer(){
				for (int i = 0; i < users.size(); i++){
						System.out.println( users.get(i).toString());
				}
		}
		/** schaut ob zwei benutzer gleich sind */
		/** @param _userid String der uiserid zum checken*/
		/** @return int returns index of the array with the user -1 means obj not in */
	private int find_user_index_by_userid(String _userid) throws Exception{
				if(_userid == ""){
						throw new IllegalArgumentException("[" + this.getClass().toString() +"]" + " name string empty");
				}

				for (int i = 0; i < users.size(); i++){
						if(users.get(i).userId.equals(_userid)){
								return i;
						}
				}
			return -1;
	}
}
