/**
 * Scheduling Tasks Simulator Developers: Henrique Linhares, Raphael
 * Quintanilha, Fabrizio Moura and Diogo Souza.
 *
 * Universidade Federal Fluminense
 *
 * https://github.com/linharesh/SchedulingTaskSimulator
 *
 * Please check the software documentation for more information.
 */
package SchedulerClasses;

import schedulersimulator.Model.Policies;

/**Class used to create Scheduler instances.
 * If you want to implement your own scheduling policie on this simulator, 
 * you should modify this class. After adding the name of your scheduling policie
 * on the "Policies" enum, and creating a class that extends "Scheduler", you should
 * add an IF on the createScheduler method. The IF must looks like this:
 * 
 * if (policieInstance == Policies.YourPolicieName){
 *      returningScheduler = new SchedulerYourPolicieName();
 * }
 * 
 * This class conforms to the "Factory" Design Pattern.
 * 
 */
public class SchedulerFactory {

    /**Creates a new instance of Scheduler
     * 
     * @param policieInstance The scheduling policie that you want to use in your scheduler instance
     * @return A scheduler that runs the same policie as passed in param.
     *          EG: param == Policies.Fifo
     *             return: new SchedulerFifo
     */
    public static Scheduler createScheduler(Policies policieInstance) {
        Scheduler returningScheduler = null;

        if (policieInstance == Policies.Fifo) {
            returningScheduler = new SchedulerFifo();
        }
        
        if (policieInstance == Policies.SRT) {
            returningScheduler = new SchedulerSRT();
        }

        return returningScheduler;
    }

}
