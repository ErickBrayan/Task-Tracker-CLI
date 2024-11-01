import commandHandler.TaskCommandHandler;

import model.Task;
import service.TaskService;
import service.TaskServiceImpl;

import java.util.List;

public class taskcli {

    public static void main(String[] args) {

        TaskService taskService = TaskServiceImpl.getInstance();
        TaskCommandHandler taskCommandHandler = new TaskCommandHandler(taskService);

        try {
            switch (args[0]) {
                case "add":
                    if (args.length < 2) {
                        System.out.println("Usage: taskcli add <description>");
                    }
                    String msg = taskCommandHandler.addTask(new Task(args[1]));
                    System.out.println(msg);
                    break;
                case "update":
                    if (args.length < 3) {
                        System.out.println("Usage: taskcli update <id> <new description>");
                    }
                    msg = taskCommandHandler.updateTask(new Task(Integer.parseInt(args[1]),args[2]));
                    System.out.println(msg);
                    break;
                case "delete":
                    if (args.length < 2) {
                        System.out.println("Usage: taskcli delete <id>");
                    }
                    msg = taskCommandHandler.deleteTask(Integer.parseInt(args[1]));
                    System.out.println(msg);
                    break;
                case "mark-in-progress":
                    if (args.length < 2) {
                        System.out.println("Usage: taskcli mark-in-progress <id>");
                    }
                    msg = taskCommandHandler.markInProgress(Integer.parseInt(args[1]));
                    System.out.println(msg);
                    break;
                case "mark-done":
                    if (args.length < 2) {
                        System.out.println("Usage: taskcli mark-done <id>");
                    }
                    msg = taskCommandHandler.markDone(Integer.parseInt(args[1]));
                    System.out.println(msg);
                    break;
                case "list":
                    if (args.length < 2) {
                        List<Task> tasks = taskCommandHandler.listByStatus("all");
                        header();
                        tasks.forEach(System.out::println);
                    }else {
                        String status = "";
                        try {
                            status = args[1];
                        }catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        List<Task> tasks = taskService.listByStatus(status);
                        header();
                        tasks.forEach(System.out::println);
                    }
                    break;
                case "help":
                    help();
                    break;
                default:
                    System.out.println("Unknown command  " + args[0]);
                    break;
            }
        } catch (Exception e) {
            System.out.println(" ");
        }
    }

    private static void header() {
        System.out.println("            Task Tracker");
        System.out.println("=====================================");
    }

    private static void help() {
        System.out.println("help");
        System.out.println("My Commands:");
        System.out.println("              Command                     |         Description              ");
        System.out.println("    taskcli add <description>             : Adding a new Task ");
        System.out.println("    taskcli update <id> <new description> : Updating Task");
        System.out.println("    taskcli delete <id>                   : Deleting Task");
        System.out.println("    taskcli mark-in-progress <id>         : Marking a task in progress");
        System.out.println("    taskcli mark-done <id>                : Marking a task in done");
        System.out.println("    taskcli list                          : listing all Tasks");
        System.out.println("    taskcli list done                     : listing task by status (done - todo - in-progress)");
    }
}