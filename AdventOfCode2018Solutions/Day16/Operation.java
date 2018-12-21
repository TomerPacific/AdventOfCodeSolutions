public class Operation {

    private int[] beforeState;
    private RegisterOperation operation;
    private int[] afterState;

    public Operation(int[] before, RegisterOperation op, int[] after) {
        beforeState = before;
        operation = op;
        afterState = after;
    }

    public int[] getBeforeState() {
        return beforeState;
    }

    public RegisterOperation getRegisterOperation() {
        return operation;
    }

    public int[] getAfterState() {
        return afterState;
    }
}
