package controllers;

import Applications.RegisterService;
import TO.ErrorTO;
import TO.ProfessionalTO;
import TO.ProfRegister;
import com.google.gson.Gson;
import models.Professional;
import utils.DataConversion;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/professional_register")
public class ProfessionalRegister extends HttpServlet {

    // Utils
    private DataConversion dataConversion = new DataConversion();
    // Application Layer
    private RegisterService register = new RegisterService();
    // GSON
    private Gson gson = new Gson();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String body = dataConversion.requestToJsonString(request);
        ProfRegister profRegister = gson.fromJson(body, ProfRegister.class);

        String jsonString;
        PrintWriter responseOut = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");


        Professional professional = register.registerProfessional(profRegister);
        if(professional == null){
            ErrorTO errorTO = new ErrorTO("Invalid register credentials","IRC-P");
            jsonString = gson.toJson(errorTO);
        }else{
            ProfessionalTO professionalTO = new ProfessionalTO(professional);
            jsonString = gson.toJson(professionalTO);
        }

        responseOut.print(jsonString);
        responseOut.flush();
    }
}
