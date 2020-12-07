import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        final Integer YEAR = 2020;
        try {
            File file = new File("puzzle.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Integer number = Integer.parseInt(data);
                numbers.add(number);
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for(int i = 0; i < numbers.size(); i++) {
            for (int j = i+1; j < numbers.size(); j++) {
                for (int k = j+1; k < numbers.size(); k++) {
                    if (numbers.get(i) + numbers.get(j) + numbers.get(k) == YEAR) {
                        System.out.println("Product is " + numbers.get(i) * numbers.get(j) * numbers.get(k));
                    }
                }
            }
        }
    }


}