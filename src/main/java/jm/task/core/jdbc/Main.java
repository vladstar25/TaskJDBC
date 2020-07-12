package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateSessionFactory;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();

        userDaoJDBC.saveUser("Vasya", "Pupkin", (byte) 35);
        userDaoJDBC.saveUser("Pasha", "Koshkin", (byte) 25);
        userDaoJDBC.saveUser("Merlin", "Monro", (byte) 85);
        userDaoJDBC.saveUser("Roman", "Hochkin", (byte) 43);

        Iterator<User> iterator = userDaoJDBC.getAllUsers().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

        userDaoJDBC.dropUsersTable();
    }
}
