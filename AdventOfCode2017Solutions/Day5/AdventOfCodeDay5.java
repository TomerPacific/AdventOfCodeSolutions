package adventofcodeday5;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Tomer Ben Rachel
 * Created December 6th, 2017 
 */
public class AdventOfCodeDay5 {

    final static String FILENAME = "puzzle.txt";
    public static void main(String[] args) {

        int countSteps = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            String line;
            int size = 0;
            //calculate size of puzzle input
            while ((line = reader.readLine()) != null)
            {
                size++;
            }
            reader.close();
            
            int[] puzzleInput = new int[size];
            int indexInPuzzleInput = 0;
            BufferedReader reader2 = new BufferedReader(new FileReader(FILENAME));
            while ((line = reader2.readLine()) != null)
            {
                puzzleInput[indexInPuzzleInput] = Integer.parseInt(line);
                indexInPuzzleInput++;
            }
            reader2.close();
            
            indexInPuzzleInput = 0;
            while(indexInPuzzleInput >= 0 && indexInPuzzleInput < puzzleInput.length){
              int step = puzzleInput[indexInPuzzleInput];
              int previousPosition = indexInPuzzleInput;
              indexInPuzzleInput += step;
              if(puzzleInput[previousPosition] >= 3){
                  puzzleInput[previousPosition]-= 1;
              }
              else{
                   puzzleInput[previousPosition] += 1;
              }

              countSteps++;
            }
      System.out.println("Amount of steps " + countSteps);
      }
      catch (Exception e)
      {
        System.err.format("Exception occurred trying to read '%s'.", FILENAME);
        e.printStackTrace();
      }
    }
    
}
