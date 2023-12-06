package Applications;

import dao.UserDAO;
import models.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User getUserById(int id){
        return userDAO.findById(id);
    }
}
