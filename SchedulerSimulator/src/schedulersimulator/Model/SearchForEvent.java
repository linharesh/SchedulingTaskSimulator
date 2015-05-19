/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulersimulator.Model;

import SchedulerClasses.SchedulerFifo;
import schedulersimulator.InOutFiles.OutputFileWriter;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class SearchForEvent {

    private static int time;

    public SearchForEvent() {
        SearchForEvent.time = 0;
    }

    /**@deprecated 
     * 
     * @param time
     * @param scheduler
     * @param tasks
     * @param processor
     * @return 
     */
    public static ArrayList<Task> searchIteration(int time, SchedulerFifo scheduler, Tasks tasks, Processor processor) {
        ArrayList<Task> T = tasks.searchForArrivalsAtTime(time);


        if (!T.isEmpty()) {
            System.out.println("Task left the arrival queue");
            System.out.println(T.toString());
            
        }
        return null;
    }

    public static boolean allTasksHaveFinished(Tasks tasks, Processor processor, SchedulerFifo scheduler) {

        if (!processor.isEmpty()) {
            return false;
        }

        return (tasks.getTaskList().isEmpty());

    }

    public static void EventSearcher(SchedulerFifo scheduler, Tasks tasks) {
        SearchForEvent.time = 0;
        Processor processor = new Processor();
        processor.setTime(0);
        
        

        // while (!allTasksHaveFinished(tasks, processor, scheduler)) {
        while (time < 500) {
            System.out.println("Search for event is iterating! time: " + time);

            //searchIteration(SearchForEvent.time, scheduler, tasks, processor);

            if (tasks.searchForArrivalsAtTime(time).isEmpty()){
                scheduler.schedulerIteration(processor);
            } else {
            scheduler.didArrivedTask(tasks.searchForArrivalsAtTime(time), processor);
            }
            
            
            processor.processorItaration(SearchForEvent.time);

            SearchForEvent.time++;
            processor.setTime(time);
        }

        OutputFileWriter.close();

    }

}
