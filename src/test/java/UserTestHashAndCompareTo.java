import org.junit.Test;
import ru.users.User;

public class UserTestHashAndCompareTo {

    @Test
    public void UserShouldCompare(){
        User user = new User("hello","123");
        User user1 = new User("hello1","");
        User user2 = new User("hello2","");
        User user3 = new User("hello","");
        System.out.println(user.toString());
        System.out.println(user1.toString());
        System.out.println(user.compareTo(user1));

    }
}
