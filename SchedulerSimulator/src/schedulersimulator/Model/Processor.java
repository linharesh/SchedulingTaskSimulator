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

import schedulersimulator.InOutFiles.OutputFileWriter;

/**
 * This class represents the simulation processor. When a task enters the
 * processor, it should enter into an instance of this class
 *
 * @author Henrique
 */
public class Processor {

    /**
     * The task that is inside the processor at the time.
     */
    private Task taskInProcessor;

    /**
     * The time in which the simulation is.
     */
    private int time;

    /**
     * Processor constructor Creates a new empty Processor (without any tasks
     * inside)
     */
    public Processor() {
        taskInProcessor = null;
    }

    /**
     * Getter method for time
     *
     * @return time
     */
    public int getTime() {
        return this.time;
    }

    /**
     * Setter method for time
     *
     * @param Time time
     */
    public void setTime(int Time) {
        this.time = Time;
    }

    /**
     * Returns an instance of the task that is running in processor. If the
     * processor is empty, this method will return null.
     *
     * @return an instance of the task that is running in processor
     */
    public Task getRunningTaskInfo() {
        return this.taskInProcessor;
    }

    /**
     * Removes the task that was in the processor.
     *
     * @return An instance of the task that was removed from the processor.
     */
    public Task removeTaskFromProcessor() {
        OutputFileWriter.writeTaskLeavingProcessorEvent(taskInProcessor, time);
        Task T = this.getRunningTaskInfo();
        this.setTaskInProcessorAsNull();
        return T;
    }

    /**
     * Set the value of the taskInProcessor as NULL It should be used ONLY
     * inside Processor class.
     */
    private void setTaskInProcessorAsNull() {
        this.taskInProcessor = null;
    }

    /**
     * Method used to add a new task into the processor.
     *
     * @param taskInProcessor The Task that you want to put in the processor.
     */
    public void setTaskInProcessor(Task taskInProcessor) {
        OutputFileWriter.writeTaskEnteringProcessorEvent(taskInProcessor, time);
        this.taskInProcessor = taskInProcessor;
    }

    /**
     * This method represents an iteration of the processor. Verify if the task
     * had finished running. If the task is already done, remove the processor
     * task. If the task have not finished , decrements the remaining time of
     * task execution(ExecutionTimeRemaining) .
     *
     * @param time The time that the simulation is. This value should be passed
     * from SearchForEvent(or any other class that calls this method).
     *
     *
     * @return If the task is leaving the processor, returns the task that was
     * inside the processor. If the task is not leaving the processor, dont
     * return nothing (return null)
     */
    public Task processorIteration(int time) {
        if (!this.isEmpty()) { // if processor is not empty
            if (this.taskInProcessor.getExecutionTimeRemaining() <= 0) {
                return removeTaskFromProcessor();
            }
            this.taskInProcessor.setExecutionTimeRemaining(this.taskInProcessor.getExecutionTimeRemaining() - 1);
        }
        this.setTime(time);
        return null;
    }

    /**
     * This method verify if there is any task inside the processor.
     *
     * @return If there is no task within the processor, returns TRUE. If there
     * is any task within the processor, returns FALSE.
     */
    public boolean isEmpty() {
        return taskInProcessor == null;
    }
}
