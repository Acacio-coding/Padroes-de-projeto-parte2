package patterns.flyweight;

public class ConnectionFactory {
    private static String login;
    private static String password;

    private static void init() {
        login = "admin";
        password = "admin";
    }

    public static Boolean getConnection() {
        init();
        return login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin");
    }
}
