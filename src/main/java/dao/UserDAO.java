package dao;


import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void addUser(User user) throws SQLException;

    List<User> listAllUsers() throws SQLException;

    boolean validateClient(String name, String password) throws SQLException;

    String getRoleByLoginPassword(String name, String password) throws SQLException;

    void updateUser(User user) throws SQLException;

    void deleteUser(Long id) throws SQLException;

    public User getUserById(Long id) throws SQLException;
}


