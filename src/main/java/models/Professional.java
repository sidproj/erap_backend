package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="professionals")
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "img")
    private String img;

    @Column(name = "password")
    private String password;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;

    // Bi directional for schedules
    @OneToMany(mappedBy = "professional")
    private List<Schedule> schedules;

    // Bi directional for services
    @OneToMany(mappedBy = "professional")
    private List<Service> services;

    @OneToMany(mappedBy = "professional")
    private List<Appointment> appointments;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void copy(Professional professional){
        this.setFirst_name(professional.getFirst_name());
        this.setLast_name(professional.getLast_name());
        this.setEmail(professional.getEmail());
        this.setProfession(professional.getProfession());
        this.setPassword(professional.getPassword());
        this.setImg(professional.getImg());

    }

    @Override
    public String toString() {
        return "Professional{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", img='" + img + '\'' +
                ", password='" + password + '\'' +
                ", profession=" + profession.getId() +
                '}';
    }
}
