/**
 klasse BenutzerVerwaltungAdmin
 interface BenutzerVerwaltung
 @version 1.0
 desc klasse zum bearbeiten und speichern der benutzertablle
 */
package de.praktikum3;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {



		private ArrayList<Benutzer> users;
		final String DB_PATH = "./db.ser";


		public BenutzerVerwaltungAdmin(){

				users =new ArrayList<Benutzer>();
				users.clear();
		}

		/** trägt einen neuen benutzer ein */
		/** @param _benutzer punkt zum checken*/
		/** @return void */
		public void benutzereintragen(Benutzer _benutzer) throws Exception{
				users = parse_csv_string(readFile(DB_PATH));
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
				users = parse_csv_string(readFile(DB_PATH));
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
				users = parse_csv_string(readFile(DB_PATH));

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
				//UPDATE DB
				check_db_changes();
		}


		/** listet alle registrierten benutzer auf */
		public void listBenutzer() throws Exception{
				users = parse_csv_string(readFile(DB_PATH));

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
						if(users.get(i).userId == _userid){
								return i;
						}
				}
			return -1;
	}


	public void dbInitialisieren() throws Exception{

//check file exists
			File f = new File(DB_PATH);
			//WENN DB EXISTSTIERT LESEN SONST NEUE SCHREIBEN
			if(f.exists() && !f.isDirectory()) {
					// read file
					System.out.println("db_init read existring db file");
					users = parse_csv_string(readFile(DB_PATH));
			}else{
					System.out.println("CREATE INITIAL DB FILE");
					write_file(create_csv_string(users),DB_PATH);
			}
	}

	private void check_db_changes() throws Exception{
			//READ CHECK SAME ENTRIES ESLE WRITE NEW FILE
			File f = new File(DB_PATH);
			//WENN DB DATEI NICHT EXISTIERT EINE NEUE ERSTELLEN
			if(f.exists() && !f.isDirectory()) {
					//SCHAUE OB ÄNDERUNGEN GESCHRIBEN WERDEN MÜSSEN
					if(readFile(DB_PATH) != create_csv_string(users)){
							System.out.println("check_db write updated db");
							write_file(create_csv_string(users),DB_PATH);
					}
			}else{
					dbInitialisieren();
			}

	}

	private void write_file(String _content, String _path) throws Exception{
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

	private String create_csv_string(ArrayList<Benutzer> _data){
			StringBuilder csv_string = new StringBuilder();
		for(int i = 0; i < users.size(); i++){
				csv_string.append(i);
				csv_string.append(";");
				csv_string.append(users.get(i).userId.toString());
				csv_string.append(";");
				csv_string.append(String.copyValueOf(users.get(i).passWort).toString());
				csv_string.append(";");
				csv_string.append(System.getProperty("line.separator"));
		}
		return csv_string.toString();
	}

	public String readFile(String filename)throws Exception
		{
				String content = null;
				File file = new File(filename); //for ex foo.txt
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
				}
				return content;
		}

		ArrayList<Benutzer> parse_csv_string(String _csv) throws Exception{
	// CHECK FOR ; CSV STUFF
		if(!_csv.contains(";")){
			throw new Exception_Datenbankfehler("CSV String not compatible");
		}

				ArrayList<Benutzer> tmp = new ArrayList<Benutzer>();
				//SPLIT NEW LINE
				String lines[] = _csv.split(System.getProperty("line.separator"));

				for (int i = 0; i < lines.length; i++) {
						//CHEKCK IF LINE CONTAINS 3 ;
						if(count_chars_in_string(lines[i],';') != 3){
								throw new Exception_Datenbankfehler("Failed to parse csv string ; number doesnt matches");
						}
						//PARSE STRING
						String line_data[] = _csv.split(";");
						//CREATE NEW USER
						Benutzer tmp_user = new Benutzer(line_data[1],line_data[2]);
						System.out.println("parse user : " + tmp_user.toString());
						//ADD USER TO COLLECTION
						tmp.add(tmp_user);
				}
				return  tmp;
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
}
