package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        new UserDaoJDBCImpl().createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        new UserDaoJDBCImpl().dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            new UserDaoJDBCImpl().saveUser(name, lastName, age);
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void removeUserById(long id) throws SQLException {
        new UserDaoJDBCImpl().removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return new UserDaoJDBCImpl().getAllUsers();
    }

    public void cleanUsersTable() {
        try{
            new UserDaoJDBCImpl().cleanUsersTable();
        } catch(SQLException ex){
            ex.printStackTrace();
        }

    }
}
