/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulersimulator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henrique
 */
public class Initializer {

    private final String inputFileName = "input.txt";

    public static void main(String[] args) throws IOException {
        Initializer init = new Initializer();
        init.readInputFile();

    }

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
            
            
            Scheduler scheduler = new Scheduler(Policies.Fifo);
            
            Tasks tasks = new Tasks((ArrayList<Task>) taskList);
            
            SearchForEvent.EventSearcher(scheduler, tasks);
            


        } catch (FileNotFoundException ex) {
            ErrorSender.fileNotFound();
        }

    }

}
