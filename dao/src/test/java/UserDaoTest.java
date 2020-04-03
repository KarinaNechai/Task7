import com.task8.dao.impl.UserDao;
import com.task8.model.Role;
import com.task8.model.User;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao  userDao=UserDao.getInstance();

    @BeforeClass
    public static void beforeClass() {

    }
    @Test
    public void insertTest() {
        String loginRight = "login_loginInsertR";
        String passwordRight = "PasswordR";
        String loginWrong = "login_loginInsertW";
        String passwordWrong = "PasswordW";
        User userInsert = new User(
                "TestUserName",
                "TestUserFirstName",
                "1111111111",
                "test@test.by",
                loginRight,
                passwordRight,
                Role.USERS
        );

        assertTrue("Insert new user", userDao.insert(userInsert));
        assertFalse("Insert exist user", userDao.insert(userInsert));
        assertFalse("Insert null user", userDao.insert(null));
    }

    @Test
    public void loginTest() {
        String loginRight = "login_loginTestR";
        String passwordRight = "testPassword";
        String loginWrong = "login_loginTestW";
        String passwordWrong = "testPasswordW";
        User userLogin = new User(
                "TestUserName",
                "TestUserFirstName",
                "1111111111",
                "test@test.by",
                loginRight,
                passwordRight,
                Role.USERS
        );
        userDao.insert(userLogin);
        assertEquals(userDao.login(loginRight,passwordRight),userLogin);
        assertNull(userDao.login(loginWrong,passwordRight));
        assertNull(userDao.login(loginRight,passwordWrong));
    }
    @Test
    public void getUserByloginTest() {
        String loginRight = "login_getUserByloginR";
        String passwordRight = "testPassword";
        String loginWrong = "login_getUserByloginW";
        String passwordWrong = "testPasswordW";
        User userBylogin = new User(
                "TestUserName",
                "TestUserFirstName",
                "1111111111",
                "test@test.by",
                loginRight,
                passwordRight,
                Role.USERS
        );
        userDao.insert(userBylogin);
        assertEquals(userDao.getUserBylogin(loginRight),userBylogin);
        assertNull(userDao.getUserBylogin(loginWrong));
        assertNull(userDao.getUserBylogin(null));
    }


    @Test
    public void deleteTest() {
        String loginRight = "login_loginUpdateR";
        String passwordRight = "PasswordR";
        String loginWrong = "login_loginUpdatetW";
        String passwordWrong = "PasswordW";
        User userDelete = new User(
                "TestUserName",
                "TestUserFirstName",
                "1111111111",
                "test@test.by",
                loginRight,
                passwordRight,
                Role.USERS
        );
        userDao.insert(userDelete);

        assertTrue("Delete new user", userDao.delete(loginRight));
        assertFalse("Delete deleted user", userDao.delete(loginRight));
        assertFalse("Delete unexist user", userDao.delete(loginWrong));
        assertFalse("Delete null user", userDao.delete(null));
    }
}
