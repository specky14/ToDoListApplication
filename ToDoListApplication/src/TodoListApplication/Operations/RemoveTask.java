package TodoListApplication.Operations;

import java.util.Scanner;

import TodoListApplication.Entity.*;


public class RemoveTask extends Operations {
   
    @Override
    public void showTaskInformation() {
        System.out.println("");
        System.out.println("Remove a Task");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }
    
    @Override
    public String readTaskDetails() {

        while (true) {
            System.out.println("");
            System.out.print("Enter Task ID: ");
            Scanner in = new Scanner(System.in);
            try {
                String userInput = in.nextLine();
                int userInputAsNum = Integer.parseInt(userInput);
                if (userInputAsNum != 0) {
                    TaskEntry task = TodoListDao.tasks.get(userInput);
                    if (task != null) {
                        return userInput;
                    } else {
                        System.out.println("ID doesn't exist");
                    }
                } else {
                    return userInput;
                }

            } catch (Exception err) {
                System.out.println("Please enter valid Task Details");
            }

        }

    }


    @Override
    public void executeTask(String command) {
        TodoListDao.tasks.remove(command);

        System.out.println("Task id: " + command + ", was successfully removed...");

    }
}
