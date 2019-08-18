package ru.users;

public class User implements Comparable<User> {
    public User(String name, String password) {
        this.name = name;
        this.password = password;

    }
    @Override
    public int compareTo(User o) {
       return name.compareTo(o.name);
    }

    private String name;
    private String password;

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        User user =(User) obj;
        return (name.equals(user.name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setHashPass(String hashPass) {
        this.password = password;
    }


}
