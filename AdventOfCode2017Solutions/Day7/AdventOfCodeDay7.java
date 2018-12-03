package adventofcodeday7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Tomer Ben Rachel
 */
public class AdventOfCodeDay7 {

    final static String FILENAME = "C:/Users/ShokoBanana/Downloads/AdventOfCodeDay7/src/adventofcodeday7/puzzle.txt";
    
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            String line;
            int countTowers = 0;
            while ((line = reader.readLine()) != null)
            {
                countTowers++;
            }
            reader.close();
            Tower[] towers = new Tower[countTowers];
            int indexInTowerArray = 0;
            BufferedReader reader2 = new BufferedReader(new FileReader(FILENAME));
            while ((line = reader2.readLine()) != null) {
                String[] split = line.split("\\s+");
                String id = split[1];
                //removing parenthesis
                id = id.substring(1, id.length() - 1);
                String name = split[0];
                Tower tower = new Tower(name, Integer.parseInt(id));
                //if there are towers nested
                if(split.length > 2){
                    for(int i = 3; i < split.length; i++){
                        String name2 = split[i];
                        if(name2.indexOf(',') != -1){
                            name2 = name2.substring(0, name2.length() - 1);
                        }
                        
                        Tower nestedTower = new Tower(name2);
                        tower.addToTowerList(nestedTower);
                    }
                }
                towers[indexInTowerArray] = tower;
                indexInTowerArray++;
            }
            //printTowers(towers);
            fillInDependencies(towers);
            //System.out.println("After---------------------");
            //printTowers(towers);
            System.out.println("Bottom Tower is " + findBottomTower(towers));
            
        } catch (Exception e){
            e.printStackTrace();
        }
    } // end main
    
    
    
    public static void printTowers(ArrayList<Tower> towers){
        for(int i = 0; i < towers.size(); i++){
            System.out.println(towers.get(i).toString());
        }
    }
    
    public static ArrayList<Tower> filterOutTowers(ArrayList<Tower> towers){
        ArrayList<Tower> filtered = new ArrayList<Tower>();
        for(int i = 0; i < towers.size(); i++){
            if(towers.get(i).getTowerList().size() > 0){
                filtered.add(towers.get(i));
            }
        }
        return filtered;
    }
    
    public static String findBottomTower(Tower[] towers){
        Tower bottomTower = towers[0];
        for(int i = 1; i < towers.length; i++){
            Tower towerElement = towers[i];
            if(towerElement.hasNestedTowers()) {
                ArrayList<Tower> nestedTowers = towerElement.getTowerList();
                if(nestedTowers.contains(bottomTower)) {
                    bottomTower = towerElement;
                }
            }
        }
        return bottomTower.getTowerName();
    }
    
   public static void fillInDependencies(Tower[] towers){
       for(int i = 0; i < towers.length; i++){
           Tower tower = towers[i];
           ArrayList<Tower> nestedTowers = tower.getTowerList();
           if(nestedTowers.size() > 0){
               for(int j = 0; j < nestedTowers.size(); j++){
                   Tower nestedTower = nestedTowers.get(j);
                   int index = findTower(towers, nestedTower);
                   nestedTower = towers[index];
                   nestedTowers.set(j, nestedTower);
               }
           }
       }
   }
   
   public static int findTower(Tower[] towers, Tower nestedTower){
       String nestedTowerName = nestedTower.getTowerName();
       for(int i = 0; i < towers.length; i++){
           String towerName = towers[i].getTowerName();
           if(towerName == null ? nestedTowerName == null : towerName.equals(nestedTowerName)){
               return i;
           }
       }
       return -1;
   }
}
