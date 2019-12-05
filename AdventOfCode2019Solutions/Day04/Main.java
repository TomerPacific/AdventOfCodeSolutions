
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
      if (containsTwoAdjacentsDigits(number) &&
          digitsIncrease(number)) {
            answer = true;
          }

      return answer;
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
