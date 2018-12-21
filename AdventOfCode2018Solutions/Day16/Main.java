import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {

    final static String FILENAME = "src/input.txt";

    public static void main(String[] args) {


        String line;
        String[] operationString = null;
        String[] beforeState = null;
        String[] afterState = null;
        boolean isBeforeLine = false;
        boolean isAfterLine = false;
        RegisterOperation registerOperation = null;

        ArrayList<Operation> operations = new ArrayList<>();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
                while ((line = reader.readLine()) != null) {
                    isBeforeLine = line.contains("Before");
                    isAfterLine =  line.contains("After");
                    if (!isBeforeLine && !isAfterLine) {
                        operationString = line.split(" ");
                        registerOperation = new RegisterOperation(Integer.parseInt(operationString[0]),
                                                                  Integer.parseInt(operationString[1]),
                                                                  Integer.parseInt(operationString[2]),
                                                                  Integer.parseInt(operationString[3]));
                    } else {
                        String arr = line.substring(line.indexOf("[") + 1, line.length() - 1).trim();
                        if (isBeforeLine) {
                            beforeState = arr.split("\\s*,\\s*");
                        } else {
                            afterState =  arr.split("\\s*,\\s*");
                            Operation op = new Operation(beforeState, registerOperation, afterState);
                            operations.add(op);
                            isBeforeLine = false;
                            isAfterLine = false;
                        }

                    }
                }
                reader.close();
            } catch (Exception e) {
                System.err.format("Exception occurred trying to read '%s'.", FILENAME);
                e.printStackTrace();
            }

                findOperations(operations);
           }


           private static void findOperations(ArrayList<Operation> operations) {

                int countBehavesLikeThree = 0;
                for (int i = 0; i < operations.size(); i++) {
                    Operation op = operations.get(i);
                    if (behavesLikeThree(op)) {
                        countBehavesLikeThree++;
                    }
                }
           }

           private static boolean behavesLikeThree(Operation op) {
                int result = 0;
                if (isAddition(op)) {
                    result++;
                }
                if (isMultiplication(op)) {
                    result++;
                }
                if (isAnd(op)) {
                    result++;
                }
                if (isOr(op)) {
                    result++;
                }
                if (isAssignment(op)) {
                    result++;
                }
                if (isGreaterThan(op)) {
                    result++;
                }
                if (isEqual(op)) {
                    result++;
                }

                return (result >= 3);
           }
    }
