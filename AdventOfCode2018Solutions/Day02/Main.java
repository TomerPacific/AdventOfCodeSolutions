import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    final static String FILENAME = "src/input.txt";
    public static void main(String[] args) {

        String line;
        ArrayList<String> lettersChecked = new ArrayList<String>();
        Integer doubleApperance = 0;
        Integer tripleApperance = 0;
        Boolean alreadySeenDouble = false;
        Boolean alreadySeenTriple = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));

            while ((line = reader.readLine()) != null) {
                   for (int i = 0; i < line.length(); i++) {
                       String letter = Character.toString(line.charAt(i));
                       if (lettersChecked.contains(letter)) {
                           continue;
                       }
                       lettersChecked.add(letter);
                       int matches = line.replace(letter, "-1").length() - line.length();
                       if (matches == 2 && !alreadySeenDouble) {
                           doubleApperance++;
                           alreadySeenDouble = true;
                       } else if (matches == 3 && !alreadySeenTriple) {
                           tripleApperance++;
                           alreadySeenTriple = true;
                       }
                   }
                lettersChecked.clear();
                alreadySeenDouble = false;
                alreadySeenTriple = false;
            }
            reader.close();
            System.out.println("Amount of double " + doubleApperance + " amount of triple " + tripleApperance);
            System.out.println("Multiply " + doubleApperance * tripleApperance);
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", FILENAME);
            e.printStackTrace();
        }
    }
}
