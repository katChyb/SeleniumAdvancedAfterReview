package providers;

import com.github.javafaker.Faker;
import configuration.models.User;

import java.text.SimpleDateFormat;

public class UserFactory {
    static Faker faker = new Faker();

    public static User createRandomUser() {
        return new User(faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.internet().password(),
                faker.date().birthday());
    }
}
