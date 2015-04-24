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
public class SearchForEvent {
private int time;

    public SearchForEvent() {
        this.time = 0;
    }

public static void searchIteration(int time, Scheduler scheduler, Tasks tasks){
    System.out.println(tasks.searchForArrivalsAtTime(time).toString());
}
    
    
public static void EventSearcher(Scheduler scheduler, Tasks tasks){
    System.out.println("Im on event searcher now.");
    searchIteration(0, scheduler, tasks);
    
}

    
    
    
}
