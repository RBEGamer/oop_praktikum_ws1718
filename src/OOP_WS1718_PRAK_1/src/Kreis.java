/*
CLASS: Kreis
AUTHOR: Marcel Ochsendorf
CREATION_DATE: 20.20.2017
GITHUB: https://github.com/RBEGamer/oop_praktikum_ws1718
DESC: einerfacher Kreis
*/

public class Kreis extends Primitive {

		final float PI = (float)Math.PI;
		float radius;


		Kreis(){
				position = new Point(0,0);
				radius = 1.0f;
		}
		Kreis(float _r){
				radius = _r;
		}
		Kreis(int _x, int _y){
				position = new Point(_x,_y);
				radius = 1.0f;
		}
		Kreis(int _x, int _y, float _r){
				position = new Point(_x,_y);
				radius = _r;
		}
		Kreis(Point _pos, float _r){
				position = _pos;
				radius = _r;
		}

		Kreis(Kreis _cir){
				position = _cir.position;
				radius = _cir.radius;
		}

		/** schaut ob zwei punkte gleich sind */
		/** @param _r neue position*/
		public void set_radius(float _r){
				radius = _r;
		}

		/** return die recht size */
		public float get_radius(){
				return radius;
		}

		/** berechnet flaecheninhalt des primitivs */
		public float flaechenInhalt(){
				return (float)Math.pow(radius,2.0)*PI;
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
				Kreis _obj_cast = (Kreis)_obj;
				//chekc field
				if(_obj_cast.position.equals(position) && radius == ((Kreis)_obj).radius) {
						return true;
				}
				return false;
		}

		/** formatierter string der pos */
		@Override
		public String toString(){
				return getClass().getName()  + " position="  + position.toString() + " radius=" + radius;
		}

		/** clont objekt */
		@Override
		protected Kreis clone() throws CloneNotSupportedException {
				return (Kreis) super.clone();
		}



}
