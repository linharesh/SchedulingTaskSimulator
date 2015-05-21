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

/**
 * Class responsible for sending error messages to the user. When an error is
 * detected by the system, this class is called , and displays on the screen a
 * JOptionPane informing the user more details about the error detected.
 *
 * Note: We do not warrant that all software errors are described in this class.
 * You can improve the system by writing new methods in this class and adding
 * calls to them.
 *
 */
public class ErrorSender extends NotificationSender {

    /**
     * Display the following message: "Error 010 - Error while reading input
     * text file."
     */
    public static void inputFileReadingError() {
        NotificationSender.sendNotification("Error 010 - Error while reading input text file.");
    }

    /**
     * Display the following message: "Error 011 - File Not Found."
     */
    public static void fileNotFound() {
        sendNotification("Error 011 - File Not Found.");
    }

    /**
     * Display the following message: "Error 012 - Invalid Scheduling Policy
     * written on input text file."
     */
    public static void invalidSchedulingPolicy() {
        sendNotification("Error 012 - Invalid Scheduling Policy written on input text file.");
    }

    /**
     * Display the following message: "Error 014 - Invalid text file."
     */
    public static void invalidTextFile() {
        sendNotification("Error 014 - Invalid text file");
    }

    /**
     * Display the following message: "Error 015 - Error while closing input
     * text file"
     */
    public static void errorWhileClosingInputFile() {
        sendNotification("Error 015 - Error while closing input text file");
    }

    /**
     * Display the following message: "Error 020 - Error while closing Output
     * file."
     */
    public static void errorClosingOutputFile() {
        sendNotification("Error 020 - Error while closing Output file.");
    }

    /**
     * Display the following message: "Error 021 - Error while writing Task
     * (entering in processor) infos in output report file."
     */
    public static void errorWritingTaskInfoIntoReport() {
        sendNotification("Error 021 - Error while writing Task (entering in processor) infos in output report file.");
    }

    /**
     * Display the following message: "Error 022 - Error while opening Output
     * file."
     */
    public static void errorOpeningOutputFile() {
        sendNotification("Error 022 - Error while opening Output file.");
    }

    /**
     * Display the following message: "Error 023 - Error while creating Output 
     * file."
     */
    public static void errorCreatingOutputFile() {
        sendNotification("Error 023 - Error while creating Output file.");
    }
}
