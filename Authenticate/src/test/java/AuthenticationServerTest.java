import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AuthenticationServerTest {

    @Test
    public void isAuthenticated() {
        Client cli = new Client("pmk", "passer");
        Client cli2 = new Client("P", "passer");
        Client cli3 = new Client("pmk", "passe");
        Client cli4 = new Client("P", "passe");
        AuthenticationServer authS = new AuthenticationServer();

        Assertions.assertEquals(true, authS.isAuthenticated(cli));
        Assertions.assertEquals(false, authS.isAuthenticated(cli2));
        Assertions.assertEquals(false, authS.isAuthenticated(cli3));
        Assertions.assertEquals(false, authS.isAuthenticated(cli4));
    }

    @Test
    public void registerClient() {
        Client cli = new Client("pm", "passer");
        AuthenticationServer authS = new AuthenticationServer();
        if(authS.isAuthenticated(cli) ){
            Assertions.assertEquals(cli.getLogin() + " already exists", authS.registerClient(cli));
        } else {
            Assertions.assertEquals(cli.getLogin() + " well registered", authS.registerClient(cli));
        }
    }
}