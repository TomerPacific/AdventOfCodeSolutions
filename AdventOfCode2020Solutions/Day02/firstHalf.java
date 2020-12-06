import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        int validPasswords = 0;
        int minOccur = 0;
        int maxOccur = 0;
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
                    minOccur = Integer.parseInt(range.substring(0, indexOfLine));
                    maxOccur = Integer.parseInt(range.substring(indexOfLine+1));
                }
                matcher = pattern2.matcher(data);
                if (matcher.find()) {
                    letter = matcher.group(0).trim();
                }

                matcher = pattern3.matcher(data);
                if (matcher.find()) {
                    password = matcher.group(0).substring(2);
                }

                int occur = 0;
                for (int i = 0; i < password.length(); i++) {
                    if (password.substring(i,i+1).equals(letter)) {
                        occur++;
                    }
                }

                if (occur >= minOccur && occur <= maxOccur) {
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