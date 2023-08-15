package TodoListApplication.Entity;

import TodoListApplication.Date.*;
import TodoListApplication.Operations.*;

import java.util.*;

public class TodoListDao {

    public static Map<String, TaskEntry> tasks = new LinkedHashMap<>();
    public static boolean ToDoListRunning = true;
    
    //Start Function
    public void start() {
    	System.out.println("To DO List Application");
        System.out.println("-----------------------");
        
        while (TodoListDao.ToDoListRunning) {
            showAvailableoperations();
            int operationNumber = readoperation();
            executeTask(operationNumber);

        }
    }

    //Executing the operations
    public void executeTask(int operationNumber) {
        Operations operation;
        switch (operationNumber) {
            case Operations.addTask:
                operation = new AddTask();
                operation.showTaskInformation();
                String command = operation.readTaskDetails();
                if (!command.equals("0"))
                    operation.executeTask(command);
                break;
                
            case Operations.editTask:
                if (tasks.size() > 0) {
                    operation = new EditTask();
                    operation.showTaskInformation();
                    String editCommand = operation.readTaskDetails();
                    if (!editCommand.equals(0))
                        operation.executeTask(editCommand);
                } else {
                    System.out.println("list is empty");
                }
                break;
            
            case Operations.removeTask:
                if (tasks.size() > 0) {
                    operation = new RemoveTask();
                    operation.showTaskInformation();
                    String id = operation.readTaskDetails();
                    if (!id.equals("0"))
                        operation.executeTask(id);
                } else {
                    System.out.println("list is empty");
                }
                break;

            
            case Operations.completedTask:
                if (tasks.size() > 0) {
                    operation = new CompletedTask();
                    operation.showTaskInformation();
                    String id = operation.readTaskDetails();
                    if (!id.equals("0"))
                        operation.executeTask(id);

                } else {
                    System.out.println("List is empty");

                }
                break;

            

            case Operations.displayTask:
                if (tasks.size() > 0) {
                    operation = new TasksDisplay();
                    operation.showTaskInformation();
                    operation.executeTask(null);
                } else {
                    System.out.println("list is empty");
                }
                break;

            case Operations.sortTask:
                operation = new DateSorting();
                operation.executeTask(null);
                break;

            case Operations.exitAll:
            	System.out.println("Thank you for using ToDo Application :)");
                ToDoListRunning = false;
                break;


        }
    }
    
    public void showAvailableoperations() {
        System.out.println("");
        System.out.println("1. Add task");
        System.out.println("2. Edit task");
        System.out.println("3. Remove task ");
        System.out.println("4. Display all task");
        System.out.println("5. Complete Task");
        System.out.println("6. Sort task");
        System.out.println("7. Exit");
        System.out.println("");
    }
    
    //Reading the input from user:
    public int readoperation() {
        List<Integer> availableoperations = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        while (true) {
            try {
                System.out.print("Enter operation: ");
                Scanner scan = new Scanner(System.in);
                int operation = scan.nextInt();
                if (availableoperations.contains(operation)) {
                    return operation;
                } else {
                    System.out.println("Please enter a valid option from the list");
                }
            } catch (Exception e) {
                System.out.println("Option must be a number");

            }
        }
    }
}
