/*
CLASS: Primitive
AUTHOR: Marcel Ochsendorf
CREATION_DATE: 20.20.2017
GITHUB: https://github.com/RBEGamer/oop_praktikum_ws1718
DESC: Einfaces Rechteck extends Primitive
*/

public class Rechteck extends Primitive {

		Point size;

		Rechteck(){
				position = new Point(0,0);
				size = new Point(0,0);
		}
		Rechteck(int _x, int _y){
				position = new Point(_x,_y);
		}

		Rechteck(int _x, int _y, int _w, int _h){
				position = new Point(_x,_y);
				size = new Point(_w,_h);
		}
		Rechteck(Point _pos, Point _size){
				position = _pos;
				size = _size;
		}

		Rechteck(Rechteck _rect){
				position = _rect.position;
				size = _rect.size;
		}

		/** schaut ob zwei punkte gleich sind */
		/** @param _size neue position*/
		public void set_size(Point _size){
				size = _size;
		}

		/** return die recht size */
		/** @return ret obj size */
		public Point get_size(){
				return size;
		}

		/** berechnet flaecheninhalt des primitivs */
		/** @return float ret area */
		public float flaechen_inhalt(){
				return (float)(size.x*size.y);
		}

		/** schaut ob zwei punkte gleich sind */
		/** @param _obj punkt zum checken*/
		/** @return boolean if equal returns true */
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
				Rechteck _obj_cast = (Rechteck)_obj;
				//chekc field
				if(_obj_cast.position.equals(position) && ((Rechteck) _obj).size.equals(this.size)) {
						return true;
				}
				return false;
		}

		/** formatierter string der pos */
		/** @return String nice string */
		@Override
		public String toString(){
				return getClass().getName()  + " position="  + position.toString() + " size=" + size.toString();
		}

		/** clont objekt */
		/** @return Rechteck a clone */
		/** @see Rechteck */
		@Override
		protected Rechteck clone() throws CloneNotSupportedException {
				return (Rechteck) super.clone();
		}



}
