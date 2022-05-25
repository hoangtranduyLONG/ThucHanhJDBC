package service;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
    List<Customer> customers = new ArrayList<>();
    public CustomerDAO() {
   }

   protected static Connection getConnection() {
      Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo2006?useSSL=false", "root", "123456");
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
    public List<Customer> insert(Customer customer) throws SQLException {
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select* from customer");) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int email = Integer.parseInt(rs.getString("age"));
                customers.add(new Customer(id, name, email));
           }
        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public Customer findByID(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {

            try (Connection connection = getConnection();

                 PreparedStatement preparedStatement = connection.prepareStatement("select* from customer");) {
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int email = Integer.parseInt(rs.getString("age"));
                    customers.add(new Customer(id, name, email));
                }
            } catch (SQLException e) {

            }
            return customers;
        }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(Customer customer) throws SQLException {
        return false;
    }
//    public CustomerDAO() {
//    }
//
//    protected static Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo2006?useSSL=false", "root", "123456");
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    @Override
//    public List<Customer> insert(Customer customer) throws SQLException {
//        try (Connection connection = getConnection();
//
//             PreparedStatement preparedStatement = connection.prepareStatement("select* from customer");) {
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                int email = Integer.parseInt(rs.getString("age"));
//                customers.add(new Customer(id, name, email));
//            }
//        } catch (SQLException e) {
//
//        }
//
//        @Override
//        public Customer findByID ( int id){
//            return null;
//        }
//
//        @Override
//        public List<Customer> findAll () {
//            List<Customer> customers = new ArrayList<>();
//            try (Connection connection = getConnection();
//
//                 PreparedStatement preparedStatement = connection.prepareStatement("select* from customer");) {
//                System.out.println(preparedStatement);
//                // Step 3: Execute the query or update query
//                ResultSet rs = preparedStatement.executeQuery();
//
//                // Step 4: Process the ResultSet object.
//                while (rs.next()) {
//                    int id = rs.getInt("id");
//                    String name = rs.getString("name");
//                    int email = Integer.parseInt(rs.getString("age"));
//                    customers.add(new Customer(id, name, email));
//                }
//            } catch (SQLException e) {
//
//            }
//            return customers;
//        }
//
//        @Override
//        public boolean delete ( int id) throws SQLException {
//            return false;
//        }
//
//        @Override
//        public boolean updateUser;
//        (Customer customer) throws SQLException {
//            return false;
//        }
    }
