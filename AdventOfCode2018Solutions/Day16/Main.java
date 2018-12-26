import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {

    final static String FILENAME = "src/input.txt";

    public static void main(String[] args) {


        String line;
        String[] operationString = null;
        int[] beforeState = null;
        int[] afterState = null;
        boolean isBeforeLine = false;
        boolean isAfterLine = false;
        RegisterOperation registerOperation = null;

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
//                if (isGreaterThan(op)) {
//                    result++;
//                }
//                if (isEqual(op)) {
//                    result++;
//                }

                return (result >= 3);
           }

           private static boolean isAddition(Operation op) {
                int[] registersStateBefore = op.getBeforeState();
                RegisterOperation registerOperation = op.getRegisterOperation();
                int[] registersStateAfter = op.getAfterState();

                int sourceRegister = registerOperation.getSourceRegister();
                int secondSourceRegister = registerOperation.getSecondSourceRegister();
                int resultRegister = registerOperation.getResultRegister();

                //addi
               if (registersStateBefore[sourceRegister] + secondSourceRegister
                       == registersStateAfter[resultRegister]) {
                    return true;
               }
               // addr
               else if (registersStateBefore[sourceRegister] + registersStateBefore[secondSourceRegister]
                       == registersStateAfter[resultRegister]) {
                    return true;
               }

               return false;
           }

        private static boolean isMultiplication(Operation op) {
            int[] registersStateBefore = op.getBeforeState();
            RegisterOperation registerOperation = op.getRegisterOperation();
            int[] registersStateAfter = op.getAfterState();

            int sourceRegister = registerOperation.getSourceRegister();
            int secondSourceRegister = registerOperation.getSecondSourceRegister();
            int resultRegister = registerOperation.getResultRegister();

            //muli
            if (registersStateBefore[sourceRegister] * secondSourceRegister
                    == registersStateAfter[resultRegister]) {
                return true;
            }
            // mulr
            else if (registersStateBefore[sourceRegister] * registersStateBefore[secondSourceRegister]
                    == registersStateAfter[resultRegister]) {
                return true;
            }

            return false;
        }

        private static boolean isAnd(Operation op) {
            int[] registersStateBefore = op.getBeforeState();
            RegisterOperation registerOperation = op.getRegisterOperation();
            int[] registersStateAfter = op.getAfterState();

            int sourceRegister = registerOperation.getSourceRegister();
            int secondSourceRegister = registerOperation.getSecondSourceRegister();
            int resultRegister = registerOperation.getResultRegister();

            //bori
            int result = registersStateBefore[sourceRegister] & secondSourceRegister;
            if (result == registersStateAfter[resultRegister]) {
                return true;
            }
            // borr
            result = registersStateBefore[sourceRegister] & registersStateBefore[secondSourceRegister];
            if (result == registersStateAfter[resultRegister]) {
                return true;
            }


            return false;
        }

        private static boolean isOr(Operation op) {
            int[] registersStateBefore = op.getBeforeState();
            RegisterOperation registerOperation = op.getRegisterOperation();
            int[] registersStateAfter = op.getAfterState();

            int sourceRegister = registerOperation.getSourceRegister();
            int secondSourceRegister = registerOperation.getSecondSourceRegister();
            int resultRegister = registerOperation.getResultRegister();

            //bani
            int result = registersStateBefore[sourceRegister] | secondSourceRegister;
            if (result == registersStateAfter[resultRegister]) {
                return true;
            }
            // banr
            result = registersStateBefore[sourceRegister] | registersStateBefore[secondSourceRegister];
            if (result == registersStateAfter[resultRegister]) {
                return true;
            }


            return false;
        }

        private static boolean isAssignment(Operation op) {
            int[] registersStateBefore = op.getBeforeState();
            RegisterOperation registerOperation = op.getRegisterOperation();
            int[] registersStateAfter = op.getAfterState();

            int sourceRegister = registerOperation.getSourceRegister();
            int secondSourceRegister = registerOperation.getSecondSourceRegister();
            int resultRegister = registerOperation.getResultRegister();

            //seti
            if (registersStateAfter[resultRegister] == sourceRegister) {
                return true;
            }
            //setr
            if (registersStateBefore[sourceRegister] == registersStateAfter[resultRegister]) {
                return true;
            }
            return false;
        }

       private static int[] convertElementsToInt(String[] arr) {
            int[] intArr = new int[arr.length];
            for(int i = 0; i < arr.length; i++) {
                intArr[i] = Integer.parseInt(arr[i]);
            }
            return intArr;
       }
    }
