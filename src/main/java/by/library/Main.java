package by.library;

import by.library.user.User;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        user.setAge(14);

        System.out.println(user.getAge());
    }
}
