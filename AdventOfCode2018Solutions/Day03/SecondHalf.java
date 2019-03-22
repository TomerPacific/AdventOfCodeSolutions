import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;


public class Main {

    final static String FILENAME = "src/input.txt";
    public static void main(String[] args) {

        String line;
        String[][] fabric = new String[1000][1000];
        Set<String> identifiers = new HashSet<String>();
        Set<String> claimedIdentifiers = new HashSet<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            while ((line = reader.readLine()) != null) {
                String[] coordinates =  line.substring(line.indexOf("@")+1, line.indexOf(":")).trim().split(",");
                String[] size = line.substring(line.indexOf(":")+1).trim().split("x");
                String id = line.substring(0, line.indexOf("@")).trim();
                identifiers.add(id);
                int startingRow = Integer.parseInt(coordinates[0]);
                int startingColumn = Integer.parseInt(coordinates[1]);
                int endingRow = Integer.parseInt(size[0]);
                int endingColumn = Integer.parseInt(size[1]);
                for (int i = startingRow; i <  startingRow + endingRow; i++) {
                    for (int j = startingColumn; j < startingColumn + endingColumn; j++) {
                        if (fabric[i][j] != null) {

                            if (!claimedIdentifiers.contains(id)) {
                                claimedIdentifiers.add(id);
                            }
                            if (!claimedIdentifiers.contains(fabric[i][j])) {
                                claimedIdentifiers.add(fabric[i][j]);
                            }

                            fabric[i][j] = "P";
                        } else {
                            fabric[i][j] = id;
                        }
                    }
                }

            }
            reader.close();

            int multipleClaims = findMultipleClaims(fabric);
            System.out.println("Amount of sq inches of multiple claims is " + multipleClaims);
            String unclaimedId = findUnclaimedId(identifiers, claimedIdentifiers);
            System.out.println("Unclaimed ID " + unclaimedId);

        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", FILENAME);
            e.printStackTrace();
        }
    }

    
    public static String findUnclaimedId(Set<String> ids, Set<String>claimedIds) {
        String id = "";
        for(String s : ids) {
            if (!claimedIds.contains(s)) {
                return s;
            }
        }

        return id;
    }
    

    public static int findMultipleClaims(String[][] fabric) {
        int result = 0;
        for (int i = 0; i < fabric.length; i++) {
            for (int j = 0; j < fabric[i].length; j++) {
                if (fabric[i][j] == "P") {
                    result++;
                }
            }
        }

        return result;
    }
}