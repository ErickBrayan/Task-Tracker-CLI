package service;

import model.Status;
import model.Task;
import util.FileJsonUtil;

import java.util.List;
import java.util.function.Predicate;

public class TaskServiceImpl implements TaskService {

    List<Task> tasks;
    private static TaskService instance;


    private TaskServiceImpl() {
        tasks = FileJsonUtil.load();
    }

    public static TaskService getInstance() {
        if (instance == null) {
            instance = new TaskServiceImpl();
        }
        return instance;
    }


    @Override
    public String addTask(Task task) {
        tasks.add(task);
        FileJsonUtil.save(tasks);
        return "Task added successfully (ID: "+ task.getId() +")";
    }

    @Override
    public String updateTask(Task task) {

        tasks.stream()
                .filter(getId(task.getId()))
                .findFirst()
                .ifPresent(task1 -> task1.setDescription(task.getDescription()));
        FileJsonUtil.save(tasks);
        return "Task updated successfully (ID: "+ task.getId() +")";

    }

    @Override
    public String deleteTask(int id) {
        tasks.stream()
                .filter(getId(id))
                .findFirst()
                .ifPresent(task1 -> tasks.remove(task1));
        FileJsonUtil.save(tasks);
        return "Task deleted successfully (ID: "+ id +")";
    }

    @Override
    public String markInProgress(int id) {
        tasks.stream()
                .filter(getId(id))
                .findFirst()
                .ifPresent(task1 -> task1.setStatus(Status.IN_PROGRESS));
        FileJsonUtil.save(tasks);
        return "Task status was changed successfully";
    }

    @Override
    public String markDone(int id) {
        tasks.stream()
                .filter(getId(id))
                .findFirst()
                .ifPresent(task1 -> task1.setStatus(Status.DONE));
        FileJsonUtil.save(tasks);
        return "Task status was changed successfully";
    }

    @Override
    public List<Task> listByStatus(String status) {
        if (status.equalsIgnoreCase("in-progress")){
            return tasks.stream()
                    .filter(t -> t.getStatus() == Status.IN_PROGRESS)
                    .toList();
        } else if (status.equalsIgnoreCase("done")) {
            return tasks.stream()
                    .filter(t -> t.getStatus() == Status.DONE)
                    .toList();
        } else if (status.equalsIgnoreCase("todo")) {
            return tasks.stream()
                    .filter(t -> t.getStatus() == Status.TODO)
                    .toList();
        } else {
            return tasks;
        }
    }

    private Predicate<Task> getId(int id) {
        return task -> task.getId() == id;
    }
}
