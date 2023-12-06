package controllers;

import Applications.ProfessionalService;
import Applications.ServiceService;
import TO.ServiceProfessionalTO;
import TO.ServiceTO;
import com.google.gson.Gson;
import models.Professional;
import models.Service;
import utils.DataConversion;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/edit_professional_service")
public class EditProfessionalService extends HttpServlet {
    private ServiceService serviceService = new ServiceService();
    private ProfessionalService professionalService = new ProfessionalService();

    private DataConversion dataConversion = new DataConversion();
    private Gson gson = new Gson();

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String body = dataConversion.requestToJsonString(request);
        ServiceProfessionalTO serviceProfessionalTO = gson.fromJson(body,ServiceProfessionalTO.class);

        serviceService.updateService(serviceProfessionalTO);

        Professional professional = professionalService.getProfessionalById(serviceProfessionalTO.getProfessional_id());
        ArrayList<Service> services = serviceService.getServiceByProfessional(professional);
        ArrayList<ServiceTO> serviceTOS = ServiceTO.fromServices(services);

        String jsonString = "";
        PrintWriter responseOut = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        jsonString = gson.toJson(serviceTOS);

        responseOut.print(jsonString);
        responseOut.flush();
    }

}
