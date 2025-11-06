package Serialization;

import java.io.Serializable;

public class UserProfile implements Serializable {

    // username and age saved
    String username;
    int age;
    // transient explicitly tells java not to serialize
    transient String sessionToken;
    // static variables are attached to class not object and are not serialized
    static String appVersion = "1.0";

    public UserProfile(String username, int age, String sessionToken) {
        this.username = username;
        this.age = age;
        this.sessionToken = sessionToken;
    }

    @Override
    public String toString() {
        return String.format(
                "UserProfile(username='%s', age=%d, sessionToken=%s, appVersion=%s)",
                this.username,
                this.age,
                this.sessionToken,
                appVersion
        );
    }
}
