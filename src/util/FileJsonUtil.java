package util;

import model.Task;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileJsonUtil {

    private static final String FILE_NAME = "task.json";
    private static final Path FILE_PATH = Path.of(FILE_NAME);

    public static void save(List<Task> tasks) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < tasks.size(); i++){
            sb.append(tasks.get(i).toJson());
            if (i < tasks.size() - 1){
                sb.append(",\n");
            }
        }
        sb.append("\n]");

        String jsonContent = sb.toString();

        try {
            Files.writeString(FILE_PATH, jsonContent);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Task> load() {
        List<Task> stored_tasks = new ArrayList<>();

        if (!Files.exists(FILE_PATH)){
            return new ArrayList<>();
        }

        try {
            String jsonContent = Files.readString(FILE_PATH);
            String[] taskList = jsonContent.replace("[", "")
                    .replace("]", "")
                    .split("},");
            for (String taskJson : taskList){
                if (!taskJson.endsWith("}")){
                    taskJson = taskJson + "}";
                    stored_tasks.add(Task.fromJson(taskJson));
                } else {
                    stored_tasks.add(Task.fromJson(taskJson));
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return stored_tasks;
    }
}
