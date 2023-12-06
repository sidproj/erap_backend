package TO;

public class ErrorTO {
    private String message;
    private String code;

    public ErrorTO(String msg, String code){
        this.setMessage(msg);
        this.setCode(code);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
