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
package schedulersimulator.InOutFiles;

import SchedulerClasses.Scheduler;
import java.io.IOException;
import java.util.ArrayList;
import schedulersimulator.Model.Policies;
import SchedulerClasses.SchedulerFifo;
import SchedulerClasses.SchedulerSJF;
import schedulersimulator.Model.SearchForEvent;
import schedulersimulator.Model.Task;
import schedulersimulator.Model.Tasks;

/**
 * The first class that is executed in this software . It creates an instance of
 * the class InputFileReader creates data structures, and makes the call to the
 * method of EventSearcher SearchForEvent class, which initiates the simulation.
 *
 * @author Henrique
 */
public class Initializer {

    private final String inputFileName = "input.txt";

    public static void main(String[] args) throws IOException {
        InputFileReader fileReaderInstance = new InputFileReader();
        prepareForStartSimulation(fileReaderInstance);
    }

    /**
     * Prepare files and data structures to start the simulation. At the end of
     * this method, the eventSearcher is called, starting the simulation.
     *
     * @param fileReaderInstance An instance of the InputFileReader Class. The
     * instance of this class contains all the information of the Input File,
     * such as the scheduling policy and the tasks.
     */
    public static void prepareForStartSimulation(InputFileReader fileReaderInstance) {
        try {
            //Open the output file to start writing the logs
            OutputFileWriter.setup();
        } catch (IOException ex) {
            ErrorSender.errorOpeningOutputFile();
        }

        Scheduler scheduler = null;

        if (fileReaderInstance.policy == Policies.Fifo) {
            scheduler = new SchedulerFifo();
        }

        if (fileReaderInstance.policy == Policies.SJF) {
            scheduler = new SchedulerSJF();
        }

        Tasks tasks = new Tasks((ArrayList<Task>) fileReaderInstance.taskList);
        SearchForEvent.EventSearcher((Scheduler) scheduler, tasks);
    }
}
