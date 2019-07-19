import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    final static String FILENAME = "src/input.txt";
    public static void main(String[] args) {

        String line;
        String[] input = new String[] {};
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            while ((line = reader.readLine()) != null) {
                input = line.split("");

            }
            reader.close();

            ArrayList<String> wordList = new ArrayList<>();
            Collections.addAll(wordList, input);


            int removed = findMatches(wordList);
            while(removed != 0) {
                removed = findMatches(wordList);
            }

            System.out.println("Amount of units " + wordList.size());

        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", FILENAME);
            e.printStackTrace();
        }
    }



    public static int findMatches(ArrayList<String> input) {

        int removed = 0;

        for(int i = 0; i < input.size() - 1; i++) {
            if (isOpposite(input.get(i), input.get(i+1))) {
                input.remove(i);
                input.remove(i);
                removed += 2;
            }
        }

        return removed;
    }

    public static boolean isOpposite(String f, String s) {
        if (f.equals(s)) {
            return false;
        }

        if (f.toLowerCase().equals(s) ||
                f.toUpperCase().equals(s) ||
                f.equals(s.toLowerCase()) ||
                f.equals(s.toUpperCase())) {
            return true;
        }


        return false;
    }

}
