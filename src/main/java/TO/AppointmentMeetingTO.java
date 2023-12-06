package TO;

public class AppointmentMeetingTO {
    private String meeting_link;
    private int appointment_id;
    private int professional_id;

    AppointmentMeetingTO(){}

    public AppointmentMeetingTO(String meeting_link, int appointment_id,int professional_id) {
        this.meeting_link = meeting_link;
        this.appointment_id = appointment_id;
        this.professional_id = professional_id;
    }

    public String getMeeting_link() {
        return meeting_link;
    }

    public void setMeeting_link(String meeting_link) {
        this.meeting_link = meeting_link;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public int getProfessional_id() {
        return professional_id;
    }

    public void setProfessional_id(int professional_id) {
        this.professional_id = professional_id;
    }
}
