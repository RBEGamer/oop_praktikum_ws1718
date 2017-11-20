import sun.jvm.hotspot.types.PointerType;

public class Main {

    public static void main(String[] args) {
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
        System.out.println("OOS PRAK 1 TASK 1");
        oosPrak1Aufg1(args);
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("OOS PRAK 1 TASK 2");
        oosPrak1Aufg2(args);
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("OOS PRAK 1 TASK 3");
				oosPrak1Aufg3(args);
    }

    public static void oosPrak1Aufg1(String[] _args){
        final int PASCAL_DEPTH = 10;
        //DAS DREIECK muss mind 2 hoch sein
				if(PASCAL_DEPTH < 2){
						System.out.println("THE PASCAL_DEPTH < 2");
						return;
				}
				//ARRAY FÜR DAS DREIECK
				int[][] pascal = new int[PASCAL_DEPTH][];

				//anlegen der unter arrays
				for (int i = 0; i < PASCAL_DEPTH; i++) {
						//neues array an die neue pos des ersten und um 1 element grösser
						pascal[i] = new int[i + 1];
						//SETZTE DIE äussersten zellen auf 1
						pascal[i][0] = 1;
						pascal[i][i] = 1;
						//INNERE WERTE BERECHNEN dies geht nur wenn es etwas zu addieren gibt man also in der 2. zeile ist
						if (i >= 2) {
								//CALC NETX ROW mit der formel
								for (int j = 1; j < i; j++) {
										pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
								}
						}
				}
				//AUSGABE
				String tmp = "";
				for (int i = 0; i < PASCAL_DEPTH; i++) {
						tmp = "";
						for (int j = 0; j < i + 1; j++) {
								tmp += Integer.toString(pascal[i][j]) + " ";
						}
						System.out.println(tmp);
				}
    }

    public static void oosPrak1Aufg2(String[] _args){
			Point test_p = new Point(2,3);
			System.out.println(test_p.toString());
			test_p.move(-1,-2);
			test_p = new KreisVererb(4,1,5.6f);

			System.out.println(test_p.toString());
			System.out.println("Equal test 1 (should be true):" + test_p.equals(new KreisVererb(4,1,5.6f)));
			System.out.println("Equal test 2 (should be false):" + test_p.equals(new KreisVererb(4,1,5.4f)));

			((KreisVererb)test_p).setRadius(-1.0f);
			System.out.println("Equal test 3  radius test(should be false):" + test_p.isValid());

		}

		public static void oosPrak1Aufg3(String[] _args){
				Primitive[] primitives = new Primitive[5];
				//Create some instances with random values
				primitives[0] = new Primitive(10,12);
				primitives[1] = new Rechteck(1,2,3,4);
				primitives[2] = new Rechteck(4,5,2,1); //see 0
				primitives[3] = new KreisAgg(4,5,2.3f);
				primitives[4] = new KreisAgg(1.0f);
				//PRINT STUFF
				float ges = 0.0f;
				for(int i = 0; i < primitives.length; i++){
						ges += primitives[i].flaechenInhalt();
						System.out.println( primitives[i].toString() + " Flaecheninhalt=" + primitives[i].flaechenInhalt() + "f");
				}
				System.out.println("ges:" + ges + "f");

		}
}
