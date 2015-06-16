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

import javax.swing.JOptionPane;

/**Class responsible for sending notifications in JOptionPane to the user.
 * If you want to send a notification to the user, you can make a call to 
 * NotificationSender.sendNotification method.
 * If you want to create a class that is only responsible for sending notifications,
 * your class can (or should) extend the NotificationSender class.
 */
public class NotificationSender {

    /**
     * Displays a JOPtionPane message dialog. A simple dialog box with a
     * string and an OK button.
     *
     * @param S The String that will be displayed
     */
    public static void sendNotification(String S) {
        JOptionPane.showMessageDialog(null, S);
    }
    
    /**
     * Display the following message: 
     * "Simulation finished sucessfully. Output text file was created."
     */
    public static void didFinishSimulation(){
        sendNotification("Simulation finished sucessfully. Output text file was created.");
    }
}
