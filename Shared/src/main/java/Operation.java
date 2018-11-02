import java.util.StringJoiner;

public class Operation {

    private String operator;
    private String operande;

    public Operation(String operator, String operande) {
        this.operator = operator;
        this.operande = operande;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperande() {
        return operande;
    }

    public void setOperande(String operande) {
        this.operande = operande;
    }
}
