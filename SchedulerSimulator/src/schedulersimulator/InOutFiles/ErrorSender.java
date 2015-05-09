/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulersimulator.InOutFiles;

/**
 *
 * @author Henrique
 */
public class ErrorSender {

    //*********************************************************************
    //   ERROR 01X - ERRORS WHILE READING INPUT FILE
    public static void generalInputFileReadingError(){
        System.out.println("Error 010 - General error while reading input text file.");
    }
   
    
    public static void fileNotFound() {
        System.out.println("Error 011 - File Not Found.");
    }

    public static void invalidSchedulingPolicy() {
        System.out.println("Error 012 - Invalid Scheduling Policy written on input text file.");
    }

    public static void invalidTextFile() {
        System.out.println("Error 014 - Invalid text file");
    }
    //*********************************************************************
    

    public static void errorClosingOutputFile() {
        System.out.println("Error 037 - Error while closing Output report file.");
    }

    
    public static void errorWritingTaskInfoIntoReport(){
        System.out.println("Error 100 - Error while writing Task (entering in processor) infos in output report file.");
    }
    
}
