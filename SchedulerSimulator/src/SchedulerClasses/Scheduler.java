/**
 * Scheduling Tasks Simulator
 * Developers: Henrique Linhares, Raphael Quintanilha, Fabrizio Moura and
 * Diogo Souza.
 * 
 * Universidade Federal Fluminense
 * 
 * https://github.com/linharesh/SchedulingTaskSimulator
 * 
 * Please check the software documentation for more information.
 */

package SchedulerClasses;

import java.util.ArrayList;
import schedulersimulator.Model.Processor;
import schedulersimulator.Model.Task;


/**This is the Abstract Class Scheduler
 * This class works as a superclass for all scheduling policies implemented in this software.
 * If you want to implement a new scheduling policie for this software, we strongly recommend 
 * you to create a class that extends Scheduler.
 * 
 * @author Henrique
 */
public abstract class Scheduler {
    
    /**Method called when a new Task arrives the simulator. Abstract Method.
     * In this method 
     * implementation, you can choose to remove, add or change the task in the processor.
     * 
     * 
     * @param taskList An ArrayList containig the tasks that arrived.
     * @param processor  The simulator processor.
     */
    public abstract void didArrivedTask(ArrayList<Task> taskList, Processor processor);
    
    /**Method called every time the scheduler iterate. In this method 
     * implementation, you can choose to remove, add or change the task in the processor.
     * 
     * @param processor The simulator processor.
     */
    public abstract void schedulerIteration(Processor processor);
    
}
