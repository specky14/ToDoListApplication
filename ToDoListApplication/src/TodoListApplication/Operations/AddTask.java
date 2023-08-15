package TodoListApplication.Operations;

import TodoListApplication.Date.*;
import TodoListApplication.Entity.*;

import java.util.Scanner;

 
public class AddTask extends Operations {

    @Override
    public void showTaskInformation() {
        System.out.println("");
        System.out.println("Add new tasks");
        System.out.println("");
        System.out.println("Enter 0 to Main Menu");
    }

    @Override
    public String readTaskDetails() {
        while (true) {
            System.out.println("");
            System.out.print("Enter Task Details: ");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!userInput.equals("0")) {
                String[] parts = userInput.split(",");
                if (parts.length == 4) {
                    if (DateSorting.isDateValid("dd-MM-yyyy", parts[2])) {
                        if (TodoListDao.tasks.get(parts[0]) == null) {
                            return userInput;
                        } else {
                            System.out.println("A task with this ID already exists");
                        }
                    } else {
                        System.out.println("The date entered is invalid");
                    }
                } else {
                    System.out.println("Please enter valid details");
                }
            } else {
                return userInput;
            }
        }
    }

    @Override
    public void executeTask(String entry) {
        String[] parts = entry.split(",");
        TaskEntry task = TaskEntry.buildTask(parts[0], parts[1], DateSorting.parseDate("dd-MM-yyyy", parts[2]),
                parts[3]);

        TodoListDao.tasks.put(task.getId(), task);
        System.out.println("Your task has been successfully added!");

    }
}
