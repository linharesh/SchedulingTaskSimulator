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
public class Tasks {

    private ArrayList<Task> taskList;

    public ArrayList<Task> searchForArrivalsAtTime(int time) {

        ArrayList<Task> returningArray = new ArrayList();
        
        int taskListSize = taskList.size();
        Task T;
        for (int k = 0; k < taskListSize; k++) {
            T = taskList.get(k);

            if (T.getArrivalTime() == time) {
                returningArray.add(T);
                this.taskList.remove(T);
                taskListSize--;
            }

        }

        return returningArray;
    }

    public Tasks(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

}
