package providers;

import com.github.javafaker.Faker;
import configuration.models.User;

import java.text.SimpleDateFormat;

public class UserFactory {
   private static Faker faker = new Faker();

    public static User createRandomUser() {
        return User.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .birthdate(String.valueOf(faker.date().birthday()))
                .build();
    }

    public static User getAlreadyRegisterUser(){
        return User.builder()
                .email(System.getProperty("email"))
                .password(System.getProperty("password"))
                .build();
    }
}
