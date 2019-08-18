import org.junit.Test;
import ru.repositories.PasswordHashing;
import ru.repositories.PasswordHashingImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordHashinTest {
    String pass = "hello123A@$%";
    @Test
    public void twoEqualPassShouldReturnTrue(){
        String hashPass = PasswordHashingImpl.getPasswordHashing.createHashFromPass(pass);
        System.out.println(hashPass);
        String hashPass2 = PasswordHashingImpl.getPasswordHashing.createHashFromPass(pass);
        System.out.println(hashPass2);
        assertTrue(PasswordHashingImpl.getPasswordHashing.checkPassHash("a5a884ec5","$2a$10$7lO4GxPXt8fmVvndrCAdSe9C2zsorr726oLAHJWxHzsRu4PHNK7P6"));
        assertFalse(PasswordHashingImpl.getPasswordHashing.checkPassHash("a5a884ec5","$2a$10$7lO4GxPXt8fmVvndrCAdSe9C2zsorr726oLAHJWxHzsRu4PHNK7P64"));
        assertTrue(PasswordHashingImpl.getPasswordHashing.checkPassHash(pass,hashPass2));
    }
}
