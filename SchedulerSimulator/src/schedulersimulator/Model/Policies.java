/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulersimulator.Model;

/**
 *
 * @author Henrique
 */
public enum Policies {

    Fifo;

    /**
     * This method recives a string with a name of a scheduling policie and
     * returns the enum of this policie. Case the policie name does not exists
     * or is not implemented by this system, it will return NULL
     *
     * @param S The string with the scheduling policie name
     */
    public static Policies returnPolicieByName(String S) {
     
        if (S.equalsIgnoreCase("fifo")) {
            return Policies.Fifo;
        }
        
        
        
        return null;
    }

}
