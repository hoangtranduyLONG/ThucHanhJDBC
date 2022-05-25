package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    public List<Customer> insert(Customer customer) throws SQLException;

    public Customer findByID(int id);

    public List<Customer> findAll();

    public boolean delete(int id) throws SQLException;

    public boolean updateUser(Customer customer) throws SQLException;
}