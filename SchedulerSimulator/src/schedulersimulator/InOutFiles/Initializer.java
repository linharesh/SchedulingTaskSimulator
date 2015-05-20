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

package schedulersimulator.InOutFiles;

import SchedulerClasses.Scheduler;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import schedulersimulator.Model.Policies;
import SchedulerClasses.SchedulerFifo;
import SchedulerClasses.SchedulerSJF;
import schedulersimulator.Model.SearchForEvent;
import schedulersimulator.Model.Task;
import schedulersimulator.Model.Tasks;

/**
 *
 * @author Henrique
 */
public class Initializer {

    private final String inputFileName = "input.txt";

    public static void main(String[] args) throws IOException {
       // Initializer init = new Initializer();
       // init.readInputFile();
        
        InputFileReader fileReaderInstance = new InputFileReader();
      
        prepareForStartSimulation(fileReaderInstance);
        
    }

    
    public static void prepareForStartSimulation(InputFileReader instance){
        try {
            //Open the output file to start writing the logs
            OutputFileWriter.setup();
        } catch (IOException ex) {
            Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            Scheduler scheduler = null;
            
            if (instance.policy == Policies.Fifo){
            scheduler = new SchedulerFifo();
            }
            
            if (instance.policy == Policies.SJF){
            scheduler = new SchedulerSJF();
            }
            
            
                
                
            Tasks tasks = new Tasks((ArrayList<Task>) instance.taskList);

            SearchForEvent.EventSearcher((Scheduler) scheduler, tasks);
    }
    
    
    /** @deprecated 
     *  
     * 
     * @throws IOException 
     */
    public void readInputFile() throws IOException {
        try {
            BufferedReader inputFileReader = new BufferedReader(new FileReader(this.inputFileName));

            String SchedulePolicy = inputFileReader.readLine();

            
            if (SchedulePolicy == null) {
                ErrorSender.invalidTextFile();
            }

            if (!SchedulePolicy.equalsIgnoreCase("fifo")) {
                ErrorSender.invalidSchedulingPolicy();
                return;
            }

            List<Task> taskList = new ArrayList();

            String taskStringInfo = inputFileReader.readLine();

            while (taskStringInfo != null) {

                String[] splitedTaskStringInfo = taskStringInfo.split("-");

                String arrivalTimeString = splitedTaskStringInfo[1];

                int arrivalTimeInt = Integer.parseInt(arrivalTimeString);

                String executionTimeString = splitedTaskStringInfo[2];

                int executionTimeInt = Integer.parseInt(executionTimeString);

                Task T = new Task(splitedTaskStringInfo[0], arrivalTimeInt, executionTimeInt);

                System.out.println(T.toString());

                taskList.add(T);

                taskStringInfo = inputFileReader.readLine();

            }

            //Close the input file after reading all info
            inputFileReader.close();
            
            //Open the output file to start writing the logs
            OutputFileWriter.setup();
            
            SchedulerFifo scheduler = new SchedulerFifo();

            Tasks tasks = new Tasks((ArrayList<Task>) taskList);

            SearchForEvent.EventSearcher(scheduler, tasks);

        } catch (FileNotFoundException ex) {
            ErrorSender.fileNotFound();
        }

    }

}
