package service;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
   List<Customer> customers;

    public CustomerDAO() {
    }

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo2006?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insert(Customer customer) throws SQLException {
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("insert into customer values (?,?,?)");) {
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

        }

    }

    @Override
    public Customer findByID(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from customer")) {
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                customers.add(new Customer(id, name, age));
            }
        } catch (SQLException e) {

        }
        return customers;
    }

    @Override
    public List<Customer> findByName(String Name) {
        return null;
    }

    @Override
    public Customer findIndexByName(int id) {
        List<Customer> customers = findAll();
        for (Customer customer:customers
             ) {
           if(customer.getId()==id) {
               return customer;
           }

        }
        return null;
    }

    public List<Customer> findAllOrderByAge() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(Customer customer) throws SQLException {

        return false;
    }

    public void deleteCustomer(int id) {
    }

    public void update(Customer customer) {
    }
}
