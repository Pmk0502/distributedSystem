import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputingServer {

    private Server server;

    public ComputingServer(){
        server = new Server();
    }

    public ResultOfTaskComputing computeTask(List<Task> tasks){

        List<Integer> result = new ArrayList<>();
        List<Task> notComputedTasks = new ArrayList<>();

        for (Task task : tasks){
            if (allocateResource(task)){
                task.getOperations().forEach(
                        (operation) -> {
                            if (operation.getOperator().equals("prime"))
                                result.add(this.prime(Integer.parseInt(operation.getOperande())));
                            else
                                result.add(this.pell(Integer.parseInt(operation.getOperande())));
                        }
                );
            }else {
                notComputedTasks.add(task);
            }
        }
        Optional<Integer> finalResult =  result.stream().reduce((a, b) -> a%4000 + b);

        return (new ResultOfTaskComputing(finalResult.orElse(0), notComputedTasks));
    }

    public boolean allocateResource(Task task){
        if(this.server.getCapacity() >= task.getOperations().size())
            return true;
        else
            return false;
    }

    public int prime(int operande){
        int highestPrime = 0;
        for (int i=1; i<operande; ++i){
            if (isPrime(i) && operande%i == 0 && i > highestPrime)
                highestPrime = i;
        }
        return highestPrime;
    }

    public int pell(int operande){
        if (operande == 0)
            return 0;
        else if (operande == 1)
            return 1;
        return 2 * pell(operande - 1) + pell(operande - 2);
    }

    public boolean isPrime(int operande){
        if (operande<=1)
            return false;
        for (int i=2; i<operande; ++i){
            if (operande%i == 0)
                return false;
        }
        return true;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
