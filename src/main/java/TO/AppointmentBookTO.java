package TO;

public class AppointmentBookTO {
    private int service_id;
    private int schedule_id;
    private int user_id;
    private int professional_id;
    private String payment_id;

    public AppointmentBookTO(int service_id, int schedule_id, int user_id, int professional_id,String payment_id) {
        this.service_id = service_id;
        this.schedule_id = schedule_id;
        this.user_id = user_id;
        this.professional_id = professional_id;
        this.payment_id = payment_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProfessional_id() {
        return professional_id;
    }

    public void setProfessional_id(int professional_id) {
        this.professional_id = professional_id;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }
}
