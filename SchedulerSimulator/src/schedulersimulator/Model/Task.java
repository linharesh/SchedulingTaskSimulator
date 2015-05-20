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

/**
 *
 * @author Henrique
 */
public class Task {

    private String name;
    private int arrivalTime;
    private int executionTime;
    private int executionTimeRemaining;

    public Task(String name, int arrivalTime, int executionTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.executionTime = executionTime;
        this.executionTimeRemaining = executionTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public int getExecutionTimeRemaining() {
        return executionTimeRemaining;
    }

    public void setExecutionTimeRemaining(int executionTimeRemaining) {
        this.executionTimeRemaining = executionTimeRemaining;
    }

    @Override
    public String toString() {
        String S = "The task named: " + this.getName() + " have Arrival Time : " + this.arrivalTime + " and wil execute for the time of : " + this.executionTime + ". It still "
                + "remaining " + this.executionTimeRemaining + " time of execution.";

        return S;
    }

}
