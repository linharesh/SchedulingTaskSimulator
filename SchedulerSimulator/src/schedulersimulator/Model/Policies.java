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
package schedulersimulator.Model;

/**
 * Enumeration of all scheduling policies that work in this simulator. If you
 * want to add a new scheduling policy , it should be added to this enum file.
 *
 */
public enum Policies {

    Fifo, SJF;

    /**
     * This method recives a string with a name of a scheduling policie and
     * returns the enum of this policie. Case the policie name does not exists
     * or is not implemented by this system, it will return NULL
     *
     * @param S The string with the scheduling policie name
     * @return The policie that is equal to the stirng recived
     */
    public static Policies returnPolicieByName(String S) {
        if (S.equalsIgnoreCase("fifo")) {
            return Policies.Fifo;
        }
        if (S.equalsIgnoreCase("sjf")) {
            return Policies.SJF;
        }
        return null;
    }
}
