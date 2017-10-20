/**
class KreisVererb
@author Marcel Ochsendorf
creation_date 20.20.2017
@version 1.0
source_url https://github.com/RBEGamer/oop_praktikum_ws1718
desc Einfacher Kreis, extends Point mit zusätzlichen radius
*/

public class KreisVererb extends Point{

		float radius;

		KreisVererb(){
				radius = 1.0f;
		}

		KreisVererb(KreisVererb _kv){
				this.radius = _kv.radius;
				this.x = _kv.x;
				this.y = _kv.y;
		}

		KreisVererb(Point _p, float _r){
				this.set_location(_p);
				radius = _r;
		}

		KreisVererb(int _x, int _y, float _r){
				this.x = _x;
				this.y = _y;
				radius = _r;
		}

		/**  returnt radius*/
		/** @return radius */
		float get_radius(){
				return radius;
		}

		/** setzt radius*/
		/** @param _r radius halt*/
		void set_radius(float _r){
				radius = _r;
		}

		/** schaut ob die objs gleich sind*/
		/** @param _obj zu checkender kreis halt*/
		/** @return boolean true if equal */
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
				KreisVererb _obj_cast = (KreisVererb) _obj;
				if(x == _obj_cast.x && y == _obj_cast.y && radius == _obj_cast.radius){
						return true;
				}
				return false;
		}

		/** obj als string*/
		/** @retrun String nice string */
		@Override
		public String toString() {
				return getClass().getName()  + " {" + Integer.toString(x) + "|" + Integer.toString(y) + "} r=" + Float.toString(radius)+ "f";
		}

}
