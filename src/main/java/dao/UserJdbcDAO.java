package dao;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO{
    private Connection connection;

    public UserJdbcDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<User> listAllUsers() throws SQLException {
        List<User> listUsers= new ArrayList<User>();
        String sql = "SELECT * FROM users";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String password= resultSet.getString("password");
                String email = resultSet.getString("email");
                String roles = resultSet.getString("role");

                User user = new User(id, name, password, email, roles);
                listUsers.add(user);
            }
        }catch (SQLException e){
            throw new SQLException();
        }
        return listUsers;
    }

    @Override
    public void addUser(User user)throws SQLException {
        String sql = "INSERT INTO users(name,password,email,role) VALUES (?,?,?,?)";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1,user.getName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getRoles());
            pst.executeUpdate();
        }
    }

    @Override
    public boolean validateClient(String name, String password) throws SQLException{
        String query = "select * from users where name = ? AND password = ? ";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1,name);
            stmt.setString(2,password);
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                String userName = result.getString("name");
                String userPassword = result.getString("password");
                if(userName.equals(name) && userPassword.equals(password)){
                    return true;
                }
            }
            return false;
        }
    }


    @Override
    public String getRoleByLoginPassword(String name, String password) throws SQLException {
        String role = "";
        String query = "select * from users where name =? AND password=?";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1,name);
            stmt.setString(2,password);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                 role = resultSet.getString("role");
            }
            return role;
        }
    }

    @Override
    public void deleteUser(Long id)throws  SQLException {
        String sql = "DELETE FROM users where id = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, id);
            boolean deleted = pst.executeUpdate() > 0;
            //return deleted;
        }
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?,  password = ?, email = ? WHERE name = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, user.getName());
            pst.setString(2, user.getPassword());
            pst.setString(3,user.getEmail());
            pst.setString(4,user.getName());
            pst.executeUpdate();
        }
    }



    public User getUserById(Long id)throws SQLException {
        User user = null;
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, id);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                user = new User(id, name, email);
            }

            return user;
        }
    }

    public void createTable()throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.execute("CREATE TABLE `users` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(128) NOT NULL,\n" +
                "  `password` varchar(45) NOT NULL,\n" +
                "  `email` varchar(45) NOT NULL,\n" +
                "  PRIMARY KEY (`id`))");
        stmt.close();
    }

    public void deleteTable()throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS users");
        stmt.close();
    }
}


