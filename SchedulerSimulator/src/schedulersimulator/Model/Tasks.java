/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulersimulator.Model;

import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class Tasks {

    private ArrayList<Task> taskList;

    public ArrayList<Task> searchForArrivalsAtTime(int time) {
        
  //      this.refreshDeletingDeliveredTasks(time);

        ArrayList<Task> returningArray = new ArrayList();

        Task T;
        for (int k = 0; k < this.taskList.size(); k++) {

            T = taskList.get(k);

            if (T.getArrivalTime() == time) {
                returningArray.add(T);

            }

        }

        return returningArray;
    }

    public void refreshDeletingDeliveredTasks(int time) {
        Task T;
        for (int k = 0; k < this.taskList.size(); k++) {

            T = taskList.get(k);


            if (T.getArrivalTime() < time) {
                this.taskList.remove(T);
                k = 0;

            }

        }
     
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
