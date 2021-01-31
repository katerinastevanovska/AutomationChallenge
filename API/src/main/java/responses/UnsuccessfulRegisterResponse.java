package responses;

/**
 * Created by katerina on 1/31/21.
 */
public class UnsuccessfulRegisterResponse {
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    String error;
}
