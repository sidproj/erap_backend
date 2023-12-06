package Applications;

import TO.ProfessionalTO;
import TO.ScheduleTO;
import dao.ProfessionalDAO;
import dao.ScheduleDAO;
import models.Professional;
import models.Schedule;

import java.util.ArrayList;
import java.util.List;

public class ScheduleService {
    private ScheduleDAO scheduleDAO = new ScheduleDAO();
    private ProfessionalDAO professionalDAO = new ProfessionalDAO();

    public List<Schedule> getSchedulesByProfessional(Professional professional){
        List<Schedule> schedules = professional.getSchedules();
        return schedules;
    }

    public Schedule getScheduleById(int id){
        Schedule schedule = scheduleDAO.findById(id);
        return schedule;
    }

    public void createSchedule(Professional professional, ScheduleTO scheduleTO){
        Schedule schedule = new Schedule();
        schedule.copy(scheduleTO);
        schedule.setProfessional(professional);
        scheduleDAO.save(schedule);
    }

    public void updateSchedule(ScheduleTO scheduleTO){
        Schedule schedule = scheduleDAO.findById(scheduleTO.getId());
        schedule.copy(scheduleTO);
        scheduleDAO.update(schedule);
    }

    public ArrayList<Schedule> findAll(){
        ArrayList<Schedule> schedules = scheduleDAO.find();
        return schedules;
    }

    public void deleteSchedule(ScheduleTO scheduleTO){
        Schedule schedule = scheduleDAO.findById(scheduleTO.getId());
        scheduleDAO.delete(schedule);
    }
}
