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
              Double fuelForMass = calculateOverallFuelForMass(mass);
              overallFuelRequirement += fuelForMass;
            }
            System.out.println("Overall " + overallFuelRequirement);
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }

  private static Double calculateOverallFuelForMass(Double mass) {
    
    Double result = 0.0;
    Double fuel;
    while(mass > 0) {
      fuel = Math.floor(mass / 3) - 2;
      if (fuel > 0) {
        result += fuel;
      }
      
      mass = fuel;
    }
   
    return result;
  }

}
