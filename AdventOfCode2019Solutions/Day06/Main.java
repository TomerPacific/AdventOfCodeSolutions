import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
  final static String FILENAME = "puzzle.txt";

    public static ArrayList<Planet> orbitingPlanets = new ArrayList();

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
          orbitingPlanets.add(orbiting);
          orbitingPlanets.add(orbitted);
        }

        findIndirectOrbits(orbitingPlanets);
       
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
       
    }

    public static void findIndirectOrbits(ArrayList<Planet> planets) {

      for (int i = 0; i < planets.size(); i++) {
        Planet planetOrbit = planets.get(i);
        for (int j = i+1; j < planets.size(); j++) {
          Planet planetOrbitted = planets.get(j);
          if (planetOrbitted.isBeingOrbitted(planetOrbit)) {
            
          }
        }
      }
    }

   
}
