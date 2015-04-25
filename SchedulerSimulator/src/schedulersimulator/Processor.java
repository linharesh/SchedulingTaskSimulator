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
        Task T = this.taskInProcessor;
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

            this.taskInProcessor.setExecutionTimeRemaining(this.taskInProcessor.getExecutionTimeRemaining() - 1);
            if (time == this.timeToLeave) {
                return removeTaskInProcessor();
            }

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
