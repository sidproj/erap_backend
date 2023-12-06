package controllers;

import Applications.LoginService;
import TO.Credentials;
import TO.ErrorTO;
import TO.UserTO;
import com.google.gson.Gson;
import models.User;
import utils.DataConversion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserLogin",urlPatterns = {"/user_login"})
public class UserLogin extends HttpServlet {

    // Utils
    private DataConversion dataConversion = new DataConversion();
    // Application layer
    private LoginService login = new LoginService();

    // GSON
    private Gson gson = new Gson();

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String body = dataConversion.requestToJsonString(request);
        Credentials credentials = gson.fromJson(body,Credentials.class);
        User user = login.loginUser(credentials.getEmail(), credentials.getPassword());
        String jsonString;
        PrintWriter responseOut = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if(user == null){
            ErrorTO errorTO = new ErrorTO("Invalid login credentials","ILC-U");
            jsonString= gson.toJson(errorTO);
        }else {
            UserTO userTO = new UserTO(user);
            jsonString = gson.toJson(userTO);
        }
        responseOut.print(jsonString);
        responseOut.flush();
    }
}
