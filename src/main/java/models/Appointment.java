package models;


import javax.persistence.*;

@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="payment_id")
    private String payment_id;

    @Column(name="meeting_link")
    private String meeting_link;

    @Column(name="is_completed")
    private boolean is_completed;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "professional_id")
    private Professional professional;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @OneToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getMeeting_link() {
        return meeting_link;
    }

    public void setMeeting_link(String meeting_link) {
        this.meeting_link = meeting_link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean isIs_complete() {
        return is_completed;
    }

    public void setIs_complete(boolean is_completed) {
        this.is_completed = is_completed;
    }

    public void copy(Appointment appointment){
        this.setMeeting_link(appointment.getMeeting_link());
        this.setPayment_id(appointment.getPayment_id());
        this.setService(appointment.getService());
        this.setSchedule(appointment.getSchedule());
        this.setUser(appointment.getUser());
        this.setIs_complete(appointment.isIs_complete());
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", payment_id='" + payment_id + '\'' +
                ", meeting_link='" + meeting_link + '\'' +
                ", is_complete=" + is_completed +
                ", user=" + user +
                ", professional=" + professional +
                ", service=" + service +
                ", schedule=" + schedule +
                '}';
    }
}
