import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {

    final static String FILENAME = "src/input.txt";

    public static void main(String[] args) {


        String line;
        Register mainRegister;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            while ((line = reader.readLine()) != null) {
                    if (line.contains("#")) {
                        mainRegister = new Register(Integer.parseInt(line.substring(line.indexOf(""))), 0);
                    } else {
                        
                    }

            }
            reader.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", FILENAME);
            e.printStackTrace();
        }

    }

}

