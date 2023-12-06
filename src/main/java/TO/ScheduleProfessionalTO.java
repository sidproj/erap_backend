package TO;


import java.sql.Timestamp;

public class ScheduleProfessionalTO extends ScheduleTO {

    private int professional_id;

    public ScheduleProfessionalTO(int id, Timestamp start_time, Timestamp end_time,int professional_id) {
        super(id, start_time, end_time);
        this.professional_id = professional_id;
    }

    public int getProfessional_id() {
        return professional_id;
    }

    public void setProfessional_id(int professional_id) {
        this.professional_id = professional_id;
    }

    public ScheduleTO getScheduleTO(){
        ScheduleTO scheduleTO = new ScheduleTO();
        scheduleTO.setEnd_time(this.getEnd_time());
        scheduleTO.setStart_time(this.getStart_time());
        scheduleTO.setId(this.getId());
        return scheduleTO;
    }
}
