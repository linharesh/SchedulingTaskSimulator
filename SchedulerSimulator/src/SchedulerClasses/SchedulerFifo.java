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

import java.util.ArrayList;
import schedulersimulator.Model.Processor;
import schedulersimulator.Model.Task;

/**
 * Class that implements a first in - first out scheduler. In the FIFO policy,
 * the first task to arrive the simulator will be the first one to run and
 * finish.
 *
 */
public class SchedulerFifo extends Scheduler {

    /**
     * An ArrayList containing the tasks that are queued waiting to enter the
     * processor
     */
    private ArrayList<Task> waitingTaskList;

    /**
     * Constructor Create a new ArrayList for the local and private ArrayList
     * waitingTaskList. Its necessary to create a instance of the ArrayList()
     * before start using it.
     */
    public SchedulerFifo() {
        this.waitingTaskList = new ArrayList<>();
    }

    @Override
    public void schedule(Processor processor) {
        if (processor.isEmpty()) { // if the processor is empty
            if (!this.waitingTaskList.isEmpty()) {
                Task T = waitingTaskList.remove(0);
                processor.setTaskInProcessor(T);
            }
        }
    }

    @Override
    public void didArrivedTask(ArrayList<Task> taskList, Processor processor) {
        if (processor.isEmpty()) { // If processor is empty
            if (this.waitingTaskList.isEmpty()) { // If processor is empty AND waitingTaskList is also empty
                Task T = taskList.remove(0); //Get the first task of the taskList
                processor.setTaskInProcessor(T); //Put the task in the processor
                if (!taskList.isEmpty()) { //If the taskList still not empty
                    while (!taskList.isEmpty()) {
                        this.waitingTaskList.add(taskList.remove(0)); //Clear the taskList, sending all the remaining tasks to the waitingTaskList
                    }
                }
            }
        } else { // If processor is not empty
            while (!taskList.isEmpty()) {
                this.waitingTaskList.add(taskList.remove(0));
            }
        }
    }
}
