/**
 interface BenutzerVerwaltungAdmin
 interface BenutzerVerwaltung
 @version 1.0
 creation_date 20.11.2017
 source_url https://github.com/RBEGamer/oop_praktikum_ws1718
 desc klasse zum bearbeiten und speichern der benutzertablle
 */
package de.marcelochsendorf;
import java.util.*;
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {



		ArrayList<Benutzer> users;



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
						throw new ArrayStoreException("[" + this.getClass().toString() +"]" + " benutzereintragen got parameter with NULL");
				}
				//CHECK IF USERNAME VALID
				if(_benutzer.userId == "" || _benutzer.userId.length() < 3 ){
						throw new ArrayStoreException("[" + this.getClass().toString() +"]" + " benutzereintragen invalid or empty username username has to be 3 chars min");
				}
				//CEHCK IF USERNAME EXISTS 3 CHARS
				int ret= find_user_index_by_userid(_benutzer.userId);
				if(ret >= 0){
						throw new ArrayStoreException("[" + this.getClass().toString() +"]" + " username already exists");
				}
				//CHECK IF PASSWROD VALID 8 CHARS
				if(String.copyValueOf(_benutzer.passWort).toString() == "" || String.copyValueOf(_benutzer.passWort).length() < 8 ){
						throw new ArrayStoreException("[" + this.getClass().toString() +"]" + " benutzereintragen invalid or empty password username has to be 8 chars min");
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
						throw new ArrayStoreException("[" + this.getClass().toString() +"]" + " benutzerok got parameter with NULL");
				}
				//EXISTS USER IN LIST
				int ret= find_user_index_by_userid(_benutzer.userId);
				if(ret < 0){
						return false;
				}
				return users.get(ret).equals(_benutzer);
		}

/** schaut ob zwei benutzer gleich sind */
		/** @param _benutzer Benutzer  zum löschen */
		/** @return void */
		public void benutzerLöschen(Benutzer _benutzer) throws Exception{
				// check null
				if (_benutzer == null) {
						throw new ArrayStoreException("[" + this.getClass().toString() +"]" + " benutzbenutzerLöschenerok got parameter with NULL");
				}
				//EXISTS USER IN LIST
				int ret= find_user_index_by_userid(_benutzer.userId);
				if(ret < 0){
						throw new ArrayStoreException("[" + this.getClass().toString() +"]" + " benutzbenutzerLöschenerok user not registered for delete");
				}
				//CHECK EQUALS ObjeCT
				if(!users.get(ret).equals(_benutzer)){
						throw new ArrayStoreException("[" + this.getClass().toString() +"]" + " benutzbenutzerLöschenerok user not equals with the registere");
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
						throw new ArrayStoreException("[" + this.getClass().toString() +"]" + " name string empty");
				}

				for (int i = 0; i < users.size(); i++){
						if(users.get(i).userId == _userid){
								return i;
						}
				}
			return -1;
	}

}
