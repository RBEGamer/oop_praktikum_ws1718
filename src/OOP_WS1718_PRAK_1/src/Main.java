public class Main {

    public static void main(String[] args) {
        System.out.println("OOS PRAK 1");
        oos_prak_1_aufg1(args);
        oos_prak_1_aufg_2(args);
    }

    public static void oos_prak_1_aufg1(String[] _args){
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
						pascal[i] = new int[i + 1]; //neues array an die neue pos des ersten
				}
				//INITIALE WERTE EINTRAGEN
				pascal[0][0] = 1;
				pascal[1][0] = 1;
				pascal[1][1] = 1;
				//INNERE WERTE BERECHNEN
				for (int i = 2;i < PASCAL_DEPTH; i++){
						pascal[i][0] = 1;
						pascal[i][i] = 1;
						//CALC NETX ROW
						for (int j = 1;j < i; j++){
							pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
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





    public static void oos_prak_1_aufg_2(String[] _args){



		}
}