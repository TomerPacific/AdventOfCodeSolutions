package adventofcodeday13;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Tomer Ben Rachel
 * Created December 9th, 2017
 */
public class AdventOfCodeDay13 {

   final static String FILENAME = "puzzle.txt";
   final static int FIREWALL_COUNT = 93;
   public static void main(String[] args) {
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            String line;
            Layer[] firewall = new Layer[FIREWALL_COUNT];
            int indexInFirewall = 0;
            while ((line = reader.readLine()) != null)
            {
                String[] split = line.split("\\s+");
                String id = split[0].replaceAll(":", "");
                int layerID = Integer.parseInt(id);
                Layer l = new Layer(layerID, Integer.parseInt(split[1]));
                if(indexInFirewall < layerID){
                    indexInFirewall = layerID;
                }
                firewall[indexInFirewall] = l;
                indexInFirewall++;
            }
            reader.close();
            simulateRun(firewall);
        }catch (Exception e){
            System.err.format("Exception occurred trying to read '%s'.", FILENAME);
            e.printStackTrace();
        }
    }
    
    public static void simulateRun(Layer[] firewall){
        int sumOfHits = 0;
        for(int i = 0; i < firewall.length; i++){
            if(firewall[i] != null){
                int pos = firewall[i].getPositionOfScanner();
                sumOfHits+= pos == 0 ? (i * firewall[i].getLengthOfWall()) : 0;
            }
            for(int j = 0; j < firewall.length; j++){
                if(firewall[j] != null){
                    firewall[j].advanceScanner();
                }
                
            }
        }
        System.out.println("Severity of the whole trip is " + sumOfHits);
    }
    
}
