/**
class Point
@author Marcel Ochsendorf
@veriosn 1.0
creation_date 20.20.2017
source_url https://github.com/RBEGamer/oop_praktikum_ws1718
desc Einfache 2D Punkt (X, Y)
*/

public class Point {

		int x;
		int y;

		Point(){
		x= 0;
		y = 0;
		}

		Point(Point _p){
				x = _p.x;
				y = _p.x;
		}

		Point(int _x, int _y){
				x = _x;
				y = _y;
		}

		/** gibt den punkt zurück als location */
		/** @return location of obj */
		/** @see Point */
		public Point get_location(){
				return this;
		}

		/** Setzt die position des Punktes */
		/** @param _x x anteil des punktes */
		/** @param _y y anteil des punktes */
		public void set_location(int _x, int _y){
				x = _x;
				y = _y;
		}
		/** kopiert die location eines anderen punktes */
		/** @param _p	punkt von dem die locstion übernaommen werden soll*/
		 public void set_location(Point _p){
				x = _p.x;
				y = _p.y;
		}
			/** verschiebt den punkt um einen wert */
			/** @param _dx verschiebung x*/
			/** @param _dy verschiebung y */
		 public void move(int _dx, int _dy){
				x += _dx;
				y += _dy;
		}

		/** schaut ob zwei punkte gleich sind */
		/** @param _obj punkt zum checken*/
		/** @return boolean if equal the true */
		@Override
		 public boolean equals(Object _obj){
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
				 Point _obj_cast = (Point) _obj;
				 //chekc field
				 if(_obj_cast.x == this.x && _obj_cast.y == this.y) {
						 return true;
				 }
				return false;
		}

		/** formatierter string der pos */
		/** @return nice string */
		@Override
		 public String toString(){
			return getClass().getName()  + " {" + Integer.toString(x) + "|" + Integer.toString(y) + "}";
				}
}








