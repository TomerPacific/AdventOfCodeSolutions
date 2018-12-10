import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;


public class Main {

    final static String FILENAME = "src/input.txt";

    public static void main(String[] args) {

//[1518-05-12 00:46] wakes up
//        [1518-07-16 00:00] Guard #3209 begins shift
//        [1518-06-13 00:02] falls asleep



        String line;
        ArrayList<Patrol> guardOrder = new ArrayList<>();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
                while ((line = reader.readLine()) != null) {
                    String date = line.substring(line.indexOf('-')+1, line.indexOf(' '));
                    String hour = line.substring(line.indexOf(' ')+1, line.indexOf(':'));
                    String minute = line.substring(line.indexOf(':')+1, line.indexOf(']'));
                    String message = line.substring(line.indexOf(']')+1).trim();
                    Patrol patrol = new Patrol(date, hour, minute, message);
                }

                reader.close();
                sortGuardOrder(guardOrder);

            } catch (Exception e) {
                System.err.format("Exception occurred trying to read '%s'.", FILENAME);
                e.printStackTrace();
            }
        }

        public static ArrayList<Patrol> sortGuardOrder(ArrayList<Patrol> guards) {

            return new ArrayList<Patrol>();
        }

    }
