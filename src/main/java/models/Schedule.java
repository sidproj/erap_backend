package models;

import TO.ScheduleTO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "start_time")
    private Timestamp start_time;

    @Column(name = "end_time")
    private Timestamp end_time;

    @ManyToOne
    @JoinColumn(name="professional_id")
    private Professional professional;

    @OneToOne(mappedBy = "schedule")
    private Appointment appointment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Appointment getAppointments() {
        return appointment;
    }

    public void setAppointments(Appointment appointment) {
        this.appointment = appointment;
    }

    public void copy(Schedule schedule){
        this.setStart_time(schedule.getStart_time());
        this.setEnd_time(schedule.getEnd_time());
        this.setProfessional(schedule.getProfessional());
    }

    public void copy(ScheduleTO scheduleTO){
        this.setStart_time(scheduleTO.getStart_time());
        this.setEnd_time(scheduleTO.getEnd_time());
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", professional=" + professional.getId() +
                ", appointments=" + appointment.getId() +
                '}';
    }
}
