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
           
            if (!SchedulePolicy.equalsIgnoreCase("fifo")) {
                return;
            }
            
            String taskStringInfo = inputFileReader.readLine();
            if (taskStringInfo == null){
                System.out.println("Erro na formataçao do arquivo");
                return;
            }
            
            String[] splitedTaskStringInfo = taskStringInfo.split("-");
            
            
            
            //Task T = new Task(splitedTaskStringInfo[0], splitedTaskStringInfo[1], splitedTaskStringInfo[2]);
            
            

        } catch (FileNotFoundException ex) {
            System.out.println("Error while reading input file!");
        }

    }

}
