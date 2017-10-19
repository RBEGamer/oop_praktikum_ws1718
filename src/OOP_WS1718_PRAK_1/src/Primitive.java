/*
CLASS: Primitive
AUTHOR: Marcel Ochsendorf
CREATION_DATE: 20.20.2017
GITHUB: https://github.com/RBEGamer/oop_praktikum_ws1718
DESC: Base class für versch objekte Rechteck Kreis....
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
		public Point get_position(){
				return position;
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
