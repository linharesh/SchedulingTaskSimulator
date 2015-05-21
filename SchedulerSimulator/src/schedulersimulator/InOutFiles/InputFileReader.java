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



/**Class responsible for reading the text file.
 * When an instance of this class is created, it reads all the information from the 
 * input text file and stores all this information in the class instance.
 * 
 */
public class InputFileReader {
    
    public Policies policy;
    
    public  List<Task> taskList;
    
    
    /**Class constructor
     * Makes a call to the InputFileReader.read method, which reads the input text file
     * 
     * @param inputFileName The name of the input file text to be read. Eg: "input.txt"
     */
    public InputFileReader(String inputFileName){
        this.read(inputFileName);
    }
    
    /** Method that reads the input text file.
     *  This is a private method.
     *  It should not be called outside the InputFileReader class.
     * 
     * @param inputFileName The name of the input file text to be read. Eg: "input.txt"
     */
    private void read(String inputFileName) {
        try {
            BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFileName));
            String schedulingPolicy = null;
            try {
                schedulingPolicy = inputFileReader.readLine();
            } catch (IOException ex) {
                ErrorSender.inputFileReadingError();
            }
            if (schedulingPolicy == null) {
                ErrorSender.invalidTextFile();
            }
            this.policy = Policies.returnPolicieByName(schedulingPolicy);
            if (this.policy == null) {
                ErrorSender.invalidSchedulingPolicy();
                return;
            }
            this.taskList = new ArrayList();
            String taskStringInfo = null;
            try {
                taskStringInfo = inputFileReader.readLine();
            } catch (IOException ex) {
                ErrorSender.inputFileReadingError();
            }
            while (taskStringInfo != null) {
                String[] splitedTaskStringInfo = taskStringInfo.split("-");
                String arrivalTimeString = splitedTaskStringInfo[1];
                int arrivalTimeInt = Integer.parseInt(arrivalTimeString);
                String executionTimeString = splitedTaskStringInfo[2];
                int executionTimeInt = Integer.parseInt(executionTimeString);
                Task T = new Task(splitedTaskStringInfo[0], arrivalTimeInt, executionTimeInt);
                taskList.add(T);
                try {
                    taskStringInfo = inputFileReader.readLine();
                } catch (IOException ex) {
                    ErrorSender.inputFileReadingError();
                }
            }
            try {
                inputFileReader.close();
            } catch (IOException ex) {
                ErrorSender.errorWhileClosingInputFile();
            }
        } catch (FileNotFoundException ex) {
            ErrorSender.fileNotFound();
        }
    }
}
