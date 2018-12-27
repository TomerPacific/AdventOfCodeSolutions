import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {

    final static String FILENAME = "src/input.txt";
    private static OperationUtils operationUtils;

    public static void main(String[] args) {


        String line;
        String[] operationString = null;
        int[] beforeState = null;
        int[] afterState = null;
        boolean isBeforeLine = false;
        boolean isAfterLine = false;
        RegisterOperation registerOperation = null;
        operationUtils = new OperationUtils();

        ArrayList<Operation> operations = new ArrayList<>();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
                while ((line = reader.readLine()) != null) {

                    if (line.isEmpty()) {
                        continue;
                    }
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
                            beforeState = convertElementsToInt(arr.split("\\s*,\\s*"));

                        } else {
                            afterState =  convertElementsToInt(arr.split("\\s*,\\s*"));
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

            private static int[] convertElementsToInt(String[] arr) {
                int[] intArr = new int[arr.length];
                for(int i = 0; i < arr.length; i++) {
                    intArr[i] = Integer.parseInt(arr[i]);
                }
                return intArr;
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

               int[] registersStateBefore = op.getBeforeState();
               RegisterOperation registerOperation = op.getRegisterOperation();
               int[] registersStateAfter = op.getAfterState();

               int sourceRegister = registerOperation.getSourceRegister();
               int secondSourceRegister = registerOperation.getSecondSourceRegister();
               int resultRegister = registerOperation.getResultRegister();

                result += operationUtils.isAddition(registersStateBefore, registersStateAfter, sourceRegister, secondSourceRegister, resultRegister);

                result += operationUtils.isMultiplication(registersStateBefore, registersStateAfter, sourceRegister, secondSourceRegister, resultRegister);

                result += operationUtils.isAnd(registersStateBefore, registersStateAfter, sourceRegister, secondSourceRegister, resultRegister);

               result += operationUtils.isOr(registersStateBefore, registersStateAfter, sourceRegister, secondSourceRegister, resultRegister);

               result += operationUtils.isAssignment(registersStateBefore, registersStateAfter, sourceRegister, resultRegister);

               result += operationUtils.isGreaterThan(registersStateBefore, registersStateAfter, sourceRegister, secondSourceRegister, resultRegister);

               result += operationUtils.isEqual(registersStateBefore, registersStateAfter, sourceRegister, secondSourceRegister, resultRegister);


                return (result >= 3);
           }
    }
