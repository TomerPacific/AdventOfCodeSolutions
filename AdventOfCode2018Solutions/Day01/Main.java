import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    final static String FILENAME = "src/input.txt";
    public static void main(String[] args) {

        String line;
        Integer sum = 0;
        Boolean notFound = false;
        ArrayList<Integer> frequencies = new ArrayList<Integer>();

        while (!notFound) {
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(FILENAME));

                while ((line = reader.readLine()) != null)
                {
                    Character sign = line.charAt(0);
                    if (sign == '+') {
                        sum += Integer.parseInt(line.substring(1));
                    } else {
                        sum -= Integer.parseInt(line.substring(1));
                    }

                    if (frequencies.contains(sum)) {
                        System.out.println("Already seen frequency " + sum);
                        notFound = true;
                        break;
                    } else {
                        frequencies.add(sum);
                    }

                }
                reader.close();
                System.out.println("Resulting frequency is " + sum);
            }
            catch (Exception e)
            {
                System.err.format("Exception occurred trying to read '%s'.", FILENAME);
                e.printStackTrace();
            }
        }

    }
}
