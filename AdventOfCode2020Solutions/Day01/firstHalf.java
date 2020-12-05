import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer, Integer> numbers = new HashMap<>();
        final Integer YEAR = 2020;
        try {
            File file = new File("puzzle.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Integer number = Integer.parseInt(data);
                if (numbers.containsKey(YEAR - number)) {
                    System.out.println("The two numbers who sum up to 2020 are: " + number + " " + (YEAR - number));
                    System.out.println("Their multiplication is " + number * (YEAR - number));

                } else {
                    numbers.put(number, number);
                }
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}