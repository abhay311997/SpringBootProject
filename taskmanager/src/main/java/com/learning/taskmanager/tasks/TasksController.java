package com.learning.taskmanager.tasks;

import com.learning.taskmanager.tasks.dtos.CreateTaskDTO;
import com.learning.taskmanager.tasks.dtos.UpdateTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService tasksService ;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService ;
    }

    @GetMapping("")
    ResponseEntity<List<Task>> getAllTasks(){
        var taskList = tasksService.getAllTasks();
        return ResponseEntity.ok(taskList);
    }

    @GetMapping("/{id}")
    ResponseEntity<Task> getTasksById(@PathVariable("id") Integer id){
        var task = tasksService.getTaskById(id);
        return  ResponseEntity.ok(task);
    }

    @PostMapping("")
    ResponseEntity<Task> createTask(@RequestBody CreateTaskDTO createTaskDTO){
        var task = tasksService.createTask(createTaskDTO.getName(),createTaskDTO.getDueDate());
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}")
    ResponseEntity<Task> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO updateTaskDTO){
        var task = tasksService.updateTask(id, updateTaskDTO.getDueDate(), updateTaskDTO.getCompleted());
        return  ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    void deleteTask(@PathVariable("id") Integer id){
       tasksService.deleteTask(id);
    }

    @ExceptionHandler(TasksService.TaskNotFoundException.class)
    ResponseEntity<String> handleTaskNotFoundException(TasksService.TaskNotFoundException e){
        return ResponseEntity.notFound().build();
    }

}
