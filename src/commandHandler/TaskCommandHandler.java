package commandHandler;

import model.Task;
import service.TaskService;

import java.util.List;

public class TaskCommandHandler {

    TaskService taskService;

    public TaskCommandHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    public String addTask(Task task) {
        return taskService.addTask(task);
    }

    public String updateTask(Task task) {
        return taskService.updateTask(task);
    }

    public String deleteTask(int id) {
        return taskService.deleteTask(id);
    }

    public String markInProgress(int id) {
        return taskService.markInProgress(id);
    }


    public String markDone(int id) {
        return taskService.markDone(id);
    }

    public List<Task> listByStatus(String status) {
        return taskService.listByStatus(status);
    }
}
