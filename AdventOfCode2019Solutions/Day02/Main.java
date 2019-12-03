import java.io.File;  
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final static String FILENAME = "puzzle.txt";
    
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>();

        try {
            File myObj = new File(FILENAME);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              String[] split = data.split(",");
              for(int index = 0; index < split.length; index++) {
                input.add(Integer.valueOf(split[index]));
              }
            }
            System.out.println(input.toString());
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }

}
