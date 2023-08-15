package TodoListApplication.Operations;


//Defining abstract class and its methods

public abstract class Operations {

    public static final int addTask = 1;
    public static final int editTask = 2;
    public static final int removeTask = 3;
    public static final int displayTask = 4;
    public static final int completedTask = 5;
    public static final int sortTask = 6;
    public static final int exitAll = 7;
    
    public abstract void showTaskInformation();
    
    public abstract String readTaskDetails();
    
    public abstract void executeTask(String entry);


}
