package TodoListApplication.Operations;

import java.util.Scanner;

import TodoListApplication.Entity.TaskEntry;
import TodoListApplication.Entity.TodoListDao;


public class CompletedTask extends Operations {

    @Override
    public void showTaskInformation() {
        System.out.println("");
        System.out.println("Complete your task");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readTaskDetails() {
        while (true) {
            System.out.println("");
            System.out.print("Enter task id:");
            Scanner in = new Scanner(System.in);
            try {
                String userInput = in.nextLine();
                int userInputAsNum = Integer.parseInt(userInput);
                if (userInputAsNum != 0) {
                    TaskEntry task = TodoListDao.tasks.get(userInput);
                    if (task != null) {
                        return userInput;
                    } else {
                        System.out.println("There is no task with this ID, try again: ");
                    }
                } else {
                    return userInput;
                }
            } catch (Exception err) {
                System.out.println("Please enter valid task details");
            }
        }
    }

    @Override
    public void executeTask(String entry) {
        TodoListDao.tasks.get(entry).setStatus("Completed");
        System.out.println("Status of task has been set as Completed of Task id: " + entry);

    }
}
