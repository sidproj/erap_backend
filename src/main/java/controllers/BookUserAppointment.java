package controllers;

import Applications.AppointmentService;
import TO.AppointmentBookTO;
import TO.AppointmentTO;
import com.google.gson.Gson;
import models.Appointment;
import utils.DataConversion;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookUserAppointment",urlPatterns = {"/book_user_appointments"})
public class BookUserAppointment extends HttpServlet {
    private AppointmentService appointmentService = new AppointmentService();
    private DataConversion dataConversion = new DataConversion();
    private Gson gson = new Gson();

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String body = dataConversion.requestToJsonString(request);
        AppointmentBookTO appointmentBookTO = gson.fromJson(body,AppointmentBookTO.class);

        List<Appointment> appointments = appointmentService.bookAppointment(appointmentBookTO);
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
