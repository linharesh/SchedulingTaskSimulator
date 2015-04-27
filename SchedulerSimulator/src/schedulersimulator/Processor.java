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
public class Processor {

    private Task taskInProcessor;
    int timeToLeave;

    public Processor(){
    taskInProcessor=null;
    }
    
    public Task removeTaskInProcessor() {
        System.out.println("Task leaving processor");
    
        Task T = this.taskInProcessor;
        
        System.out.println(T.toString());
        
        this.taskInProcessor = null;
        return T;
    }

    public void setTaskInProcessor(Task taskInProcessor, int timeToLeave) {
        System.out.println("Task entering processor");
        System.out.println("Task description: "+taskInProcessor.toString());
        this.taskInProcessor = taskInProcessor;
        this.timeToLeave = timeToLeave;
    }

    public Task processorItaration(int time) {
        System.out.println("Processor iterating");
        if (this.taskInProcessor != null) {
            System.out.println("Task running: " + this.taskInProcessor.toString());
            System.out.println("time to leave: "+this.timeToLeave);
            
              if (this.taskInProcessor.getExecutionTimeRemaining() <= 0) {
                return removeTaskInProcessor();
            }

            
            this.taskInProcessor.setExecutionTimeRemaining(this.taskInProcessor.getExecutionTimeRemaining() - 1);
          
        } else {
            System.out.println("Processor empty");
        }

        return null;
    }

    public boolean isEmpty() {
        if (taskInProcessor != null) {
            return false;
        } else {
            return true;
        }
    }
}
