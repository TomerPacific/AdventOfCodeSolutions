public class Operation {

    private String[] beforeState;
    private String[] operation;
    private String[] afterState;

    public Operation(String[] before, String[] op, String[] after) {
        beforeState = before;
        operation = op;
        afterState = after;
    }

}
