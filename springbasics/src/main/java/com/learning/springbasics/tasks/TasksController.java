package com.learning.springbasics.tasks;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    List<Task> taskList = new ArrayList<>();
    private int nextTaskId = 1;

    // Get all tasks
    // -> GET /tasks/
    @GetMapping("/")
     List<Task> getAllTasks() {
        return taskList;
    }

    // Create a new tasks with String name, boolean completed, Date dueDate
    // -> POST /tasks/ {with body}
    @PostMapping("/")
    Task CreateTask(@RequestBody Task task) {
        task.setId(nextTaskId++);
        taskList.add(task);
        return task;
    }

    // Get tasks by id
    // -> GET /tasks/{id}
    @GetMapping("/{id}")
    Task getTaskById(@PathVariable("id") Integer id) {
        var foundTask = taskList.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
        return foundTask ;
    }

}
