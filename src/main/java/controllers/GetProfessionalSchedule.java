package controllers;

import Applications.ProfessionalService;
import Applications.ScheduleService;
import TO.PByP;
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

@WebServlet("/get_professional_schedule_1")
public class GetProfessionalSchedule extends HttpServlet {

    private ScheduleService scheduleService = new ScheduleService();
    private DataConversion dataConversion = new DataConversion();
    private ProfessionalService professionalService = new ProfessionalService();

    private Gson gson = new Gson();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String body =  dataConversion.requestToJsonString(request);
        PByP pByP = gson.fromJson(body,PByP.class);

        Professional professional = professionalService.getProfessionalById(pByP.getId());
        List<Schedule> schedules = scheduleService.getSchedulesByProfessional(professional);

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
