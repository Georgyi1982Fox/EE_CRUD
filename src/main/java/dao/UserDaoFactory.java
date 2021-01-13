package dao;

import util.DBHelper;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {

    public static UserDAO getDaoType() throws IOException {

        try (InputStream inputStream = UserDaoFactory.class.getResourceAsStream("/config.properties")) {
            Properties pr = new Properties();
            pr.load(inputStream);

            String userDaoType = pr.getProperty("typeDao", "userJdbcDAO");
            if ("userHibernateDAO".equals(userDaoType)) {
                return new UserHibernateDAO();
            }
            if ("userJdbcDAO".equals(userDaoType)) {
                return new UserJdbcDAO(DBHelper.getConnection());
            } else
                return null;
        }
    }
}
