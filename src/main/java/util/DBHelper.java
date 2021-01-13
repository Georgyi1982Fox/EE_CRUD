package util;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static DBHelper dbHelper;
    private DBHelper() {
    }
    public static DBHelper getDbHelper() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }

    public static SessionFactory getConfiguration() {
        Configuration conf = mySqlConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(conf.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return conf.buildSessionFactory(serviceRegistry);
    }
    private static Configuration mySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);


        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/de_api?serverTimezone=UTC");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "hjkEsk1982!");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.ddl.auto", "create");
        return configuration;
    }


    public static Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("de_api?").          //db name
                    append("user=root&").          //login
                    append("password=hjkEsk1982!").   //password
                    append("&serverTimezone=UTC");  //timezone

            System.out.println("URL: " + url + "\n");
            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }



}



