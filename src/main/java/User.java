public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int age;

    public User(int id, String login, String password, String email, int age) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public boolean checkLoginAndPassword(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }

    public boolean checkAge(int age) {
        return this.age >= age;
    }

    public int getId() {
        return id;
    }
}
