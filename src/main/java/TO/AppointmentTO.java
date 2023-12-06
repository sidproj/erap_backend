package TO;

import models.Appointment;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AppointmentTO {
    private int id;
    private String payment_id;
    private String meeting_link;
    private String professional_email;
    private String professional_first_name;
    private String professional_last_name;
    private Timestamp start_time;
    private Timestamp end_time;

    public AppointmentTO(Appointment appointment){
        this.id = appointment.getId();
        this.payment_id = appointment.getPayment_id();
        this.meeting_link = appointment.getMeeting_link();
        this.professional_email = appointment.getProfessional().getEmail();
        this.professional_first_name = appointment.getProfessional().getFirst_name();
        this.professional_last_name = appointment.getProfessional().getLast_name();
        this.start_time = appointment.getSchedule().getStart_time();
        this.end_time = appointment.getSchedule().getEnd_time();
    }

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

    public String getProfessional_email() {
        return professional_email;
    }

    public void setProfessional_email(String professional_email) {
        this.professional_email = professional_email;
    }

    public String getProfessional_first_name() {
        return professional_first_name;
    }

    public void setProfessional_first_name(String professional_first_name) {
        this.professional_first_name = professional_first_name;
    }

    public String getProfessional_last_name() {
        return professional_last_name;
    }

    public void setProfessional_last_name(String professional_last_name) {
        this.professional_last_name = professional_last_name;
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

    public static ArrayList<AppointmentTO> fromAppointments(List<Appointment> appointments){
        ArrayList<AppointmentTO> appointmentTOS = new ArrayList<>();
        for(Appointment appointment : appointments){
            appointmentTOS.add(new AppointmentTO(appointment));
        }
        return appointmentTOS;
    }
}
