package TO;

import models.Profession;

import java.util.ArrayList;

public class ProfessionTO {
    private int id;
    private String img;
    private String name;
    private String description;

    public ProfessionTO(int id, String img, String name, String description) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.description = description;
    }

    public ProfessionTO(Profession profession){
        this.id = profession.getId();
        this.img = profession.getImg();
        this.name = profession.getName();
        this.description = profession.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<ProfessionTO> fromProfessions(ArrayList<Profession> professions){
        ArrayList<ProfessionTO> professionTOS = new ArrayList<>();
        for(Profession profession : professions){
            professionTOS.add(new ProfessionTO(profession));
        }
        return professionTOS;
    }
}
