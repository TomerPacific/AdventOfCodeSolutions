import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {

    final static String FILENAME = "src/input.txt";

    public static void main(String[] args) {


        String line;
        ArrayList<Patrol> patrols = new ArrayList<>();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
                while ((line = reader.readLine()) != null) {
                    String date = line.substring(line.indexOf('-')+1, line.indexOf(' '));
                    String month = date.substring(0, date.indexOf("-"));
                    String day = date.substring(date.indexOf("-")+1);
                    String hour = line.substring(line.indexOf(' ')+1, line.indexOf(':'));
                    String minute = line.substring(line.indexOf(':')+1, line.indexOf(']'));
                    String message = line.substring(line.indexOf(']')+1).trim();
                    Patrol patrol = new Patrol(month, day, hour, minute, message);
                    patrols.add(patrol);
                }

                reader.close();
                //patrols = sortGuardOrder(patrols);

            } catch (Exception e) {
                System.err.format("Exception occurred trying to read '%s'.", FILENAME);
                e.printStackTrace();
            }
        }

        public static ArrayList<Patrol> sortGuardOrder(ArrayList<Patrol> patrols) {
            boolean didSwapOccur = true;
            while(didSwapOccur) {
                didSwapOccur = false;
                for (int i = 0; i < patrols.size() - 1; i++) {
                    Patrol first = patrols.get(i);
                    Patrol second = patrols.get(i+1);
                    if (Integer.parseInt(first.getMonth()) > Integer.parseInt(second.getMonth())) {
                        Patrol swappedPatrol = first;
                        patrols.set(i, second);
                        patrols.set(i+1,swappedPatrol);
                        didSwapOccur = true;
                    }
                }
               }
            return patrols;
        }

    }
