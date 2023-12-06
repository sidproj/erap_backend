package controllers;

import Applications.RegisterService;
import TO.ErrorTO;
import TO.ProfRegister;
import TO.UserTO;
import com.google.gson.Gson;
import models.User;
import utils.DataConversion;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserRegister",urlPatterns = {"/user_register"})
public class UserRegister extends HttpServlet {

    // Utils
    private DataConversion dataConversion = new DataConversion();
    // Application Layer
    private RegisterService register = new RegisterService();
    // Gson
    private Gson gson = new Gson();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String body = dataConversion.requestToJsonString(request);
        ProfRegister userRegister = gson.fromJson(body, ProfRegister.class);

        String jsonString;
        PrintWriter responseOut = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        User user = register.registerUser(userRegister);
        if(user == null) {
            ErrorTO errorTO = new ErrorTO("Invalid register credentials","IRC-P");
            jsonString = gson.toJson(errorTO);
        }else{
            UserTO userTO = new UserTO(user);
            jsonString = gson.toJson(userTO);
        }

        responseOut.print(jsonString);
        responseOut.flush();
    }
}
