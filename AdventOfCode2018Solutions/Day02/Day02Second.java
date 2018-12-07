import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    final static String FILENAME = "src/input.txt";
    public static void main(String[] args) {

        String line;
        ArrayList<String> codes = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            while ((line = reader.readLine()) != null) {
                codes.add(line);
            }
            reader.close();
            int amountOfDifferences = 0;
            for(int i = 0; i < codes.size() - 1; i++) {
                String firstCode = codes.get(i);
                for (int j = i+1; j < codes.size(); j++) {
                    String secondCode = codes.get(j);
                    for(int k = 0; k < firstCode.length(); k++) {
                        if (firstCode.charAt(k) != secondCode.charAt(k)) {
                            amountOfDifferences++;
                        }
                    }
                    if (amountOfDifferences == 1) {
                        System.out.println("Found two strings that differ by one letter " + firstCode + " " + secondCode);
                        return;
                    }
                    amountOfDifferences = 0;
                }
            }

        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", FILENAME);
            e.printStackTrace();
        }
    }
}
