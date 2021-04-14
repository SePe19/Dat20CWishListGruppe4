package gruppe4.aws.models;



import java.util.concurrent.TimeUnit;

public class User {
    private String accountName;
    private String name;
    private String email;


    public User(String accountName, String name, String email) {
        this.accountName = accountName;
        this.name = name;
        this.email = email;
    }

    public String getAccountName() { return accountName; }

    public void setAccountName() { this.accountName = accountName; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "accountName='" + accountName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
