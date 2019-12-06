import java.util.HashMap;

public class Main {

    static int lowerRange = 356261;
    static int upperRange = 846303;
    
    public static void main(String[] args) {
      int amountOfValidNumbers = 0;
        for(int i = lowerRange; i <= upperRange; i++) {
          if (isValidNumber(i)) {
            amountOfValidNumbers++;
          }
        }

        System.out.println("Amount is " + amountOfValidNumbers);
    }

    public static boolean isValidNumber(int number) {
      boolean answer = false;
      if (containsOnlyTwoAdjacentDigits(number) &&
          digitsIncrease(number)) {
            answer = true;
          }

      return answer;
    }

    public static boolean containsOnlyTwoAdjacentDigits(int number) {
      String numberAsString = String.valueOf(number);
      if (!containsMatchingDigits(numberAsString)) {
        return false;
      }

      HashMap<Character, Integer> result = mapOutMatchingDigits(numberAsString);

      for (Character key : result.keySet()) {
        if(result.get(key) == 2) {
          return true;
        }
      }

      return false;
    }

    public static HashMap<Character, Integer> mapOutMatchingDigits(String number) {
      HashMap<Character, Integer> amount = new HashMap<>();
      int occurrences = 1;
      for(int i = 0; i < number.length() - 1; i++) {
        if (number.charAt(i) == number.charAt(i+1)) {
          occurrences++;
        } else {
          amount.put(number.charAt(i), occurrences);
          occurrences = 1;
        }
      }
      amount.put(number.charAt(number.length() - 1), occurrences);
     
      return amount;
    }

    public static boolean containsMatchingDigits(String number) {
      for(int i = 0; i < number.length() - 1; i++) {
        if (number.charAt(i) == number.charAt(i+1)) {
          return true;
        }
      }

      return false;
    }


    public static boolean containsTwoAdjacentsDigits(int number) {
      String numberAsString = String.valueOf(number);
      for(int i = 0; i < numberAsString.length() - 1; i++) {
        if (numberAsString.charAt(i) == numberAsString.charAt(i+1)) {
          return true;
        }
      }

      return false;
    }

    public static boolean digitsIncrease(int number) {
      String numberAsString = String.valueOf(number);
      for(int i = 0; i < numberAsString.length() - 1; i++) {
        if (Integer.valueOf(numberAsString.charAt(i)) > Integer.valueOf(numberAsString.charAt(i+1))) {
          return false;
        }
    }

    return true;
  }

}
