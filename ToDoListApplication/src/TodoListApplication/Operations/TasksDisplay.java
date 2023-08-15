package TodoListApplication.Operations;

import TodoListApplication.Date.*;
import TodoListApplication.Entity.*;

public class TasksDisplay extends Operations {
    
    @Override
    public void showTaskInformation() {
        System.out.println("");
        System.out.println("List of Tasks: ");
    }

    @Override
    public String readTaskDetails() {
        throw new UnsupportedOperationException("Sample method Implementation");
    }

    @Override
    public void executeTask(String entry) {
        TodoListDao.tasks.forEach((key, task) -> {
            System.out.println("ID: " + key + ", Title: " + task.getTitle() + ", Due Date: "
                    + DateSorting.convertDateToString(task.getDueDate(), "dd-MM-yyyy") + ", Status: "
                    + task.getStatus());
        });

    }
}
