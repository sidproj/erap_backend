package Applications;

import dao.AdminDAO;
import dao.ProfessionalDAO;
import dao.UserDAO;
import exceptions.NoRecordFound;
import models.Professional;
import models.User;

// Application logic for login of user,professional and admin
public class LoginService {
    private UserDAO userDAO = new UserDAO();
    private ProfessionalDAO professionalDAO = new ProfessionalDAO();
    private AdminDAO adminDAO = new AdminDAO();

    public User loginUser(String email,String password){
        try {
            User user = userDAO.findByEmail(email);
            if(user.getPassword().equals(password)){
                return user;
            }else return null;
        }catch (NoRecordFound nre){
            return null;
        }
    }

    public Professional loginProfessional(String email,String password){
        try{
            Professional professional = professionalDAO.findByEmail(email);
            if(professional.getPassword().equals(password)){
                return professional;
            }else return null;
        }catch (NoRecordFound nre){
            return null;
        }
    }
}
