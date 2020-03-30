package by.it.academy.clinic.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component("companyAddress")
public class CompanyAddress implements IAddress {
    @Value("77")
    private Long Id;
    @Value("company address")
    private String companyAddress;
}
