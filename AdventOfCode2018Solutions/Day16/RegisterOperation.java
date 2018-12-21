public class RegisterOperation {

    private int id;
    private int sourceRegister;
    private int secondSourceRegister;
    private int resultRegister;

    public RegisterOperation(int _id, int source, int secondSource, int result) {
        id = _id;
        sourceRegister = source;
        secondSourceRegister = secondSource;
        resultRegister = result;
    }

    public int getSourceRegister() {
        return sourceRegister;
    }

    public int getSecondSourceRegister() {
        return secondSourceRegister;
    }

    public int getResultRegister() {
        return resultRegister;
    }



}
