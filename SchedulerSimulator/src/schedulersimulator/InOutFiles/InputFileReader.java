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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import schedulersimulator.Model.Policies;
import schedulersimulator.Model.Task;

public class InputFileReader {

    private final String inputFileName = "input.txt";
    
    public Policies policy;
    
    public  List<Task> taskList;

    public InputFileReader(){
        try {
            this.read();
        } catch (IOException ex) {
            ErrorSender.generalInputFileReadingError();
        }
    }
    
    
    public void read() throws IOException {
        try {
            BufferedReader inputFileReader = new BufferedReader(new FileReader(this.inputFileName));

            String schedulingPolicy = inputFileReader.readLine();

            
            if (schedulingPolicy == null) {
                ErrorSender.invalidTextFile();
            }

            this.policy = Policies.returnPolicieByName(schedulingPolicy);
            
            if (this.policy == null) {
                ErrorSender.invalidSchedulingPolicy();
                return;
            }
            
            this.taskList = new ArrayList();

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
            
            inputFileReader.close();
            
            
        } catch (FileNotFoundException ex) {
            ErrorSender.fileNotFound();
        }

    }

}
