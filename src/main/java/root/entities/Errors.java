package error;

public class Errors {
    private String errorMessage;
    private Integer errorNumber;

    public Errors(){
        this.setErrorMessage("");
        this.setErrorNumber(0);
    }

    public Errors(Integer errorNumber, String errorMessage){
        this.setErrorMessage(errorMessage);
        this.setErrorNumber(errorNumber);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(Integer errorNumber) {
        this.errorNumber = errorNumber;
    }
}
