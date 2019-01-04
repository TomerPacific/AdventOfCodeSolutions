import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {

    final static String FILENAME = "src/input.txt";

    public static void main(String[] args) {


        String line;
        Register mainRegister = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            while ((line = reader.readLine()) != null) {
                    if (line.contains("#")) {
                        mainRegister = new Register(Integer.parseInt(line.substring(line.indexOf(" ")).trim()), 0);
                    } else {
                        String[] words = line.split(" ");
                        int updatedValue = executeCommand(words[0], words[1], words[2], words[3], mainRegister);
                        mainRegister.setValue(updatedValue);
                    }

            }
            reader.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", FILENAME);
            e.printStackTrace();
        }

    } // end main

    private static int executeCommand(String command, String firstArg, String secondArg, String thirdArg, Register register) {


        return -1;
    }

}

