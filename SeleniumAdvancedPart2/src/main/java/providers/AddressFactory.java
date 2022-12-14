package providers;

import com.github.javafaker.Faker;
import configuration.models.AddressForTest;

import java.util.Locale;

public class AddressFactory {

    public static AddressForTest newAddress(){
        Faker faker = new Faker(new Locale("pl_PL"));
        return AddressForTest.builder().address(faker.address().streetAddress())
                .zipCode(faker.address().zipCode())
                .city(faker.address().city())
                .build();

    }
}
