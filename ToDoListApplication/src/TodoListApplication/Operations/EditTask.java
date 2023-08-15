package TodoListApplication.Operations;

import TodoListApplication.Date.DateSorting;
import TodoListApplication.Entity.TodoListDao;

import java.util.Scanner;

public class EditTask extends Operations {

    @Override
    public void showTaskInformation() {
        System.out.println("");
        System.out.println("Edit your task using Id. Press / incase no edit");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readTaskDetails() {
        while (true) {
            System.out.println("");
            System.out.println("Enter Task Details");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!userInput.equals(0)) {
                String[] parts = userInput.split(",");
                if (parts.length == 4) {
                    boolean dateValidationRequired = true;
                    if (parts[2].equals("/")) {
                        dateValidationRequired = false;
                    }

                    boolean isDateValid = true;
                    if (dateValidationRequired) {
                        isDateValid = DateSorting.isDateValid("dd-mm-yyyy", parts[2]);
                    }

                    if (isDateValid) {
                        if (TodoListDao.tasks.get(parts[0]) != null) {
                            return userInput;
                        } else {
                            System.out.println("ID doesn't exist");
                        }
                    } else {
                        System.out.println("Please enter valid details");
                    }
                } else {
                    return userInput;
                }
            }
        }


    }

    @Override
    public void executeTask(String entry) {

        String[] parts = entry.split(",");

        boolean isTaskEdited = false;
        if (!parts[1].equals("/")) {
            TodoListDao.tasks.get(parts[0]).setTitle(parts[1]);
            isTaskEdited = true;
        }

        if (!parts[2].equals("/")) {
            TodoListDao.tasks.get(parts[0]).setDueDate(DateSorting.parseDate("dd-mm-yyyy", parts[2]));
            isTaskEdited = true;
        }

        if (!parts[3].equals("/")) {
            TodoListDao.tasks.get(parts[0]).setStatus(parts[3]);
            isTaskEdited = true;
        }
        if (isTaskEdited) {
            System.out.println("Tasks has been successfully updated! ");
        } else {
            System.out.println("No update in task was performed");
        }
    }
}
