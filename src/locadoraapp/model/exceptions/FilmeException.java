/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadoraapp.model.exceptions;

/**
 *
 * @author Josinaldo
 */
public class FilmeException extends Exception {

    public FilmeException() {
    }

    public FilmeException(String string) {
        super(string);
    }

    public FilmeException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public FilmeException(Throwable thrwbl) {
        super(thrwbl);
    }

    public FilmeException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
}
