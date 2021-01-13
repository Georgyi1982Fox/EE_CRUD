package userService;

import dao.UserDAO;
import dao.UserDaoFactory;
import dao.UserHibernateDAO;
//import dao.UserJdbcDAO;
import dao.UserJdbcDAO;
import model.User;
import util.DBHelper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService userService;
    private static UserDAO userDAO;

    public static UserDAO getUserDao() throws IOException {
        if(userDAO == null){
            userDAO = new UserJdbcDAO(DBHelper.getConnection());
        //UserDaoFactory.getDaoType();
                    //new UserHibernateDAO();
                    //new UserJdbcDAO(DBHelper.getConnection());
        }
        return userDAO;
    }

    private UserService() {
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void addUser(User user) throws SQLException, IOException {
        getUserDao().addUser(user);
    }

    public List<User> listAllUsers() throws SQLException, IOException {
        return getUserDao().listAllUsers();
    }

    public boolean validateClient(String name, String password) throws SQLException, IOException {
            return getUserDao().validateClient(name, password);

    }

    public String getRoleByLoginAndPassword(String name, String password) throws SQLException, IOException {
        return getUserDao().getRoleByLoginPassword(name,password);
    }

    public User getUserById(Long id) throws SQLException, IOException {
        return getUserDao().getUserById(id);
    }


    public void updateUser(User user) throws SQLException, IOException {
        getUserDao().updateUser(user);
    }

    public void deleteUser(Long id) throws SQLException, IOException {
         getUserDao().deleteUser(id);
    }
}