package TodoListApplication.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import TodoListApplication.Entity.*;

public class Main {
	
	//register and login 
	private static Map<String, UserEntry> users = new HashMap<>();
    private static UserEntry currentUser = null;
    public static void main(String[] args) {

    	while(true) {
    		Scanner scanner = new Scanner(System.in);
    		System.out.println("Welcome to the ToDo App!");

            if (currentUser == null) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        registerUser(scanner);
                        break;
                    case 2:
                        loginUser(scanner);
                        break;
                    case 3:
                        System.out.println("Bye bye !");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
            else {
                System.out.println("Hello, " + currentUser.getUsername() + "!");
            	TodoListDao toDoList = new TodoListDao();
            	toDoList.start();
            	break;
            	}
            }
    	}
    
    //register user
    private static void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
        } else {
            users.put(username, new UserEntry(username, password));
            System.out.println("User registered successfully.");
            System.out.println();
         
        }
    }
    
    //login user
    private static void loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username)) {
            UserEntry user = users.get(username);
            if (user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful.");
                System.out.println();
            } else {
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("Username not found.");
        }
    }

}
