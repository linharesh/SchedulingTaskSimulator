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

import SchedulerClasses.Scheduler;
import SchedulerClasses.SchedulerFifo;
import schedulersimulator.InOutFiles.OutputFileWriter;
import schedulersimulator.InOutFiles.NotificationSender;

/** Class responsible for implement the search for events.
 * 
 */
public class SearchForEvent {
    
    private static int time;

    /** Time Getter
     * 
     * @return Time
     */
    private static int getTime() {
        return time;
    }

    /** Time Setter
     * 
     * @param aTime Time
     */
    private static void setTime(int aTime) {
        time = aTime;
    }
    
    /**Constructor
     * Set the time as 0 (zero)
     */
    public SearchForEvent() {
        setTime(0);
    }

    /**@deprecated 
     * This method is not in use anymore.
     * 
     * Verify if all the tasks have finished the simulation.
     * It was used to check if the simulation have finished.
     * 
     * @param tasks The tasks of the simulation
     * @param processor An instance of the processor
     * @param scheduler An instance of the scheduler
     * @return if all tasks have finished, return true
     *         else, return false
     */
    public static boolean allTasksHaveFinished(Tasks tasks, Processor processor, SchedulerFifo scheduler) {
        if (!processor.isEmpty()) {
            return false;
        }
        return (tasks.getTaskList().isEmpty());
    }
    
    /** Central method of this class. 
     * This method performs throughout the simulation , 
     * waiting for events to occur, and when necessary other classes calling.
     * 
     * 
     * @param scheduler An instance of the Scheduler
     * @param tasks An instance of Tasks, containing all tasks in simulation
     */
    public static void eventSearcher(Scheduler scheduler, Tasks tasks) {
        SearchForEvent.setTime(0);
        Processor processor = new Processor();
        processor.setTime(0);
        int timeToEndSimulation = tasks.calculateSimulationEndTime();
        while (time <= timeToEndSimulation) {
            if (tasks.searchForArrivalsAtTime(time).isEmpty()) {
                scheduler.schedule(processor);
            } else {
                scheduler.didArrivedTask(tasks.searchForArrivalsAtTime(time), processor);
            }
            Task T = processor.processorIteration(SearchForEvent.time);
            if (T != null) {
                scheduler.schedule(processor);
                processor.processorIteration(SearchForEvent.time);
            }
            SearchForEvent.setTime(SearchForEvent.getTime() + 1);
            processor.setTime(time);
        }
        OutputFileWriter.closeFile();
        NotificationSender.didFinishSimulation();
    }   
}
