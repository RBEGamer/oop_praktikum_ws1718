/**
 class Benutzer
 @version 1.0
 Klasse welche die Benutzerinformation beinhaltet
 */


package de.praktikum2;

public class Benutzer {


		String  userId;
		char[] passWort;



		public Benutzer(String _user_id, char[] _password){
				this.userId = _user_id;
				this.passWort = _password;
		}

		public Benutzer(String _user_id, String _password){
				this.userId = _user_id;
				this.passWort = new char[_password.length()];
				this.passWort = _password.toCharArray();
		}

		public Benutzer(){
				userId = "";
				passWort = new char[32];
		}


		/** schaut ob zwei benutzer gleich sind */
		/** @param _obj punkt zum checken*/
		/** @return boolean if equal the true */
		@Override
		public boolean equals(Object _obj) {
				//check same
				if (this == _obj) {
						return true;
				}
				// check null
				if (_obj == null) {
						return false;
				}
				//check type
				if (getClass() != _obj.getClass()){
						return false;
				}
				//cast to main type
				Benutzer _obj_cast = (Benutzer) _obj;
				//check field

				if(_obj_cast.userId == this.userId && String.copyValueOf(_obj_cast.passWort) == String.copyValueOf(this.passWort)) {
						return true;
				}
				return false;
		}


		/** formatierter string der daten */
		/** @return nice string */
		@Override
		public String toString() {
				return "["+getClass().getName()+"] username: " + userId + " password:" + String.copyValueOf(this.passWort).toString() + "";
		}
}
