package Applications;

import TO.ProfessionTO;
import dao.ProfessionDAO;
import models.Profession;

import java.util.ArrayList;

public class ProfessionService {
    private ProfessionDAO professionDAO = new ProfessionDAO();

    public ArrayList<Profession> getProfessions(){
        ArrayList<Profession> professions = professionDAO.find();
        System.out.println(professions);
        return professions;
    }

    public Profession getProfession(int id){
        Profession profession = professionDAO.findById(id);
        return profession;
    }

    public void createProfession(ProfessionTO professionTo){
        Profession profession = new Profession();
        profession.copy(professionTo);
        professionDAO.save(profession);
    }

    public void updateProfession(ProfessionTO professionTO){
        Profession profession = professionDAO.findById(professionTO.getId());
        profession.copy(professionTO);
        professionDAO.update(profession);
    }

    public void deleteProfession(ProfessionTO professionTO){
        Profession profession = professionDAO.findById(professionTO.getId());
        professionDAO.delete(profession);
    }
}
