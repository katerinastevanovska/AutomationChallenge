package responses;

/**
 * Created by katerina on 1/31/21.
 */
public class SuccessfullRegisterResponse {

    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    String token;
}
