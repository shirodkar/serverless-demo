package functions;

import java.util.ArrayList;
import java.util.List;

import io.quarkus.funqy.Funq;

/**
 * Your Function class
 */
public class CustomersFunction {

    /**
     * Use the Quarkus Funqy extension for our function. This function returns a list of customers.
     * @return List of customers
     */
    @Funq
    public List<Customer> getCustomers() {

        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.name = "Customer 1";
        customers.add(customer1);
        Customer customer2 = new Customer();
        customer2.name = "Customer 2";
        customers.add(customer2);

        return customers;
    }

}
