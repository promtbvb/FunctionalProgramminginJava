package optionals;

import java.util.Optional;

public class main {
    public static void main(String[] args) {
        Optional.ofNullable("null")
                .ifPresentOrElse(
                        email -> System.out.println("sad" + email),
                        () -> {
                            System.out.println("Cannot send");
                        });
    }
}
