package Applications;

import TO.AppointmentBookTO;
import TO.AppointmentMeetingTO;
import TO.AppointmentTO;
import dao.*;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    private UserDAO userDAO = new UserDAO();
    private ProfessionalDAO professionalDAO = new ProfessionalDAO();
    private ServiceDAO serviceDAO = new ServiceDAO();
    private ScheduleDAO scheduleDAO = new ScheduleDAO();

    public List<Appointment> getUserAppointments(User user){
        List<Appointment> appointments =  user.getAppointments();
        return appointments;
    }

    public List<Appointment> getProfessionalAppointments(Professional professional){
        List<Appointment> appointments = professional.getAppointments();
        return appointments;
    }

    public List<Appointment> bookAppointment(AppointmentBookTO appointmentBookTO){
        // check for schedule's time not being less than current time --
        User user = userDAO.findById(appointmentBookTO.getUser_id());
        Professional professional = professionalDAO.findById(appointmentBookTO.getProfessional_id());
        Service service = serviceDAO.findById(appointmentBookTO.getService_id());
        Schedule schedule = scheduleDAO.findById(appointmentBookTO.getSchedule_id());

        Appointment appointment = new Appointment();
        appointment.setPayment_id(appointmentBookTO.getPayment_id());
        appointment.setUser(user);
        appointment.setProfessional(professional);
        appointment.setService(service);
        appointment.setSchedule(schedule);
        appointmentDAO.save(appointment);

        List<Appointment> appointments = user.getAppointments();
        return appointments;
    }

    public void setAppointmentMeeting_link(AppointmentMeetingTO appointmentMeetingTO){
        Appointment appointment = appointmentDAO.findById(appointmentMeetingTO.getAppointment_id());
        appointment.setMeeting_link(appointmentMeetingTO.getMeeting_link());
        appointmentDAO.update(appointment);
    }
}
