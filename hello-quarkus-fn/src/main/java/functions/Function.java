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
     * Use the Quarkus Funqy extension for our function. This function simply echoes its input
     * @param input a Java bean
     * @return a Java bean
     * @throws SQLException 
     */
    @Funq
    public Output function(Input input) throws SQLException {

        List<String> results = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT name FROM customer")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    results.add(rs.getString("name"));
                }
            }
        }

        return new Output(results.toString());
    }

}
