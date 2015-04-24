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
        this.time = 0;
    }

    public static void searchIteration(int time, Scheduler scheduler, Tasks tasks) {
        ArrayList<Task> T = tasks.searchForArrivalsAtTime(time);
    }

    public static boolean allTasksHaveFinished(Tasks tasks) {
        return (tasks.getTaskList().isEmpty());
    }

    public static void EventSearcher(Scheduler scheduler, Tasks tasks) {
        SearchForEvent.time = 0;

        while (!allTasksHaveFinished(tasks)) {

            System.out.println("Search for event is iterating");

            searchIteration(SearchForEvent.time, scheduler, tasks);

            SearchForEvent.time++;
        }

    }

}
