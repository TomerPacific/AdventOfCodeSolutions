package adventofcodeday12;

import java.util.ArrayList;

/**
 *
 * @author Tomer Ben Rachel
 * Created December 12th, 2017
 */
public class Program {
    private int id;
    private ArrayList<Program> links = new ArrayList<Program>();;
    
    public Program(int _id){
        id = _id;
    }
    
    public Program(int _id, ArrayList<Program> _links){
        id =_id;
        links = _links;
    }
    
    public void addToLinks(Program link){
        if(!links.contains(link)){
            links.add(link);
        }
        
    }
    
    public int getProgramId(){
        return id;
    }
    
    public ArrayList<Program> getAttached(){
        return links;
    }
    
    @Override
    public String toString(){
        String result = "";
        result += id + " attached to these following programs ";
        for(int i = 0; i < links.size(); i++){
            result += links.get(i).getProgramId() + " ";
        }
        
        return result;
    }
    
}
