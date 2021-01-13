package dao;

import model.User;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDAO {

    public UserHibernateDAO() {
    }

    @Override
    public List<User> listAllUsers() throws SQLException {
        Session session = DBHelper.getConfiguration().openSession();
        List<User> allUsers;
        Transaction transaction = session.beginTransaction();
        allUsers = session.createQuery("FROM User").list();
        transaction.commit();
        return allUsers;
    }

    @Override
    public void addUser(User user) throws SQLException {
        Session session = DBHelper.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
    }

    @Override
    public boolean validateClient(String name, String password) throws SQLException {
        Session session = DBHelper.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.createQuery(" FROM User u  WHERE u.name=:name AND u.password=:password")
                .setParameter("name", name)
                .setParameter("password", password)
                .uniqueResult();
        transaction.commit();
        if(user != null){
            return true;
        } else
            return false;
    }

    @Override
    public String getRoleByLoginPassword(String name, String password) throws SQLException {
        Session session=DBHelper.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        User role = (User) session.createQuery("FROM User WHERE name=:name AND password=:password")
                .setParameter("name", name)
                .setParameter("password", password)
                .setMaxResults(1)
                .uniqueResult();
        transaction.commit();
        return role.getRoles();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        Session session = DBHelper.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        Query query  = session.createQuery("update User u SET u.name=:name, u.password=:password, u.email=:email WHERE u.name=:name");
        query.setParameter("name", user.getName());
        query.setParameter("password", user.getPassword());
        query.setParameter("email", user.getEmail());
        query.setParameter("name", user.getName());
        int result = query.executeUpdate();
        transaction.commit();
        session.close();

    }

    @Override
    public void deleteUser(Long id) throws SQLException {
        Session session = DBHelper.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        User deleteUser = (User) session.createQuery("FROM User WHERE id=:id")
                .setParameter("id", id)
                .uniqueResult();
        session.delete(deleteUser);
        transaction.commit();
    }

    @Override
    public User getUserById(Long id) throws SQLException {
        Session session = DBHelper.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        User userById = (User) session.createQuery(" FROM User u  WHERE u.id=:id")
                .setParameter("id", id)
                .setMaxResults(1)
                .uniqueResult();
        User user = new User(userById.getId(), userById.getName(),userById.getEmail());
        transaction.commit();
        return user;
    }
/*


    @Override
    public Role getRoleById(Long id) {
        Session session = DBHelper.getConfiguration().openSession();
        Transaction transaction = session.beginTransaction();
        Role role = session
                .createQuery("SELECT r FROM Role r  WHERE r.id=:id", Role.class)
                .setParameter("id", id)
                .getSingleResult();
        return role;
    }

 */
}















