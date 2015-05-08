/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulersimulator.Model;

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

    public static void searchIteration(int time, Scheduler scheduler, Tasks tasks, Processor processor) {
        ArrayList<Task> T = tasks.searchForArrivalsAtTime(time);
        
        System.out.println("");
        
        if (!T.isEmpty()) {
            System.out.println("Task left the arrival queue");
            System.out.println(T.toString());
            scheduler.schedulerIteration(T, processor);
        }
    }

    public static boolean allTasksHaveFinished(Tasks tasks, Processor processor, Scheduler scheduler) {
      
        if (!processor.isEmpty()) {
            return false;
        }
        
        return (tasks.getTaskList().isEmpty());
        
       
    }

    public static void EventSearcher(Scheduler scheduler, Tasks tasks) {
        SearchForEvent.time = 0;
        Processor processor = new Processor();
        processor.setTime(0);

        while (!allTasksHaveFinished(tasks, processor, scheduler)) {

            processor.processorItaration(SearchForEvent.time);
            
            System.out.println("Search for event is iterating! time: " + time);

            searchIteration(SearchForEvent.time, scheduler, tasks, processor);

            scheduler.schedulerIteration(processor);

            SearchForEvent.time++;
            processor.setTime(time);
        }

        OutputFileWriter.close();
        
    }

}
