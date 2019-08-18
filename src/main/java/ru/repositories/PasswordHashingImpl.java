package ru.repositories;


import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHashingImpl implements PasswordHashing {
    //singleton
    public static final PasswordHashingImpl getPasswordHashing;

    String strong_salt = BCrypt.gensalt(10);

    static {
        getPasswordHashing = new PasswordHashingImpl();
    }
    private PasswordHashingImpl(){}



//проверяем пароли
    @Override
    public boolean checkPassHash(String pass, String ourHash) {
        return BCrypt.checkpw(pass,ourHash);
    }


//создаем пароли
    @Override
    public String createHashFromPass(String pass) {
       return BCrypt.hashpw(pass,strong_salt);
    }
}
