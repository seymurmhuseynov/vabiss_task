package vabiss.task.model;

public class RequestLoginOrRegistry {

    private String username;
    private String password;

    public RequestLoginOrRegistry() {
    }

    public String getUsername() {
        return username;
    }

    public RequestLoginOrRegistry setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RequestLoginOrRegistry setPassword(String password) {
        this.password = password;
        return this;
    }

}
