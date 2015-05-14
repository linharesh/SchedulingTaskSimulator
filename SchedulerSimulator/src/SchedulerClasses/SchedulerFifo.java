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

    private ArrayList<Task> taskList;

    @Override
    public void schedulerSetup(ArrayList<Task> taskList) {
        this.taskList = taskList;
        sortByArrivalTime();
        System.out.println("");

    }

    @Override
    public void schedulerIteration(Processor processor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sortByArrivalTime() {
        
        int i = 0;
        
        
        
        
        for (i = 0; i < taskList.size() - 1; i++) {
            for (int j = 0; j < taskList.size() - 2; j++) {
                if (taskList.get(j).getArrivalTime() > taskList.get(j+1).getArrivalTime()) {
                    
                    Task aux = taskList.get(j);
                    
                    taskList.remove(j);
                    
                    taskList.add(j, taskList.get(j));
                    
                    taskList.remove(j+1);
                    
                    taskList.add(j + 1, aux);
                    
            
                }
            }
        }

    }

    /**
     * @deprecated
     *
     * @param lowerIndex
     * @param higherIndex
     */
    public void sortByArrivalTime(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;

        // calculate pivot number, I am taking pivot as middle index number
        int pivot = taskList.get(lowerIndex + (higherIndex - lowerIndex) / 2).getArrivalTime();
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a
             * number from right side which is less then the pivot value. Once
             * the search is done, then we exchange both numbers.
             */
            while (taskList.get(i).getArrivalTime() < pivot) {
                i++;
            }
            while (taskList.get(j).getArrivalTime() > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j) {
            sortByArrivalTime(lowerIndex, j);
        }
        if (i < higherIndex) {
            sortByArrivalTime(i, higherIndex);
        }

    }

    private void exchangeNumbers(int i, int j) {
        Task temp = taskList.remove(i);
        taskList.add(i, taskList.remove(j - 1));
        taskList.add(j, temp);
    }

    /*
     private ArrayList<Task> tasksToEnterInProcessor;

     public SchedulerFifo() {
     this.tasksToEnterInProcessor = new ArrayList();
     }
    
    
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
     * @deprecated
     *
     * @param taskList
     * @param processor
     *
     * @Override public void schedulerIteration(ArrayList<Task> taskList,
     * Processor processor) {
     *
     * if (!taskList.isEmpty()) { // IF the tasklist is NOT empty Task T =
     * taskList.remove(0);
     *
     * if (T.getArrivalTime() > processor.getTime()) { taskList.add(T); }
     *
     * if (processor.isEmpty()) { processor.setTaskInProcessor(T,
     * T.getExecutionTime()); } else { if (T != processor.getRunningTaskInfo())
     * { this.tasksToEnterInProcessor.add(T); }
     *
     * while (!taskList.isEmpty()) { T = taskList.remove(0); if (T !=
     * processor.getRunningTaskInfo()) { this.tasksToEnterInProcessor.add(T); }
     *
     * }
     * }
     *
     * }
     *
     * Task T; if (processor.isEmpty()) { if
     * (this.tasksToEnterInProcessor.size() > 0) { T =
     * this.tasksToEnterInProcessor.remove(0);
     *
     * processor.setTaskInProcessor(T, T.getExecutionTime()); } } }
     */
}
