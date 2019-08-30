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
public class ClienteException extends Exception{

    public ClienteException() {
    }

    public ClienteException(String string) {
        super(string);
    }

    public ClienteException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ClienteException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ClienteException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
}
