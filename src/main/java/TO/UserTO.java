package TO;

import models.User;

public class UserTO {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String jwt;

    public UserTO(User user){
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setFirst_name(user.getFirst_name());
        this.setLast_name(user.getLast_name());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
