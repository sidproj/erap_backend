package Applications;

import TO.PByP;
import dao.ProfessionDAO;
import dao.ProfessionalDAO;
import models.Profession;
import models.Professional;

import java.util.ArrayList;

public class ProfessionalService {
    private ProfessionDAO professionDAO = new ProfessionDAO();
    private ProfessionalDAO professionalDAO = new ProfessionalDAO();

    public ArrayList<Professional> getProfessionalByProfession(Profession profession){
        ArrayList<Professional> professionals = professionalDAO.findByProfession(profession);
        return professionals;
    }

    public Professional getProfessionalById(int id){
        Professional professional = professionalDAO.findById(id);
        return professional;
    }

    public ArrayList<Professional> getProfessionals(){
        ArrayList<Professional> professionals = professionalDAO.find();
        return professionals;
    }

    public void deleteProfessional(int professional_id){
        Professional professional = professionalDAO.findById(professional_id);
        professionalDAO.delete(professional);
    }
}
