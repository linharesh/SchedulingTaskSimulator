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

/**This class represents all the tasks that have 
 * not yet arrived to the simulation.
 * 
 * A task only arrive in the simulation when the arrival time of the task is
 * equal to the simulation time.
 *
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
        for (Task taskList1 : this.taskList) {
            T = taskList1;
            if (T.getArrivalTime() == time) {
                returningArray.add(T);
            }
        }
        return returningArray;
    }

    /** Constructor
     * 
     * @param taskList A list with all tasks
     */
    public Tasks(ArrayList<Task> taskList) {
        this.setTaskList(taskList);
    }

    /** taskList Getter
     * 
     * @return The taskList
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /** taskList Setter
     * 
     * @param taskList the TaskList
     */
    private void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

}
