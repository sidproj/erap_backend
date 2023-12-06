package models;

import TO.ProfessionTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="professions")
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "img")
    private String img;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "profession")
    private List<Professional> professionals;

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

    public List<Professional> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(ArrayList<Professional> professionals) {
        this.professionals = professionals;
    }

    public void copy(Profession profession){
        this.setName(profession.getName());
        this.setImg(profession.getImg());
        this.setDescription(profession.getDescription());
    }

    public void copy(ProfessionTO professionTO){
        this.setName(professionTO.getName());
        this.setImg(professionTO.getImg());
        this.setDescription(professionTO.getDescription());
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
