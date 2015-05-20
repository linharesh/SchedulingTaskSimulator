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
import schedulersimulator.Model.Tasks;

/**
 *
 * @author Henrique
 */
public class SchedulerFifo extends Scheduler {

    private ArrayList<Task> waitingTaskList;
    
    
    public SchedulerFifo(){
    this.waitingTaskList = new ArrayList<>();
    }

    @Override
    public void schedulerIteration(Processor processor) {

        if (processor.isEmpty()) { // if the processor is empty

            if (!this.waitingTaskList.isEmpty()) {
               
                Task T = waitingTaskList.remove(0);
                processor.setTaskInProcessor(T, T.getExecutionTimeRemaining());
            }
        }

    }

    @Override
    public void didArrivedTask(ArrayList<Task> taskList, Processor processor) {

        if (processor.isEmpty()) { // If processor is empty

            if (this.waitingTaskList.isEmpty()) { // If processor is empty AND waitingTaskList is also empty

                Task T = taskList.remove(0); //Get the first task of the taskList

                processor.setTaskInProcessor(T, T.getExecutionTimeRemaining()); //Put the task in the processor

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
