package controllers;

import Applications.ProfessionService;
import TO.ProfessionTO;
import com.google.gson.Gson;
import models.Profession;
import utils.DataConversion;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "GetProfessions",urlPatterns = {"/get_professions"})
public class GetProfessions extends HttpServlet {
    // Utils
    private DataConversion dataConversion = new DataConversion();
    // Application Layer
    private ProfessionService professionService = new ProfessionService();
    // GSON
    private Gson gson = new Gson();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Profession> professions = professionService.getProfessions();
        String jsonString="";
        PrintWriter responseOut = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ArrayList<ProfessionTO> professionTOS = ProfessionTO.fromProfessions(professions);
        jsonString = gson.toJson(professionTOS);

        responseOut.print(jsonString);
        responseOut.flush();
    }
}
