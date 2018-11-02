import java.io.*;
import java.nio.file.*;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AuthenticationServer {

    public final String AUTH_FILE_PATH = "c:\\dev\\data\\authenticationFile.txt";

    /**
     *
     * @param client : the ones we want to verify
     * @return an authentication status True or False
     */
    public boolean isAuthenticated(Client client){
        return this.checkIfExist(client);
    }

    /**
     *
     * @param client the one we wanna register
     * @return a string to informs whether the registration succeeded or not
     */
    public String registerClient(Client client){
        return this.saveClient(client);
    }


    /* Util methods */

    public String saveClient(Client client){

        StringJoiner status = new StringJoiner(" ");
        StringJoiner cInfos = new StringJoiner(":").add(client.getLogin()).add(client.getPassword());
        Path path = Paths.get(this.AUTH_FILE_PATH);
        if (!this.checkIfExist(client)){
            try {
                PrintWriter printWriter = new PrintWriter(new FileWriter(this.AUTH_FILE_PATH, true));
                printWriter.println(cInfos);
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            status.add(client.getLogin()).add("well registered");
        }else {
            status.add(client.getLogin()).add("already exists");
        }
        return status.toString() ;
    }


    public boolean checkIfExist(Client client){
        boolean isPresentOrNot = false;
        StringJoiner clientInfos = new StringJoiner(":").add(client.getLogin()).add(client.getPassword());
        Predicate<String> predicate = s -> s.equals(clientInfos.toString());
        Path path = Paths.get(this.AUTH_FILE_PATH);
        try(Stream<String> stream = Files.lines(path)){
            isPresentOrNot =  stream.filter(line -> line.contains(clientInfos.toString()))
                                    .anyMatch(predicate);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isPresentOrNot;
    }

}
