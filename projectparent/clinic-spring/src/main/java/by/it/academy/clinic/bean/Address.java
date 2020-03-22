package by.it.academy.clinic.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component("address")
public class Address implements IAddress {
    @Value("1")
    private Long Id;
    @Value("Belarus")
    private String country;
    @Value("Minsk")
    private String city;
    @Value("Golodeda")
    private String street;


}
