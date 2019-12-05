import java.io.File;  
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final static String FILENAME = "puzzle.txt";
    
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        ArrayList<Integer> originalInput = null;

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
            originalInput = new ArrayList<>(input);
            findSolution(input, originalInput);
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    private static void findSolution(ArrayList<Integer> data, ArrayList<Integer> originalData) {

      for (int noun = 0; noun <= 99; noun++) {
        for (int verb = 0; verb <= 99; verb++) {
          data.set(1, noun);
          data.set(2, verb);
          System.out.println("Finding solution for noun " + noun + " and verb " + verb);
          calculateOpCodes(data);
          data = new ArrayList<Integer>(originalData);
        }
      }
    }

    private static void calculateOpCodes(ArrayList<Integer> input) {
      Integer firstNumber, secondNumber, placement;
      boolean isOp99 = false;
      for(int i = 0; i < input.size() && !isOp99; i+=4) {
        Integer operation = input.get(i);
        switch(operation) {
          case 1:
            firstNumber = input.get(i+1);
            secondNumber = input.get(i+2);
            placement = input.get(i+3);
            Integer sum = input.get(firstNumber) + input.get(secondNumber);
            input.set(input.get(placement), sum);
            break;
          case 2:
            firstNumber = input.get(i+1);
            secondNumber = input.get(i+2);
            placement = input.get(i+3);
            Integer multiplication = input.get(firstNumber) * input.get(secondNumber);
            input.set(input.get(placement), multiplication);
            break;
          case 99:
            isOp99 = true;
            break;
        }
      }
      int solution = input.get(1);
      if (solution == 19690720) {
        System.out.println("Found solution!!!");
      }
    }

}
