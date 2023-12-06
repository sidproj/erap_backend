package TO;

import models.Profession;
import models.Professional;

import java.util.ArrayList;

public class ProfessionalTO {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String img;
    private String description;

    public ProfessionalTO(Professional professional) {
        this.id = professional.getId();
        this.first_name = professional.getFirst_name();
        this.last_name = professional.getLast_name();
        this.email = professional.getEmail();
        this.img = professional.getImg();
        this.description = professional.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<ProfessionalTO> fromProfessionals(ArrayList<Professional> professionals){
        ArrayList<ProfessionalTO> professionalTOS = new ArrayList<>();
        for(Professional professional : professionals){
            professionalTOS.add(new ProfessionalTO(professional));
        }
        return professionalTOS;
    }
}
