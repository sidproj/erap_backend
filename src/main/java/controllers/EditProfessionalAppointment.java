package controllers;

import Applications.AppointmentService;
import Applications.ProfessionalService;
import TO.AppointmentMeetingTO;
import TO.AppointmentTO;
import com.google.gson.Gson;
import models.Appointment;
import models.Professional;
import utils.DataConversion;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/edit_professional_appointment")
public class EditProfessionalAppointment extends HttpServlet {
    private DataConversion dataConversion = new DataConversion();
    private Gson gson = new Gson();

    private ProfessionalService professionalService = new ProfessionalService();
    private AppointmentService appointmentService = new AppointmentService();

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String body = dataConversion.requestToJsonString(request);
        AppointmentMeetingTO appointmentMeetingTO = gson.fromJson(body,AppointmentMeetingTO.class);
        appointmentService.setAppointmentMeeting_link(appointmentMeetingTO);

        Professional professional = professionalService.getProfessionalById(appointmentMeetingTO.getProfessional_id());
        List<Appointment> appointments = appointmentService.getProfessionalAppointments(professional);
        ArrayList<AppointmentTO> appointmentTOS = AppointmentTO.fromAppointments(appointments);

        String jsonString = "";
        PrintWriter responseOut = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        jsonString = gson.toJson(appointmentTOS);

        responseOut.print(jsonString);
        responseOut.flush();

    }

}
