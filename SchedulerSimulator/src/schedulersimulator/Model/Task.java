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

/**This class represents a single task.
 * 
 */
public final class Task {

    /**
     * Name of the Task.
     */
    private String name;
    
    /**
     * The time that this task will arrive in the simulation system.
     */
    private int arrivalTime;
    
    /**
     * The time that this task will take of running inside the processor.
     */
    private int executionTime;
    
    /**
     * The time remaining of execution of this task.
     * executionTimeRemaining must be smaller or equal to executionTime!
     */
    private int executionTimeRemaining;

    /** Constructor
     *  Call this method to instantiate a new object from Task class.
     * 
     * @param name The name of the task.
     * @param arrivalTime The time that this task will take in processor.
     * @param executionTime  The time remaining from this task execution.
     */
    public Task(String name, int arrivalTime, int executionTime) {
        this.setName(name);
        this.setArrivalTime(arrivalTime);
        this.setExecutionTime(executionTime);
        this.setExecutionTimeRemaining(executionTime);
    }

    /**Task Name Getter
     * 
     * @return The name of the Task
     */
    public String getName() {
        return name;
    }

    /**Task Name Setter
     * 
     * @param name the name of the Task
     */
    private void setName(String name) {
        this.name = name;
    }

    /** Task Arrival Time Getter
     * 
     * @return The Task Arrival Time
     */
    public int getArrivalTime() {
        return arrivalTime;
    }
    
    /**Task Arrival Time Setter
     * 
     * @param arrivalTime The Task Arrival Time
     */
    private void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**Task Execution Time Getter
     * 
     * @return The Task Execution Time
     */
    public int getExecutionTime() {
        return executionTime;
    }

    /**Task Execution Time Setter
     * 
     * @param executionTime The Task Execution Time
     */
    private void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    /**Task Execution Time Remaining Getter
     * 
     * @return The Task Execution Time Remaining
     */
    public int getExecutionTimeRemaining() {
        return executionTimeRemaining;
    }

    /**Task Execution Time Remaining Setter
     * 
     * @param executionTimeRemaining The Task Execution Time Remaining
     */
    public void setExecutionTimeRemaining(int executionTimeRemaining) {
        this.executionTimeRemaining = executionTimeRemaining;
    }

    /**A String description of the Task.
     * 
     * @return A String containing a description of the task.
     */
    @Override
    public String toString() {
        String S = "The task named: " + this.getName() + " have Arrival Time : " + this.getArrivalTime() + " and wil execute for the time of : " + this.getExecutionTime() + ". It still "
                + "remaining " + this.getExecutionTimeRemaining() + " time of execution.";

        return S;
    }

}
