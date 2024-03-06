package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import exercise.model.Task;
import exercise.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping(path = "")
    public List<Task> index() {
        return taskRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Task show(@PathVariable long id) {

        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));

        return task;
    }

    // BEGIN

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task task) {
        taskRepository.save(task);
        return task;
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable long id, @RequestBody Task task) {
        var taskFromDb = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        taskFromDb.setTitle(task.getTitle());
        taskFromDb.setDescription(task.getDescription());
        taskRepository.save(taskFromDb);
        return taskFromDb;
    }
    // END

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        taskRepository.deleteById(id);
    }
}
