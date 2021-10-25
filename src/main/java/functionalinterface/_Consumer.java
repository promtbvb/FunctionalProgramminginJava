package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    ", thx for reg phone number "
                    + customer.customerPhoneNumber);
    static BiConsumer<Customer, Boolean> greetCustomerConsumerBi = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thx for reg phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "***"));

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "999");
        //Normal java function
        greetCustomer(maria);
        //Consumer Functional interface
        greetCustomerConsumer.accept(maria);
        //Consumer Functional interface
        greetCustomerConsumerBi.accept(maria, false);

    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thx for reg phone number "
                + customer.customerPhoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
