package TodoListApplication.Entity;

import java.time.LocalDate;

import TodoListApplication.Date.*;

public class TaskEntry {

    private String id;
    private String title;
    private LocalDate dueDate;
    private String status;
    
    public String getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }


    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static TaskEntry buildTask(String id, String title, LocalDate dueDate, String status) {
        TaskEntry task = new TaskEntry();

        task.setId(id);
        task.setTitle(title);
        task.setDueDate(dueDate);
        task.setStatus(status);
        return task;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + DateSorting.convertDateToString(dueDate, "dd-MM-yyyy") + "," + status;
    }

}
