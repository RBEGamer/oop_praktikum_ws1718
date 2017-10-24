/**
class Kreis
@author Marcel Ochsendorf
@veriosn 1.0
creation_date 20.20.2017
source_url https://github.com/RBEGamer/oop_praktikum_ws1718
desc einerfacher Kreis
*/

public class KreisAgg extends Primitive {

		final float PI = (float)Math.PI;
		float radius;


		KreisAgg(){
				position = new Point(0,0);
				radius = 1.0f;
		}
		KreisAgg(float _r){
				radius = _r;
		}
		KreisAgg(int _x, int _y){
				position = new Point(_x,_y);
				radius = 1.0f;
		}
		KreisAgg(int _x, int _y, float _r){
				position = new Point(_x,_y);
				radius = _r;
		}
		KreisAgg(Point _pos, float _r){
				position = _pos;
				radius = _r;
		}

		KreisAgg(KreisAgg _cir){
				position = _cir.position;
				radius = _cir.radius;
		}

		/** schaut ob zwei punkte gleich sind */
		/** @param _r neue position*/
		public void set_radius(float _r){
				radius = _r;
		}

		/** return die recht size */
		/** @return float radius */
		public float get_radius(){
				return radius;
		}

		/** berechnet flaecheninhalt des primitivs */
		/** @return float area */
		public float flaechen_inhalt(){
				return (float)Math.pow(radius,2.0)*PI;
		}

		/** schaut ob zwei punkte gleich sind */
		/** @param _obj punkt zum checken */
		/** @return boolean if equal */
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
				KreisAgg _obj_cast = (KreisAgg)_obj;
				//chekc field
				if(_obj_cast.position.equals(position) && radius == ((KreisAgg)_obj).radius) {
						return true;
				}
				return false;
		}

		/** formatierter string der pos */
		/** @return nice string */
		@Override
		public String toString(){
				return getClass().getName()  + " position="  + position.toString() + " radius=" + radius;
		}

		/** clont objekt */
		/** @reutrn Kreis clone */
		/** @see KreisAgg */
		@Override
		protected KreisAgg clone() throws CloneNotSupportedException {
				return (KreisAgg) super.clone();
		}



}
