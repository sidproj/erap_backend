package Applications;

import TO.ServiceTO;
import dao.ServiceDAO;
import models.Professional;
import models.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ServiceService {
    private ServiceDAO serviceDAO = new ServiceDAO();

    public ArrayList<Service> getServiceByProfessional(Professional professional){
        ArrayList<Service> services = serviceDAO.findByProfessional(professional);
        return services;
    }

    public Service getServiceById(int service_id){
        Service service = serviceDAO.findById(service_id);
        return service;
    }

    public void createService(Professional professional,ServiceTO serviceTO){
        Service service = new Service();
        service.setProfessional(professional);
        service.copy(serviceTO);
        serviceDAO.save(service);
    }

    public void updateService(ServiceTO serviceTO){
        Service service = serviceDAO.findById(serviceTO.getId());
        service.copy(serviceTO);
        serviceDAO.update(service);
    }

    public ArrayList<Service> findAll(){
        ArrayList<Service> services = serviceDAO.find();
        return services;
    }

    public void deleteService(ServiceTO serviceTO){
        Service service = serviceDAO.findById(serviceTO.getId());
        serviceDAO.delete(service);
    }
}
