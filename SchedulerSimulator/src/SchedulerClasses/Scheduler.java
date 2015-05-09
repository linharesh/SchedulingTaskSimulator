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

public abstract class Scheduler {
    
    public abstract void schedulerIteration(ArrayList<Task> taskList, Processor processor);
    
}
