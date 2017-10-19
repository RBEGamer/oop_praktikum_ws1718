/*
CLASS: Point
AUTHOR: Marcel Ochsendorf
CREATION_DATE: 20.20.2017
GITHUB: https://github.com/RBEGamer/oop_praktikum_ws1718
DESC: Einfache 2D Punkt (X, Y)
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
		/** @param _p punkt zum checken*/
		 public boolean equals(Point _p){
				if(x == _p.x && y == _p.y) {
						return true;
				}
				return false;
		}

		/** formatierter string der pos */
		@Override
		 public String toString(){
			return getClass().getName()  + " { " + Integer.toString(x) + " | " + Integer.toString(y) + " }";
				}
}








