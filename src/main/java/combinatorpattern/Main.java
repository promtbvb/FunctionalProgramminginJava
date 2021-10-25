package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice",
                "email@email.com",
                "+0",
                LocalDate.of(2000, 1, 1));

//        System.out.println(new CustomerValidatorService().isValid(customer));
        //Using combinator pattern
        ValidationResult result = isEMailValid().and(isPhoneNUmerValid())
                .and(isAdult())
                .apply(customer);
        System.out.println(result);
        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
