/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulerClasses;

import java.util.ArrayList;
import schedulersimulator.Model.Policies;
import schedulersimulator.Model.Processor;
import schedulersimulator.Model.Task;

/**
 *
 * @author Henrique
 */
public class SchedulerFifo extends Scheduler {

    private ArrayList<Task> waitingTaskList;

    @Override
    public void schedulerIteration(Processor processor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void didArrivedTask(ArrayList<Task> taskList, Processor processor) {

        if (processor.isEmpty()) { // If processor is empty

            if (this.waitingTaskList.isEmpty()) { // If processor is empty AND waitingTaskList is also empty

                
                Task T = taskList.remove(0); //Get the first task of the taskList
                
                processor.setTaskInProcessor(T, T.getExecutionTimeRemaining()); //Puts the task on the processor
                
                if (!taskList.isEmpty()) { //If the taskList still not empty
                    while (!taskList.isEmpty()) {                      
                        this.waitingTaskList.add(taskList.remove(0)); //Clear the taskList, sending all the remaining tasks to the waitingTaskList
                    }
                }
            }

        } else { // If processor is not empty
            while (!taskList.isEmpty()) {
                this.waitingTaskList.add(taskList.remove(0));
            }

        }

    }

}
