import org.junit.Test;
import ru.repositories.WorkWithUserBase;
import ru.repositories.WorkWithUserBaseImpl;
import ru.users.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    @Test
    public void loginWithRightPassShouldReturnTrue(){
        User user = new User("koliannn","a5a884ec5");
        User user1 = new User("koliannn","sdasddf");
        WorkWithUserBase workWithUserBase = WorkWithUserBaseImpl.storage;
        assertTrue(workWithUserBase.checkUserNameAndPassword(user));
        assertFalse(workWithUserBase.checkUserNameAndPassword(user1));

    }
}
