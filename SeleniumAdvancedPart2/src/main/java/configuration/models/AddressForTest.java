package configuration.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressForTest {
    private String address;
    private String zipCode;
    private String city;

    public void AddressForTest(String address, String zipCode, String city) {
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
    }
}

