package Applications;

import dao.UserDAO;
import models.User;

import java.util.ArrayList;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User getUserById(int id){
        return userDAO.findById(id);
    }

    public ArrayList<User> getUsers(){return userDAO.find();}
}
