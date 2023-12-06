package TO;

import models.Professional;
import models.User;

public class ProfRegister {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String confirmPassword;
    private int profession_id;

    public ProfRegister(String first_name, String last_name, String email, String password, String confirmPassword) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getProfession_id() {
        return profession_id;
    }

    public void setProfession_id(int profession_id) {
        this.profession_id = profession_id;
    }

    public void copyToProfessional(Professional professional){
        professional.setFirst_name(this.first_name);
        professional.setLast_name(this.last_name);
        professional.setEmail(this.email);
        professional.setPassword(this.password);
    }

    public void copyToUser(User user){
        user.setFirst_name(this.first_name);
        user.setLast_name(this.last_name);
        user.setEmail(this.email);
        user.setPassword(this.password);
    }
}
