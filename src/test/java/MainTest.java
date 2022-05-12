import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testCorrectLogin() throws UserNotFoundException {
        String login = "jhon", password = "pass";

        User user = Main.getUserByLoginAndPassword(login, password);
        int userId = user.getId();

        assertEquals(1, userId);
    }

    @Test
    public void testLoginUserNotFoundException() {
        String login = "ivan", password= "ivan99";

        Class<UserNotFoundException> expected = UserNotFoundException.class;

        assertThrows(expected,
                () -> Main.getUserByLoginAndPassword(login, password));
    }

    @Test
    public void testValidateUserAccessDeniedException() {
        User user = new User(0, "test", "test", "test", 15);

        Class<AccessDeniedException> expected = AccessDeniedException.class;

        assertThrows(expected,
                () -> Main.validateUser(user));
    }

    @Test
    public void testCorrectValidateUser() throws AccessDeniedException {
        User user = new User(0, "test", "test", "test", 19);

        Main.validateUser(user);
    }
}
