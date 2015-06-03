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
package schedulersimulator.Model;

import java.util.ArrayList;

/**
 * This class represents all the tasks that have not yet arrived to the
 * simulation.
 *
 * A task only arrive in the simulation when the arrival time of the task is
 * equal to the simulation time.
 *
 */
public class Tasks {

    private ArrayList<Task> taskList;

    /**
     * Search all tasks and returns the tasks that have Arrival Time equals to
     * the number in param.
     *
     * @param time The number that this method will search in Tasks`s arrival
     * time.
     * @return An ArrayList containing all the tasks that have Arrival Time
     * equals to the param "time"
     */
    public ArrayList<Task> searchForArrivalsAtTime(int time) {
        ArrayList<Task> returningArray = new ArrayList();
        Task T;
        for (Task taskList1 : this.taskList) {
            T = taskList1;
            if (T.getArrivalTime() == time) {
                returningArray.add(T);
            }
        }
        return returningArray;
    }

    /**
     * Constructor
     *
     * @param taskList A list with all tasks
     */
    public Tasks(ArrayList<Task> taskList) {
        this.setTaskList(taskList);
    }

    /**
     * taskList Getter
     *
     * @return The taskList
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**
     * taskList Setter
     *
     * @param taskList the TaskList
     */
    private void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    /**Calculates the sum of execution time of all tasks.
     * Iterates the task list, getting the execution time and adding to a sum.
     * 
     * @return The sum of execution time of all tasks.
     */
    private int calculateExecutionTimeSum() {
        int executionTimeSum = 0;
        Task T;
        for (Task taskList1 : this.taskList) {
            T = taskList1;
            executionTimeSum = executionTimeSum + T.getExecutionTime();
        }
        return executionTimeSum;
    }

    /**Gets the task with the bigger Arrival time
     * Iterates the task list searching for the task with the bigger number of arrival time.
     * 
     * @return If the task list is not empty, return the task with the bigger arrival time.
     *         If the task list is empty, return null.
     *         Warning! This method CAN return null! 
     *         It is very recommended to test the returning task of this method
     *         before trying to use it!
     */
    private Task getTheTaskWithBiggerArrivalTime() {
        Task T = null;

        if (!this.taskList.isEmpty()) {
            T = this.taskList.get(0);
            for (Task taskAux : this.taskList) {
                if (taskAux.getArrivalTime() > T.getArrivalTime()) {
                    T = taskAux;
                }
            }
        }
        return T;
    }

    /**Calculate the end time of the simulation.
     * The end of the simulation time is given by the the sum of all tasks execution time,  
     * plus the time of the task that has the bigger arrival time.
     * Using this formula, we can guarantee that all tasks will be simulated 
     * before the calculated end of simulation time.
     * 
     * @return An int that represents the last time that the simulation
     *         needs to run.
     *         If the task list is empty, it will return 0 (zero)
     */
    public int calculateSimulationEndTime() {
        int simulationMaximumTime=calculateExecutionTimeSum();
        Task T = getTheTaskWithBiggerArrivalTime();
        if (T!=null){
        simulationMaximumTime = simulationMaximumTime + T.getArrivalTime();
        }
        return simulationMaximumTime;
    }

}
