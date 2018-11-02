import java.util.List;

public class Task {

    private List<Operation> operations;

    public Task(){}

    public Task(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }



}
