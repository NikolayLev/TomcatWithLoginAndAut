import org.junit.Test;
import ru.repositories.PasswordHashingImpl;
import ru.repositories.WorkWithUserBase;
import ru.repositories.WorkWithUserBaseImpl;
import ru.users.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WorkWithUserBaseTest {

    @Test
    public void weShouldAddOnlyUnicalUser(){
        User user = new User("hello","123");
        User user1 = new User("hello1","");
        User user2 = new User("hello2","");
        User user3 = new User("hello","");
        Set<User> set = new HashSet<>();
        set.add(user);
        set.add(user1);
        set.add(user2);
        System.out.println(set.add(user3));
        Iterator<User> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("pass =" +  iterator.next().getPassword());
        }
        WorkWithUserBaseImpl.storage.addNewUser(user1);




    }
}
