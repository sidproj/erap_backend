package controllers;

import Applications.ProfessionalService;
import Applications.ServiceService;
import TO.PByP;
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

@WebServlet("/service_by_professional")
public class GetProfessionalServices extends HttpServlet {
    private DataConversion dataConversion = new DataConversion();
    private ServiceService serviceService = new ServiceService();
    private ProfessionalService professionalService = new ProfessionalService();

    private Gson gson = new Gson();

    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String body = dataConversion.requestToJsonString(request);
        PByP pByP = gson.fromJson(body,PByP.class);

        Professional professional = professionalService.getProfessionalById(pByP.getId());
        ArrayList<Service> services = serviceService.getServiceByProfessional(professional);
        ArrayList<ServiceTO> serviceTOs = ServiceTO.fromServices(services);

        String jsonString="";
        PrintWriter responseOut = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        jsonString = gson.toJson(serviceTOs);

        responseOut.print(jsonString);
        responseOut.flush();

    }
}
