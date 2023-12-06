package controllers;

import Applications.ProfessionService;
import Applications.ProfessionalService;
import TO.PByP;
import TO.ProfessionalTO;
import com.google.gson.Gson;
import models.Profession;
import models.Professional;
import utils.DataConversion;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/professionals_by_profession")
public class GetProfessionalByProfessions extends HttpServlet {

    private DataConversion dataConversion = new DataConversion();
    private ProfessionalService professionalService = new ProfessionalService();
    private ProfessionService professionService = new ProfessionService();

    private Gson gson = new Gson();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String body = dataConversion.requestToJsonString(request);
        PByP pByP = gson.fromJson(body,PByP.class);

        Profession profession = professionService.getProfession(pByP.getId());
        ArrayList<Professional> professionals = professionalService.getProfessionalByProfession(profession);

        ArrayList<ProfessionalTO> professionalTOS = ProfessionalTO.fromProfessionals(professionals);

        String jsonString="";
        PrintWriter responseOut = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        jsonString = gson.toJson(professionalTOS);

        responseOut.print(jsonString);
        responseOut.flush();
    }
}
