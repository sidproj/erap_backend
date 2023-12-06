package Applications;

import TO.ProfRegister;
import dao.AdminDAO;
import dao.ProfessionDAO;
import dao.ProfessionalDAO;
import dao.UserDAO;
import models.Profession;
import models.Professional;
import models.User;

public class RegisterService {
    private UserDAO userDAO = new UserDAO();
//    DAOFactory.getBookDAO(); return type BookDAO (interface / abstract)
    private ProfessionalDAO professionalDAO = new ProfessionalDAO();
    private AdminDAO adminDAO = new AdminDAO();
    private ProfessionDAO professionDAO = new ProfessionDAO();


    public Professional registerProfessional(ProfRegister profRegister){
        String password = profRegister.getPassword();
        String confPassword = profRegister.getConfirmPassword();
        if(! password.equals(confPassword)) return null;

        Professional newProfessional = new Professional();
        profRegister.copyToProfessional(newProfessional);

        Profession profession = professionDAO.findById(profRegister.getProfession_id());

        newProfessional.setProfession(profession);

        newProfessional = professionalDAO.save(newProfessional);
        return newProfessional;
    }

    public User registerUser(ProfRegister registerData){
        String password = registerData.getPassword();
        String confPassword = registerData.getConfirmPassword();

        if(! password.equals(confPassword)) return null;

        User newUser = new User();
        registerData.copyToUser(newUser);

        newUser = userDAO.save(newUser);
        return newUser;

    }
}
