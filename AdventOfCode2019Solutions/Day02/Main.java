import java.io.File;  
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final static String FILENAME = "puzzle.txt";
    final static Integer SOLUTION = 19690720;
    final static Integer NUMBER_LIMIT = 99;
    
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

      for (int noun = 0; noun <= NUMBER_LIMIT; noun++) {
        for (int verb = 0; verb <= NUMBER_LIMIT; verb++) {
          data.set(1, noun);
          data.set(2, verb);
          calculateOpCodes(data);
          data = new ArrayList<Integer>(originalData);
        }
      }
    }

    private static void calculateOpCodes(ArrayList<Integer> input) {
      Integer firstNumber, secondNumber, placement, result;
      boolean isOp99 = false;
      for(int i = 0; i < input.size() - 3 && !isOp99; i+=4) {
        Integer operation = input.get(i);
        switch(operation) {
          case 1:
            firstNumber = input.get(i+1);
            secondNumber = input.get(i+2);
            placement = input.get(i+3);
            if (firstNumber < input.size() && secondNumber < input.size() && placement < input.size()) {
              Integer sum = input.get(firstNumber) + input.get(secondNumber);
              result = input.get(placement);
              if (result >= 0 && result <= input.size()) {
                input.set(result, sum);
              }
            }
            break;
          case 2:
            firstNumber = input.get(i+1);
            secondNumber = input.get(i+2);
            placement = input.get(i+3);
            if (firstNumber < input.size() && secondNumber < input.size() && placement < input.size()) {
              Integer multiplication = input.get(firstNumber) * input.get(secondNumber);
              result = input.get(placement);
              if (result >= 0 && result <= input.size()) {
                input.set(result, multiplication);
              }
            }
            
            break;
          case 99:
            isOp99 = true;
            break;
        }
      }
      int solution = input.get(1);
      if (solution == SOLUTION) {
        System.out.println("Found solution!!!");
      }
    }

}
