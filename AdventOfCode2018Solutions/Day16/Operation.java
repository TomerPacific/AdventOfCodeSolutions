public class Operation {

    private String[] beforeState;
    private RegisterOperation operation;
    private String[] afterState;

    public Operation(String[] before, RegisterOperation op, String[] after) {
        beforeState = before;
        operation = op;
        afterState = after;
    }

    public String[] getBeforeState() {
        return beforeState;
    }

}
