package repository;

import connection.JdbcConnection;
import model.User;
import model.UserAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public UserRepository() throws SQLException {
    }

    public int saveUser(User user) throws SQLException {
        String addUser = "INSERT INTO users(lastname,firstName,officeCode,addressId)values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);
        preparedStatement.setString(1, user.getLastName());
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setInt(3, user.getOfficeCode());
        preparedStatement.setInt(4, user.getAddressId());
        return preparedStatement.executeUpdate();
    }

    public int saveUserAddress(UserAddress userAddress) throws SQLException {
        String addUserAddress = "INSERT INTO userAddress (city,street,postalCode) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addUserAddress);
        preparedStatement.setString(1, userAddress.getCity());
        preparedStatement.setString(2, userAddress.getCity());
        preparedStatement.setString(3, userAddress.getPostalCode());
        return preparedStatement.executeUpdate();
    }
}
