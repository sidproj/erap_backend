package controllers;

import Applications.AppointmentService;
import Applications.UserService;
import TO.AppointmentTO;
import TO.PByP;
import com.google.gson.Gson;
import models.Appointment;
import models.User;
import utils.DataConversion;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/get_user_appointments")
public class GetUserAppointments extends HttpServlet {
    private AppointmentService appointmentService = new AppointmentService();
    private UserService userService = new UserService();
    private DataConversion dataConversion = new DataConversion();
    private Gson gson = new Gson();

    public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException{
        String body = dataConversion.requestToJsonString(request);
        PByP pByP = gson.fromJson(body,PByP.class);

        User user = userService.getUserById(pByP.getId());
        List appointments = appointmentService.getUserAppointments(user);
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
