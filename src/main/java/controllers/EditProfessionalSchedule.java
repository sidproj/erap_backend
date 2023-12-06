package controllers;

import Applications.ProfessionalService;
import Applications.ScheduleService;
import TO.ScheduleProfessionalTO;
import TO.ScheduleTO;
import com.google.gson.Gson;
import models.Professional;
import models.Schedule;
import utils.DataConversion;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/edit_professional_schedule")
public class EditProfessionalSchedule extends HttpServlet {
    private DataConversion dataConversion = new DataConversion();
    private Gson gson = new Gson();

    private ScheduleService scheduleService = new ScheduleService();
    private ProfessionalService professionalService = new ProfessionalService();

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String body = dataConversion.requestToJsonString(request);
        ScheduleProfessionalTO scheduleProfessionalTO = gson.fromJson(body,ScheduleProfessionalTO.class);

        scheduleService.updateSchedule(scheduleProfessionalTO);
        Professional professional = professionalService.getProfessionalById(scheduleProfessionalTO.getProfessional_id());
        List<Schedule> schedules = professional.getSchedules();
        ArrayList<ScheduleTO> scheduleTOS = ScheduleTO.fromSchedules(schedules);

        String jsonString = "";
        PrintWriter responseOut = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        jsonString = gson.toJson(scheduleTOS);

        responseOut.print(jsonString);
        responseOut.flush();

    }

}
