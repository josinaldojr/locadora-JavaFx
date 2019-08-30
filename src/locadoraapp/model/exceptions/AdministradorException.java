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
public class AdministradorException extends Exception{

    public AdministradorException() {
    }

    public AdministradorException(String string) {
        super(string);
    }

    public AdministradorException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public AdministradorException(Throwable thrwbl) {
        super(thrwbl);
    }

    public AdministradorException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
}
