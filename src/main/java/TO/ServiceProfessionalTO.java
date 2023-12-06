package TO;

public class ServiceProfessionalTO extends ServiceTO{
    private int professional_id;

    public ServiceProfessionalTO(int id, String name, String description, String img, int price, int professional_id) {
        super(id, name, description, img, price);
        this.professional_id = professional_id;
    }

    public int getProfessional_id() {
        return professional_id;
    }

    public void setProfessional_id(int professional_id) {
        this.professional_id = professional_id;
    }
    public ServiceTO getServiceTO(){
        ServiceTO serviceTO = new ServiceTO();
        serviceTO.setId(this.getId());
        serviceTO.setDescription(this.getDescription());
        serviceTO.setName(this.getName());
        serviceTO.setPrice(this.getPrice());
        serviceTO.setImg(this.getImg());
        return serviceTO;
    }
}
