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

    private ArrayList<Task> tasksToEnterInProcessor;

    public SchedulerFifo() {
        this.tasksToEnterInProcessor = new ArrayList();
    }

    /*
     public void schedulerIteration(Processor processor){
       
     Task T;
     if (processor.isEmpty()) {
     if (this.tasksToEnterInProcessor.size() > 0) {
     T = this.tasksToEnterInProcessor.remove(0);
                            
     processor.setTaskInProcessor(T, T.getExecutionTime() - 1 );
     }
     }
     }
     /*
     public void schedulerIteration(ArrayList<Task> taskList, Processor processor) {
       
     if (this.Policie == Policie.Fifo) {

     //  Task T = taskList.get(0);
            
     if (!taskList.isEmpty()) { // IF the tasklist is NOT empty
     Task T = taskList.remove(0);
     if (processor.isEmpty()) {
     processor.setTaskInProcessor(T, T.getExecutionTime() - 1);
     } else {
     this.tasksToEnterInProcessor.add(T);
     System.out.println("here we are adding a new task to the TASKTOENTERINPROCESSOR Array");
     System.out.println(T.toString());
     }
                
     this.schedulerIteration(taskList, processor);
                
     } 
     }
        
     }
     */
    /**
     *
     * @param taskList
     * @param processor
     */
    @Override
    public void schedulerIteration(ArrayList<Task> taskList, Processor processor) {

        if (!taskList.isEmpty()) { // IF the tasklist is NOT empty
            Task T = taskList.remove(0);
            if (processor.isEmpty()) {
                processor.setTaskInProcessor(T, T.getExecutionTime());
            } else {
                if (T != processor.getRunningTaskInfo()) {
                    this.tasksToEnterInProcessor.add(T);
                }

                while (!taskList.isEmpty()) {
                    T = taskList.remove(0);
                    if (T != processor.getRunningTaskInfo()) {
                        this.tasksToEnterInProcessor.add(T);
                    }

                }
            }

        }

        Task T;
        if (processor.isEmpty()) {
            if (this.tasksToEnterInProcessor.size() > 0) {
                T = this.tasksToEnterInProcessor.remove(0);

                processor.setTaskInProcessor(T, T.getExecutionTime());
            }
        }
    }

}
