import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class Main {

    final static String FILENAME = "puzzle.txt";
    
    public static void main(String[] args) {
        Double overallFuelRequirement = 0.0;

        try {
            File myObj = new File(FILENAME);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              Double mass = Double.valueOf(data);
              mass = Math.floor(mass / 3) - 2;
              overallFuelRequirement += mass;
            }
            System.out.println("Overall " + overallFuelRequirement);
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }
}
