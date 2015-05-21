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
 * Class that implements a Shortest Job First scheduler. In the SJF policy, the
 * task that will run first will be the one with the shortest execution time.
 *
 */
public class SchedulerSJF extends Scheduler {

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
    public SchedulerSJF() {
        this.waitingTaskList = new ArrayList<>();
    }

    @Override
    public void schedulerIteration(Processor processor) {
        if (processor.isEmpty()) { // if the processor is empty
            if (!this.waitingTaskList.isEmpty()) {
                Task T = this.getTheTaskWithTheShortestTime();
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
            Task taskInsideProcessor = processor.getRunningTaskInfo();
            Task shortestTimeTask = getTheTaskWithTheShortestTime();
            if (shortestTimeTask.getExecutionTime() < taskInsideProcessor.getExecutionTime()) {
                processor.removeTaskFromProcessor();
                processor.setTaskInProcessor(shortestTimeTask);
                this.waitingTaskList.add(taskInsideProcessor);
            }
        }
    }

    /**
     * Search the waitingTaskList and returns the task with the shortest job
     * time. If there are two tasks with the same shortest job time value team,
     * will be returned the one that have a lower index in the array.
     *
     * @return The task with the shortest job time.
     */
    private Task getTheTaskWithTheShortestTime() {
        Task T;
        Task returningTask = null;
        for (int k = 0; k < this.waitingTaskList.size(); k++) {
            T = this.waitingTaskList.get(k);
            if (k == 0) {
                returningTask = T;
            }
            if (T.getExecutionTime() < returningTask.getExecutionTime()) {
                returningTask = T;
            }
        }
        this.waitingTaskList.remove(returningTask);
        return returningTask;
    }
}
