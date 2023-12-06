package models;

import TO.ServiceTO;

import javax.persistence.*;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name="img")
    private String img;

    @Column(name="price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "professional_id")
    private Professional professional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public void copy(Service service){
        this.setDescription(service.getDescription());
        this.setImg(service.getImg());
        this.setName(service.getName());
    }

    public void copy(ServiceTO serviceTO){
        this.setDescription(serviceTO.getDescription());
        this.setImg(serviceTO.getImg());
        this.setName(serviceTO.getName());
        this.setPrice(serviceTO.getPrice());
        this.setDescription(serviceTO.getDescription());
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", professional=" + professional +
                '}';
    }
}
