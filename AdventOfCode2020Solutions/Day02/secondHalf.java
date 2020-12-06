import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        int validPasswords = 0;
        int lowIndex = 0;
        int highIndex = 0;
        String letter = "";
        String password = "";
        Pattern pattern1 = Pattern.compile("\\d+-\\d+", Pattern.CASE_INSENSITIVE);
        Pattern pattern2 = Pattern.compile("\\s\\w", Pattern.CASE_INSENSITIVE);
        Pattern pattern3 = Pattern.compile(":\\s\\w*", Pattern.CASE_INSENSITIVE);


        try {
            File file = new File("puzzle.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Matcher matcher = pattern1.matcher(data);
                if (matcher.find()) {
                    String range = matcher.group(0);
                    int indexOfLine = range.indexOf("-");
                    lowIndex = Integer.parseInt(range.substring(0, indexOfLine));
                    highIndex = Integer.parseInt(range.substring(indexOfLine+1));
                }
                matcher = pattern2.matcher(data);
                if (matcher.find()) {
                    letter = matcher.group(0).trim();
                }

                matcher = pattern3.matcher(data);
                if (matcher.find()) {
                    password = matcher.group(0).substring(2);
                }

                char[] letters = password.toCharArray();
                char[] letters2 = letter.toCharArray();
                if (letters[lowIndex - 1] == letters2[0] && letters[highIndex - 1] != letters2[0]) {
                    validPasswords++;
                } else if (letters[lowIndex - 1] != letters2[0] && letters[highIndex - 1] == letters2[0]) {
                    validPasswords++;
                }

            }

            System.out.println(validPasswords);
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }


}