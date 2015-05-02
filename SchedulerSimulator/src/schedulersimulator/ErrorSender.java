/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulersimulator;

/**
 *
 * @author Henrique
 */
public class ErrorSender {

    public static void fileNotFound() {
        System.out.println("Error 001 - File Not Found.");
    }

    public static void invalidSchedulingPolicy() {
        System.out.println("Error 002 - Invalid Scheduling Policy written on input text file.");
    }

    public static void invalidTextFile() {
        System.out.println("Error 003 - Invalid text file");
    }

    public static void errorClosingOutputFile() {
        System.out.println("Error 037 - Error while closing Output report file.");
    }

    
    public static void errorWritingTaskInfoIntoReport(){
        System.out.println("Error 100 - Error while writing Task (entering in processor) infos in output report file.");
    }
    
}
