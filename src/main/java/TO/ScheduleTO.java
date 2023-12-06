package TO;

import models.Schedule;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ScheduleTO {
    protected int id;
    protected Timestamp start_time;
    protected Timestamp end_time;

    public ScheduleTO(){}

    public ScheduleTO(int id, Timestamp start_time, Timestamp end_time) {
        this.id = id;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public ScheduleTO(Schedule schedule){
        this.id = schedule.getId();
        this.start_time = schedule.getStart_time();
        this.end_time = schedule.getEnd_time();
    }

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

    public static ArrayList<ScheduleTO> fromSchedules(List<Schedule> schedules){
        ArrayList<ScheduleTO> scheduleTOS = new ArrayList<>();

        for(Schedule schedule:schedules){
            scheduleTOS.add(new ScheduleTO(schedule));
        }
        return scheduleTOS;
    }
}
