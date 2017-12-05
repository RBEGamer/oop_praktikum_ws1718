/**
 klasse BenutzerVerwaltungAdmin
 interface BenutzerVerwaltung
 @version 1.0
 desc klasse zum bearbeiten und speichern der benutzertablle
 */
package de.praktikum3;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {



		private ArrayList<Benutzer> users;

	public String getDB_PATH() {
		return DB_PATH;
	}

	final String DB_PATH = "./db.ser";


		public BenutzerVerwaltungAdmin(){

				users =new ArrayList<Benutzer>();
				users.clear();
		}

		/** trägt einen neuen benutzer ein */
		/** @param _benutzer punkt zum checken*/
		/** @return void */
		public void benutzereintragen(Benutzer _benutzer) throws Exception{
				readFile(DB_PATH);
				//CHECK NULL
				if (_benutzer == null) {
						throw new IllegalArgumentException("[" + this.getClass().toString() +"]" + " benutzereintragen got parameter with NULL");
				}
				//CHECK IF USERNAME VALID
				if(_benutzer.userId == "" || _benutzer.userId.length() < 3  || _benutzer.userId.contains(";") || _benutzer.userId.contains(System.getProperty("line.separator"))){
						throw new IllegalArgumentException("[" + this.getClass().toString() +"]" + " benutzereintragen invalid or empty username username has to be 3 chars min");
				}
				//CHECK IF USERNAME EXISTS 3 CHARS
				int ret= find_user_index_by_userid(_benutzer.userId);
				if(ret >= 0){
						throw new IllegalArgumentException("[" + this.getClass().toString() +"]" + " username already exists");
				}
				//CHECK IF PASSWROD VALID 8 CHARS or empty alternativ String.copyValueOf(_benutzer.passWort).toString() == ""
				if(String.copyValueOf(_benutzer.passWort).toString().isEmpty() || String.copyValueOf(_benutzer.passWort).length() < 8  || String.copyValueOf(_benutzer.passWort).toString().contains(";") || String.copyValueOf(_benutzer.passWort).toString().contains(System.getProperty("line.separator"))){
						throw new IllegalArgumentException("[" + this.getClass().toString() +"]" + " benutzereintragen invalid or empty password username has to be 8 chars min");
				}
				//USER EINTRAGEN
				users.add(_benutzer);
				//UPDATE DB
				check_db_changes();
		}
		/** schaut ob der benutzer valide ist */
		/** @param _benutzer benutzer zum checken*/
		/** @return boolean if valid the true */
		public boolean benutzerOk(Benutzer _benutzer) throws Exception{

			readFile(DB_PATH);
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
				//parse_csv_string_to_users_list(readFile(DB_PATH));
			readFile(DB_PATH);
				if (_benutzer == null) {
						throw new IllegalArgumentException("[" + this.getClass().toString() +"] " +getClass().getEnclosingMethod().getName() + " got parameter with NULL");
				}
				//EXISTS NO USER IN LIST
				int ret= users.indexOf(_benutzer);
				if(ret < 0){
						throw new Exception_Datenbankfehler("[" + this.getClass().toString() +"]" + " benutzbenutzerLöschenerok user not registered for delete");
				}
				//CHECK EQUALS ObjeCT
				//if(!users.get(ret).equals(_benutzer)){
				//		throw new Exception_Datenbankfehler("[" + this.getClass().toString() +"]" + " benutzbenutzerLöschenerok user not equals with the register");
				//}
				//REMOVE USER
				users.remove(ret);
				//UPDATE DB
				check_db_changes();
		}
		/** listet alle registrierten benutzer auf */
		public void listBenutzer() throws Exception{

			readFile(DB_PATH);
			//parse_csv_string_to_users_list(readFile(DB_PATH));

				for (int i = 0; i < users.size(); i++){
						System.out.println( users.get(i).toString());
				}
		}
		/** schaut ob zwei benutzerids gleich sind */
		/** @param _user  user zum checken*/
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
		/** schaut ob zwei benutzer gleich sind */
		/** @param _userid String der uiserid zum checken*/
		/** @return int returns index of the array with the user -1 means obj not in */
		private int find_user_index_by_user(Benutzer _user) throws Exception{
				if(_user == null){
						throw new IllegalArgumentException("[" + this.getClass().toString() +"]" + "  user is null");
				}

				for (int i = 0; i < users.size(); i++){
						if(users.get(i).equals(_user)){
								return i;
						}
				}
				return -1;
		}



		/** erstellt eine neue Datenbank datei welche aber leer ist */
		/** @return void */
		public void dbInitialisieren() throws Exception{

			users.clear();
			ser();

		/*	File f = new File(DB_PATH);
			//WENN DB EXISTSTIERT LESEN SONST NEUE SCHREIBEN
			//if(!f.exists() && !f.isDirectory()) {
					System.out.println("CREATE INITIAL DB FILE");
					write_file("",DB_PATH);
         */
			//}
	}

		/** schaut ob die Datenbank datei erneut geschrieben werden muss */
		/** @return void */
	private void check_db_changes() throws Exception{

		ser();

		//READ CHECK SAME ENTRIES Else WRITE NEW FILE
			//File f = new File(DB_PATH);
			//WENN DB DATEI NICHT EXISTIERT EINE NEUE ERSTELLEN
			/*if(f.exists() && !f.isDirectory()) {
					//SCHAUE OB ÄNDERUNGEN GESCHRIEBEN WERDEN MÜSSEN
					if(readFile(DB_PATH) != create_csv_string()){
							System.out.println("check_db write updated db");
							write_file(create_csv_string(),DB_PATH);
					}
			}else{
					dbInitialisieren();
			}
			*/

	}
		/** schreibt einen string als datei an den path */
		/** @param _content string als dateiinhalt */
		/** @param _path dateipfad + name */
		/** @return void */
	private void write_file(String _content, String _path) throws Exception {
			try {
					File statText = new File(_path);
					FileOutputStream is = new FileOutputStream(statText);
					OutputStreamWriter osw = new OutputStreamWriter(is);
					Writer w = new BufferedWriter(osw);
					w.write(_content);
					w.close();
			} catch (IOException e) {
				throw new Exception_Datenbankfehler("File output failed");
			}
	}
		/** erstell einen csv string aus der benutzerliste*/
		/** @return String csv string  */
	private String create_csv_string(){
			StringBuilder csv_string = new StringBuilder();
		for(int i = 0; i < users.size(); i++){
				csv_string.append(i);
				csv_string.append(";");
				csv_string.append(users.get(i).userId.toString());
				csv_string.append(";");
				csv_string.append(String.copyValueOf(users.get(i).passWort).toString());
				csv_string.append(";");
				csv_string.append((System.currentTimeMillis() / 1000));
				csv_string.append(";");
				csv_string.append(System.getProperty("line.separator"));
		}
		return csv_string.toString();
	}
		/** liesst den inhalt der datei */
		/** @param _filename dateipfad + name */
		/** @return String gesamter content der Datei als String */
	public String readFile(String _filename)throws Exception
		{


				String content = "";
            users.clear();
			FileInputStream fis = null;
			ObjectInputStream in = null;
			try {
				fis = new FileInputStream(DB_PATH);
				in = new ObjectInputStream(fis);
				users = (ArrayList<Benutzer>) in.readObject();
				in.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

				/*
				File file = new File(_filename);
				FileReader reader = null;
				try {
						reader = new FileReader(file);
						char[] chars = new char[(int) file.length()];
						reader.read(chars);
						content = new String(chars);
						reader.close();
				} catch (IOException e) {
						throw  new Exception_Datenbankfehler("cant read file");
				} finally {
						if(reader !=null){reader.close();}
				} */
				return content;

		}


		/** _liest einen csv string und erstellt eine Benutzer liste */
		/** @param _csv dateipfad + name */
		/** @return String gesamter content der Datei als String */
		private void parse_csv_string_to_users_list(String _csv) throws Exception{
				if(users == null){
						throw new Exception_Datenbankfehler("users list null please call constructor");
				}
				users.clear();
				//IF STRING EMPTY -> NO USERS TO ADD
				if(_csv.length() <= 0){
						return;
				}
				// CHECK FOR ; CSV SPERATORS
		if(!_csv.contains(";")){
			throw new Exception_Datenbankfehler("CSV String not compatible");
		}
				//SPLIT NEW LINE
				String lines[] = _csv.split(System.getProperty("line.separator"));

				for (int i = 0; i < lines.length; i++) {
						//CHECK IF LINE CONTAINS 3 ;
						if(count_chars_in_string(lines[i],';') != 4){
								throw new Exception_Datenbankfehler("Failed to parse csv string ; number doesnt matches");
						}
						//PARSE STRING
						String csv_without_new_line = lines[i].replace(System.getProperty("line.separator"), "");
						String line_data[] = csv_without_new_line.split(";");

						//CREATE NEW USER
						if(line_data[1] == "" || line_data[2] == ""){
								throw new Exception_Datenbankfehler("csv row not complete filled");
						}
						Benutzer tmp_user = new Benutzer(line_data[1],line_data[2]);
						//System.out.println("parse user : " + tmp_user.toString());
						//ADD USER TO COLLECTION
						users.add(tmp_user);
				}
		}



		private  int count_chars_in_string(String _haystack, char _needle)
		{
				int count = 0;
				for (int i=0; i < _haystack.length(); i++)
				{
						if (_haystack.charAt(i) == _needle)
						{
								count++;
						}
				}
				return count;
		}

		public void ser(  ) {
			try {
			FileOutputStream fileOut = new FileOutputStream(DB_PATH);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(users);
			out.close();
		} catch( IOException e){ }
		}
}
