import java.util.List;

public class ResultOfTaskComputing {

    private int finalResult;
    private List<Task> notComputedTask;

    public ResultOfTaskComputing(int finalResult, List<Task> notComputedTask) {
        this.finalResult = finalResult;
        this.notComputedTask = notComputedTask;
    }

    public int getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(int finalResult) {
        this.finalResult = finalResult;
    }

    public List<Task> getNotComputedTask() {
        return notComputedTask;
    }

    public void setNotComputedTask(List<Task> notComputedTask) {
        this.notComputedTask = notComputedTask;
    }
}
