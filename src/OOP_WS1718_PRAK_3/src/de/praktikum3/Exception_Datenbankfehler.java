/**
 class Exception_Datenbankfehler
 @version 1.0
 Eigene Fehlerklasse Datenbankfehler,
 */

package de.praktikum3;

public class Exception_Datenbankfehler extends Exception {

    public Exception_Datenbankfehler(){
    }

    /** wirft custom exeption  */
    /** @param _s String mit dem exeption test*/
    public Exception_Datenbankfehler(String _s){
        super(_s);
    }


}
