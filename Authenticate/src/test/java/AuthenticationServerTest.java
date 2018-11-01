import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthenticationServerTest {

    @Test
    public void isAuthenticated() {
        Client cli = new Client("pmk", "passer");
        AuthenticationServer authS = new AuthenticationServer();

        Assert.assertEquals(true, authS.isAuthenticated(cli));
    }

    @Test
    public void registerClient() {
        Client cli = new Client("pmk", "passer");
        AuthenticationServer authS = new AuthenticationServer();

        Assert.assertEquals(cli.getLogin() + " well registered", authS.registerClient(cli));

    }
}