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

        ArrayList<Operation> operations = new ArrayList<>();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
                while ((line = reader.readLine()) != null) {
                    isBeforeLine = line.contains("Before");
                    isAfterLine =  line.contains("After");
                    if (!isBeforeLine && !isAfterLine) {
                        operationString = line.split(" ");
                    } else {
                        String arr = line.substring(line.indexOf("[") + 1, line.length() - 1).trim();
                        if (isBeforeLine) {
                            beforeState = arr.split("\\s*,\\s*");
                        } else {
                            afterState =  arr.split("\\s*,\\s*");
                            Operation op = new Operation(beforeState, operationString, afterState);
                            operations.add(op);
                        }

                    }

                }

                reader.close();


            } catch (Exception e) {
                System.err.format("Exception occurred trying to read '%s'.", FILENAME);
                e.printStackTrace();
            }
        }
    }
