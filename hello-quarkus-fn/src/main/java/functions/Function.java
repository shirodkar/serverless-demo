package functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import io.quarkus.funqy.Funq;
import jakarta.inject.Inject;

/**
 * Your Function class
 */
public class Function {

    @Inject
    DataSource dataSource;

    /**
     * Use the Quarkus Funqy extension for our function. This function provides names of customers in the database.
     * @param input a Java bean
     * @return a Java bean
     * @throws SQLException 
     */
    @Funq
    public Output function(Input input) throws SQLException {

        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.name = "Customer 1";
        customers.add(customer1);
        Customer customer2 = new Customer();
        customer2.name = "Customer 2";
        customers.add(customer2);

        return new Output(customers.toString());
    }

}
