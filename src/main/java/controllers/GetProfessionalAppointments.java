package controllers;

import Applications.AppointmentService;
import Applications.ProfessionalService;
import TO.AppointmentTO;
import TO.PByP;
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

@WebServlet("/get_professional_appointments")
public class GetProfessionalAppointments extends HttpServlet {
    private Gson gson = new Gson();
    private DataConversion dataConversion = new DataConversion();
    private AppointmentService appointmentService = new AppointmentService();
    private ProfessionalService professionalService = new ProfessionalService();

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String body = dataConversion.requestToJsonString(request);
        PByP pByP = gson.fromJson(body,PByP.class);

        Professional professional = professionalService.getProfessionalById(pByP.getId());
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
