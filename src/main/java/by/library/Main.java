package by.library;

<<<<<<< HEAD
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
=======
import by.library.user.User;

>>>>>>> d94ff46 (Added user and lombok library. (#1))
public class Main {

    public static void main(String[] args) {

<<<<<<< HEAD
        SpringApplication.run(Main.class, args);

=======
        User user = new User();
        user.setAge(14);

        System.out.println(user.getAge());
>>>>>>> d94ff46 (Added user and lombok library. (#1))
    }
}
