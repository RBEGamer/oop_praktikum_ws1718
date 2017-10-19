public class Primitive {

		Point position;


		Primitive(){
				position = new Point();
		}





		/** berechnet flaecheninhalt des primitivs */
		public float flaechenInhalt(){
				return 0.0f;
		}

		/** schaut ob zwei punkte gleich sind */
		/** @param _obj punkt zum checken*/
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
				Primitive _obj_cast = (Primitive)_obj;
				//chekc field
				if(_obj_cast.position.equals(this.position)) {
						return true;
				}
				return false;
		}

		/** formatierter string der pos */
		@Override
		public String toString(){
				return getClass().getName()  + " position="  + this.position.toString();
		}

		/** clont objekt */
		@Override
		protected Primitive clone() throws CloneNotSupportedException {
				return (Primitive) super.clone();
		}



}
