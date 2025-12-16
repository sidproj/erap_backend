package controllers;

import Applications.LoginService;
import TO.Credentials;
import TO.ErrorTO;
import TO.UserTO;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
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

    private final DataConversion dataConversion = new DataConversion();
    private final LoginService login = new LoginService();
    private final Gson gson = new Gson();

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String jsonString = "";
        PrintWriter responseOut = response.getWriter();

        try {
            String body = dataConversion.requestToJsonString(request);
            Credentials credentials = gson.fromJson(body, Credentials.class);
            System.out.println(credentials.getEmail() + " " + credentials.getPassword());
            User user = login.loginUser(credentials.getEmail(), credentials.getPassword());

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            if (user == null) {
                ErrorTO errorTO = new ErrorTO("Invalid login credentials", "ILC-U");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                jsonString = gson.toJson(errorTO);
            } else {
                UserTO userTO = new UserTO(user);
                response.setStatus(HttpServletResponse.SC_OK);
                jsonString = gson.toJson(userTO);
            }
        }
        catch(IOException e){
            ErrorTO errorTO = new ErrorTO("Error while reading request", "ILC-U");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            jsonString = gson.toJson(errorTO);
        }
        catch (JsonSyntaxException | NullPointerException e){
            ErrorTO errorTO = new ErrorTO("Invalid request data", "ILC-U");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            jsonString = gson.toJson(errorTO);
        }
        finally {
            responseOut.print(jsonString);
            responseOut.flush();
        }
    }
}
