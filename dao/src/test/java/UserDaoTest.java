import com.task8.dao.impl.UserDao;
import com.task8.model.Role;
import com.task8.model.User;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserDaoTest {
    @Test
    public void loginTest() {
        String testLoginRight="testLogin";
        String testLoginWrong="testLoginW";
        String testPasswordRight="testPassword";
        String testPasswordWrong="testPasswordW";
        User actualUser = new User(
                "TestUserName",
                "TestUserFirstName",
                "1111111111",
                "test@test.by",
                testLoginRight,
                testPasswordRight,
        Role.USERS
        );
        UserDao  userDao=UserDao.getInstance();
        userDao.insert(actualUser);
        assertEquals(userDao.login(testLoginRight,testPasswordRight),actualUser);
        assertNull(userDao.login(testLoginWrong,testPasswordRight));
        assertNull(userDao.login(testLoginRight,testPasswordWrong));
    }
   @Test
    public void insertInsert() {
        String testLoginRight="testLogin";
        String testPasswordRight="testPassword";
        User testUser = new User(
                "TestUserName",
                "TestUserFirstName",
                "1111111111",
                "test@test.by",
                testLoginRight,
                testPasswordRight,
                Role.USERS
        );
        UserDao  userDao=UserDao.getInstance();
     //   assertEquals("Insert new user",userDao.insert(testUser),true);
        assertEquals("Insert exist user",userDao.insert(testUser),false);
 //       assertEquals("Insert null user",null,false);

    }
    @Test
    public void updateTest() {
        String testLoginRight="testLogin";
        String testLoginWrong="testLoginW";
        String testPasswordRight="testPassword";
        String testPasswordWrong="testPasswordW";
        User testUser = new User(
                "TestUserName",
                "TestUserFirstName",
                "1111111111",
                "test@test.by",
                testLoginRight,
                testPasswordRight,
                Role.USERS
        );
        UserDao  userDao=UserDao.getInstance();
        userDao.insert(testUser);
     //   assertEquals("Insert new user",userDao.insert(testUser),true);
        assertEquals("Insert exist user",userDao.insert(testUser),false);
   //     assertEquals("Insert null user",null,false);

    }
}
