package Applications;

import TO.*;
import models.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdminService {
    AppointmentService appointmentService = new AppointmentService();
    ProfessionalService professionalService = new ProfessionalService();
    ProfessionService professionService = new ProfessionService();
    ScheduleService scheduleService = new ScheduleService();
    ServiceService serviceService = new ServiceService();
    UserService userService = new UserService();

    public ArrayList<User> findAllUsers(){
        return userService.getUsers();
    }

    public User findUser(int user_id){
        return userService.getUserById(user_id);
    }

    public ArrayList<Professional> findAllProfessionals(){
        return professionalService.getProfessionals();
    }

    public Professional findProfessional(int professional_id){
        return professionalService.getProfessionalById(professional_id);
    }

    public ArrayList<Profession> findAllProfession(){
        return professionService.getProfessions();
    }

    public Profession findProfession(int profession_id){
        return professionService.getProfession(profession_id);
    }

    public ArrayList<Schedule> findSchedules(){
        return scheduleService.findAll();
    }

    public Schedule findSchedule(int schedule_id){
        return scheduleService.getScheduleById(schedule_id);
    }

    public ArrayList<Service> findServices(){
        return serviceService.findAll();
    }

    public Service findService(int service_id){
        return serviceService.getServiceById(service_id);
    }

    public void updateAppointment(AppointmentMeetingTO appointmentMeetingTO){
        appointmentService.setAppointmentMeeting_link(appointmentMeetingTO);
    }

    public void deleteProfessional(ProfessionalTO professionalTO){
        professionalService.deleteProfessional(professionalTO.getId());
    }

    public void deleteSchedule(ScheduleTO scheduleTO){
        scheduleService.deleteSchedule(scheduleTO);
    }

    public void deleteService(ServiceTO serviceTO){
        serviceService.deleteService(serviceTO);
    }

    public void deleteProfession(ProfessionTO professionTO){
        professionService.deleteProfession(professionTO);
    }

    public void updateProfession(ProfessionTO professionTO){
        professionService.updateProfession(professionTO);
    }

    public void updateSchedule(ScheduleTO scheduleTO){
        scheduleService.updateSchedule(scheduleTO);
    }

    public void updateService(ServiceTO serviceTO){
        serviceService.updateService(serviceTO);
    }
}
