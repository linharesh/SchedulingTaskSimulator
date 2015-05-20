/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchedulerClasses;

import java.util.ArrayList;
import schedulersimulator.Model.Processor;
import schedulersimulator.Model.Task;

/**
 *
 * @author linha_000
 */
public class SchedulerSJF extends Scheduler {

    private ArrayList<Task> waitingTaskList;

    public SchedulerSJF() {
        this.waitingTaskList = new ArrayList<>();
    }

    @Override
    public void schedulerIteration(Processor processor) {
        if (processor.isEmpty()) { // if the processor is empty

            if (!this.waitingTaskList.isEmpty()) {

                Task T = this.getTheTaskWithTheShortestTime();
                processor.setTaskInProcessor(T);
            }
        }
    }

    @Override
    public void didArrivedTask(ArrayList<Task> taskList, Processor processor) {
        if (processor.isEmpty()) { // If processor is empty

            if (this.waitingTaskList.isEmpty()) { // If processor is empty AND waitingTaskList is also empty

                Task T = taskList.remove(0); //Get the first task of the taskList

                processor.setTaskInProcessor(T); //Put the task in the processor

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

            Task taskInsideProcessor = processor.getRunningTaskInfo();
            
            Task shortestTimeTask = getTheTaskWithTheShortestTime();

            if (shortestTimeTask.getExecutionTime() < taskInsideProcessor.getExecutionTime()) {
               processor.removeTaskFromProcessor();

                processor.setTaskInProcessor(shortestTimeTask);

                this.waitingTaskList.add(taskInsideProcessor);

            }

        }

    }

    public Task getTheTaskWithTheShortestTime() {
        Task T;
        Task returningTask = null;
        for (int k = 0; k < this.waitingTaskList.size(); k++) {

            T = this.waitingTaskList.get(k);

            if (k == 0) {
                returningTask = T;
            }

            if (T.getExecutionTime() < returningTask.getExecutionTime()) {
                returningTask = T;

            }

        }

        this.waitingTaskList.remove(returningTask);
        return returningTask;
    }

}
