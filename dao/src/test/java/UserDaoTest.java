import com.task8.dao.impl.UserDao;
import com.task8.model.Role;
import com.task8.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    @Test
    public void login() {
        //public User(String firstName, String lastName, String phone, String email, String login, String password, Role role)
        String testLogin="testLogin";
        String testPassword="testPassword";
        User actualUser = new User(
                "TestUserName",
                "TestUserFirstName",
                "1111111111",
                "test@test.by",
                 testLogin,
                 testPassword,
                 Role.USERS
            );
         UserDao userDao = UserDao.getInstance();
         userDao.insert(actualUser);
         User expectedUser=userDao.login(testLogin,testPassword);
         assertEquals(expectedUser,actualUser);
      }
}
