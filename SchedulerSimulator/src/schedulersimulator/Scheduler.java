/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulersimulator;



/**
 *
 * @author Henrique
 */
public class Scheduler {


    private Policies Policie;

    public void sortTasksByPolicie() {
        if (this.Policie == Policies.Fifo) {
            
        }
    }

    public Policies getPolicie() {
        return Policie;
    }

    public Scheduler(Policies Policie) {

        this.Policie = Policie;
    }

    public void setPolicie(Policies Policie) {
        this.Policie = Policie;
    }


    
}
