package TO;

import models.Service;

import java.util.ArrayList;

public class ServiceTO {
    protected int id;
    protected String name;
    protected String description;
    protected String img;
    protected int price;

    public ServiceTO(){}

    public ServiceTO(int id, String name, String description, String img, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.price = price;
    }

    public ServiceTO(Service service){
        this.id = service.getId();
        this.name = service.getName();
        this.description = service.getDescription();
        this.price = service.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static ArrayList<ServiceTO> fromServices(ArrayList<Service> services){
        ArrayList<ServiceTO> serviceTOS = new ArrayList<>();

        for(Service service : services){
            serviceTOS.add(new ServiceTO(service));
        }
        return serviceTOS;
    }
}
