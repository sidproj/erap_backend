package controllers;

import Applications.LoginService;
import TO.Credentials;
import TO.ErrorTO;
import TO.ProfessionalTO;
import com.google.gson.Gson;
import models.Professional;
import utils.DataConversion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/professional_login")
public class ProfessionalLogin extends HttpServlet {

    // Utils
    private DataConversion dataConversion = new DataConversion();
    // Application Layer
    private LoginService login = new LoginService();
    // GSON
    private Gson gson = new Gson();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String body = dataConversion.requestToJsonString(request);
        Credentials credentials = gson.fromJson(body,Credentials.class);

        Professional professional = login.loginProfessional(credentials.getEmail(), credentials.getPassword());
        String jsonString;

        PrintWriter responseOut = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if(professional == null){
            ErrorTO errorTO = new ErrorTO("Invalid login credentials","ILC-P");
            jsonString = gson.toJson(errorTO);
        }else{
            ProfessionalTO professionalTO = new ProfessionalTO(professional);
            jsonString = gson.toJson(professionalTO);
        }
        responseOut.print(jsonString);
        responseOut.flush();
    }
}
