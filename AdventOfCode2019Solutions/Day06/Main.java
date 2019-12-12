import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
  final static String FILENAME = "puzzle.txt";

    public static HashMap<String,ArrayList<String>> orbits = new HashMap<>();

    public static void main(String[] args) {
      try {
        File myObj = new File(FILENAME);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          String[] planets = data.split("\\)");
          if (orbits.containsKey(planets[1])) {
            orbits.get(planets[1]).add(planets[0]);
          } else {
            orbits.put(planets[1], new ArrayList<>());
            orbits.get(planets[1]).add(planets[0]);
          }
        }
       
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
       
    }

   
}
