import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws InputMismatchException, AccessDeniedException, UserNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPassword(login, password);

        validateUser(user);

        System.out.println("Доступ предоставлен");
    }


    public static User[] getUsers() {
        User[] users = new User[]{
                new User(1, "jhon", "pass", "jhon@gmail.com", 24),
                new User(2, "dana", "olc", "dana@yandex.ru", 28),
                new User(3, "dic", "dia", "dic@gmail.com", 49),
                new User(4, "dima", "25try", "dima@gmail.com", 17)
        };

        return users;
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.checkLoginAndPassword(login, password)) return user;
        }
        throw new UserNotFoundException();
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.checkAge(18)) return;

        throw new AccessDeniedException();
    }
}