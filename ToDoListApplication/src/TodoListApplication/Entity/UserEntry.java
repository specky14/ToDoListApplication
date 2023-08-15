package TodoListApplication.Entity;

public class UserEntry {
	private String username;
    private String password;
    
    public UserEntry(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
