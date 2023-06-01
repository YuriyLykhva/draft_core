package core.model;

import lombok.Data;

import java.util.ResourceBundle;

import static core.util.EncoderDecoder.getDecodedValue;
import static core.util.EncoderDecoder.getEncodedValue;

@Data
public class User {
    private String login;
    private String password;
    private String token;
    private String role;
    private String userProject;

    public static User createUser() {
        return new User(
                getTestData("login"),
                getTestData("password"),
                getTestData("token"),
                getTestData("role"),
                getTestData("userProject"));
    }

    private static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle("admin");
//            ResourceBundle.getBundle("user");

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }

    private User(String login, String password, String token, String role, String userProject) {
        this.login = getEncodedValue(login);
        this.password = getEncodedValue(password);
        this.token = getEncodedValue(token);
        this.role = getEncodedValue(role);
        this.userProject = getEncodedValue(userProject);
    }

    public String getLogin() {
        return getDecodedValue(login);
    }
    public String getPassword() {
        return getDecodedValue(password);
    }
    public String getToken() {
        return getDecodedValue(token);
    }
    public String getRole() {
        return getDecodedValue(role);
    }
    public String getUserProject() {
        return getDecodedValue(userProject);
    }
}
