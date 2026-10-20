package com.learning.taskmanager.tasks;


import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TasksService {
    private List<Task> tasksList  = new ArrayList<>();
    private Integer id = 1;

    public List<Task> getAllTasks(){
        return tasksList;
    }

    public Task getTaskById(Integer id){
        for(Task t:tasksList){
            if(t.getId().equals(id))
                    return t;
        }
        throw new TaskNotFoundException(id);
    }

    public Task createTask(String name, Date dueDate){
        Task t = new Task(id++, name, dueDate, false);
        tasksList.add(t);
        return t;
    }

    public Task updateTask(Integer id, Date dueDate, Boolean completed){
        Task t = getTaskById(id);
        if(dueDate != null) {
            t.setDueDate(dueDate);
        }
        if(completed != null) {
            t.setCompleted(completed);
        }

        return t ;
    }

    public void deleteTask(Integer id){
        Task t = getTaskById(id);
        tasksList.remove(t);
    }

    public static class TaskNotFoundException extends IllegalStateException {
        public TaskNotFoundException(Integer id){
            super("Task with id: " + id + " Not Found");
        }
    }
}
