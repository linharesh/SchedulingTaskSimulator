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
public class SearchForEvent {

    private static int time;

    public SearchForEvent() {
        SearchForEvent.time = 0;
    }

    public static void searchIteration(int time, Scheduler scheduler, Tasks tasks, Processor processor) {
        ArrayList<Task> T = tasks.searchForArrivalsAtTime(time);
        if (!T.isEmpty()) {
            System.out.println("Task left the arrival queue");
        }
        System.out.println(T.toString());
        if (!T.isEmpty()) {
            scheduler.schedulerIteration(T, processor);
        }
    }

    public static boolean allTasksHaveFinished(Tasks tasks, Processor processor) {
        if (!processor.isEmpty()) {
            return false;
        }
        return (tasks.getTaskList().isEmpty());
    }

    public static void EventSearcher(Scheduler scheduler, Tasks tasks) {
        SearchForEvent.time = 0;
        Processor processor = new Processor();

        while (!allTasksHaveFinished(tasks, processor)) {

            System.out.println("Search for event is iterating! time: " + time);

            searchIteration(SearchForEvent.time, scheduler, tasks, processor);

            processor.processorItaration(SearchForEvent.time);

            scheduler.schedulerIteration(processor);

            SearchForEvent.time++;
        }

    }

}
