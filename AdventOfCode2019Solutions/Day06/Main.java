import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
  final static String FILENAME = "puzzle.txt";

    public static ArrayList<Planet> planets = new ArrayList()<>();

    public static void main(String[] args) {
      try {
        File myObj = new File(FILENAME);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          String[] planets = data.split("\\)");
          Planet orbiting = new Planet(planets[1]);
          Planet orbitted = new Planet(planets[0]);
          orbitted.addOrbitingPlanet(orbiting);
        }
       
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
       
    }

   
}
