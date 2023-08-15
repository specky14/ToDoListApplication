package TodoListApplication.Date;

import TodoListApplication.Entity.*;
import TodoListApplication.Operations.Operations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

//Date Sorting of the Task
public class DateSorting extends Operations {

    @Override
    public void showTaskInformation() {
        throw new UnsupportedOperationException("Sample Method Implementation");
    }

    @Override
    public String readTaskDetails() {
        throw new UnsupportedOperationException("Samle Method Implementation");
    }

    @Override
    public void executeTask(String entry) {
        List<Map.Entry<String, TaskEntry>> entries = new ArrayList<>(TodoListDao.tasks.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, TaskEntry>>() {
            @Override
            public int compare(Map.Entry<String, TaskEntry> task1, Map.Entry<String, TaskEntry> task2) {
                LocalDate dueDateFirstTask = task1.getValue().getDueDate();
                LocalDate dueDateSecondTask = task2.getValue().getDueDate();
                int result = dueDateFirstTask.compareTo(dueDateSecondTask);
                return result;
            }

        });

        TodoListDao.tasks.clear();
        entries.forEach((a) -> {
            TodoListDao.tasks.put(a.getKey(), a.getValue());
        });

        System.out.println("Tasks successfully Sorted!");

    }


    public static boolean isDateValid(String format, String value) {
        DateTimeFormatter formattings = DateTimeFormatter.ofPattern(format);
        try {
            LocalDate localDate = LocalDate.parse(value, formattings);

            String result = localDate.format(formattings);

            return result.equals(value);
        } catch (DateTimeParseException err) {

        }
        return false;
    }

    public static String convertDateToString(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String result = null;
        try {
            result = date.format(formatter);

        } catch (DateTimeParseException e) {

        }
        return result;
    }

    /**
     * parseDate parses a string representation of the given date
     *
     *
     * @param format date format pattern
     * @param value  value that equals the component in the task format
     * @return localDate  parsed of the given String date
     */
    public static LocalDate parseDate(String format, String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.parse(value, formatter);
        return localDate;
    }
}
