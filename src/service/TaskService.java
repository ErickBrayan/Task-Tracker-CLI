package service;

import model.Task;

import java.util.List;

public interface TaskService {

    String addTask(Task task);
    String updateTask(Task task);
    String deleteTask(int id);
    String markInProgress(int id);
    String markDone(int id);
    List<Task> listByStatus(String status);



}
