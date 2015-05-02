/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulersimulator;

import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class Scheduler {

    private ArrayList<Task> tasksToEnterInProcessor;

    private Policies Policie;


    public void sortTasksByPolicie() {
        if (this.Policie == Policies.Fifo) {

        }
    }

    public Policies getPolicie() {
        return Policie;
    }

    public Scheduler(Policies Policie) {
        this.tasksToEnterInProcessor = new ArrayList();
        this.Policie = Policie;
    }

    public void setPolicie(Policies Policie) {
        this.Policie = Policie;
    }
    
    public void schedulerIteration(Processor processor){
       
        Task T;
        if (processor.isEmpty()) {
                    if (this.tasksToEnterInProcessor.size() > 0) {
                        T = this.tasksToEnterInProcessor.remove(0);
                            
                            processor.setTaskInProcessor(T, T.getExecutionTime());
                    }
                }
    }

    public void schedulerIteration(ArrayList<Task> taskList, Processor processor) {
        if (this.Policie == Policie.Fifo) {

          //  Task T = taskList.get(0);
            
            if (!taskList.isEmpty()) { // IF the tasklist is NOT empty
                Task T = taskList.remove(0);
                if (processor.isEmpty()) {
                    processor.setTaskInProcessor(T, T.getExecutionTime());
                } else {
                    this.tasksToEnterInProcessor.add(T);
                    System.out.println("here we are adding a new task to the TASKTOENTERINPROCESSOR Array");
                    System.out.println(T.toString());
                }
                
                this.schedulerIteration(taskList, processor);
                
            } 
        }
        
    }

}
