package gruppe4.aws.models;

public class User {
    private String name;
    private String userName;
    private String password;
    private String email;

    public User(String name, String userName, String password, String email) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
