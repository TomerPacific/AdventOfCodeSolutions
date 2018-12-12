import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Main {

    final static String FILENAME = "src/input.txt";

    public static void main(String[] args) {


        String line;
        ArrayList<Patrol> patrols = new ArrayList<>();
        ArrayList<Guard> guards = new ArrayList<>();

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
                patrols = sortGuardOrder(patrols);

                for (int i = 0; i < patrols.size(); i++) {
                    Patrol currentPatrol = patrols.get(i);
                    String patrolMessage = currentPatrol.getMessage();
                    if (patrolMessage.contains("#")) {
                        String guardId = patrolMessage.substring(patrolMessage.indexOf("#")+1, patrolMessage.indexOf("b")).trim();
                        Guard guard = new Guard(Integer.parseInt(guardId),
                                                String.valueOf(currentPatrol.getHour()) + ":" + String.valueOf(currentPatrol.getMinutes()));
                        guards.add(guard);
                    }
                }

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

                    int firstMonth = Integer.parseInt(first.getMonth());
                    int secondMonth = Integer.parseInt(second.getMonth());
                    int firstDay = Integer.parseInt(first.getDay());
                    int secondDay = Integer.parseInt(second.getDay());

                    int firstHour =  first.getHour();
                    int secondHour = second.getHour();
                    int firstMinutes = first.getMinutes();
                    int secondMinutes = second.getMinutes();

                    if      (firstMonth > secondMonth ||
                            (firstMonth == secondMonth && firstDay > secondDay) ||
                            (firstMonth == secondMonth && firstDay == secondDay && firstHour > secondHour) ||
                            (firstMonth == secondMonth && firstDay == secondDay && firstHour == secondHour && firstMinutes > secondMinutes)) {
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
