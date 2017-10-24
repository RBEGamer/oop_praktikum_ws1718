/**
class Primitive
@author Marcel Ochsendorf
@version 1.0
creation_date 20.20.2017
source_url https://github.com/RBEGamer/oop_praktikum_ws1718
desc Base class für versch objekte Rechteck Kreis....
*/

public class Primitive {

		Point position;


		Primitive(){
				position = new Point(0,0);
		}

		Primitive(int _x, int _y){
				position = new Point(_x,_y);
		}

		Primitive(Primitive _prim){
				position = _prim.position;
		}

		/** schaut ob zwei punkte gleich sind */
		/** @param _pos neue position*/
		public void set_position(Point _pos){
				this.position = _pos;
		}

		/** return die pos */
		/** @return Point returns obj pos */
		/** @see Point */
		public Point get_position(){
				return position;
		}

		/** berechnet flaecheninhalt des primitivs */
		/** @return float returns obj area */
		public float flaechen_inhalt(){
				return 0.0f;
		}

		/** schaut ob zwei punkte gleich sind */
		/** @param _obj punkt zum checken*/
		/** @return boolean if equal = true */
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
		/** @return String returns nice string */
		@Override
		public String toString(){
				return getClass().getName()  + " position="  + this.position.toString();
		}

		/** clont objekt */
		/** @return Primitive retutns clone */
		/** @see Primitive */
		@Override
		protected Primitive clone() throws CloneNotSupportedException {
				return (Primitive) super.clone();
		}



}
