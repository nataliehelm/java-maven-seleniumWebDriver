package RestAssured.utils;

public class UserInfo {

    private String username;
    private String password;
    private String customerId;

    public UserInfo() {
        this.username = "testing1";
        this.password = "asd123";
        this.customerId = "16652";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
