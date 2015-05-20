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
package schedulersimulator.Model;

import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class Tasks {

    private ArrayList<Task> taskList;

    /** Search all tasks and returns the tasks that have Arrival Time equals to the number in param.
     * 
     * @param time The number that this method will search in Tasks`s arrival time.
     * @return An ArrayList containing all the tasks that have Arrival Time equals to the param "time"
     */
    public ArrayList<Task> searchForArrivalsAtTime(int time) {
 

        ArrayList<Task> returningArray = new ArrayList();

        Task T;
        for (int k = 0; k < this.taskList.size(); k++) {

            T = taskList.get(k);

            if (T.getArrivalTime() == time) {
                returningArray.add(T);

            }

        }

        return returningArray;
    }

    public Tasks(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

}
