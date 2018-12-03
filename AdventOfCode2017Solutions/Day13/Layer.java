package adventofcodeday13;

/**
 * @author Tomer Ben Rachel
 * Created December 9th, 2017
 */
public class Layer {
    private int id;
    private String[] wall;
    int direction;
    
    public Layer(int _id, int lengthOfWall){
        id = _id;
        wall = new String[lengthOfWall];
        wall[0] = "S";
        direction = 1;
    }
    
    public int getPositionOfScanner(){
        for(int i = 0; i < wall.length; i++){
            if(wall[i].equals("S")){
                return i;
            }
        }
        return -1;
    }
    
    public void advanceScanner(){
        int positionOfScanner = getPositionOfScanner();
        wall[positionOfScanner] = "";
        if(positionOfScanner == wall.length - 1){
            wall[positionOfScanner - 1] = "S";
            direction = -1;
        }
        else if(positionOfScanner == 0){
            wall[positionOfScanner + 1] = "S";
            direction = 1;
        }
        else if(direction == 1){
            positionOfScanner++;
            wall[positionOfScanner] = "S";
        }
        else if(direction == -1){
            positionOfScanner--;
            wall[positionOfScanner] = "S";
        }
    }
    
    public int getLengthOfWall(){
        return wall.length;
    }
}
