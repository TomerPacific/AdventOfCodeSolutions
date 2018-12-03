package adventofcodeday12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Tomer Ben Rachel
 * Created December 11th, 2017
 */
public class AdventOfCodeDay12 {

   static final String FILENAME = "puzzle.txt";
    public static void main(String[] args) {
        ArrayList<Program> programs = new ArrayList<Program>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            String line;

            while ((line = reader.readLine()) != null)
            {
                String[] splitted = line.split("\\s+");
                int find = findProgramInPrograms(Integer.parseInt(splitted[0]), programs);
                Program p = null;
                if(find == -1){
                    p = new Program(Integer.parseInt(splitted[0]));
                }
                else{
                    p = programs.get(find);
                }
                // Does program have nested programs
                if(splitted.length == 3){
                    int id = Integer.parseInt(splitted[2]);
                    int result = findProgramInPrograms(id, programs);
                    if(result == -1){
                         Program l = new Program(id);
                         l.addToLinks(p);
                         p.addToLinks(l);
                         programs.add(l);
                    }
                    else{
                        Program l = programs.get(result);
                        l.addToLinks(p);
                        p.addToLinks(l);
                    }
                }
                else{
                    for(int i = 2; i < splitted.length; i++){
                        String nextP = splitted[i];
                        String withoutCommas = nextP.replaceAll(",", "");
                        int pId = Integer.parseInt(withoutCommas);
                        int result = findProgramInPrograms(pId, programs);
                        if(result == -1){        
                            Program l = new Program(Integer.parseInt(withoutCommas));
                            l.addToLinks(p);
                            p.addToLinks(l);
                            programs.add(l);
                        }
                        else{
                            Program l = programs.get(result);
                            l.addToLinks(p);
                            p.addToLinks(l);
                        }
                    }
                }
                if(find == -1) programs.add(p);
            }
        reader.close();
        } catch (Exception e) {
          System.err.format("Exception occurred trying to read '%s'.", FILENAME);
          e.printStackTrace();
        }
        int attached = findAllProgramsRelatedToZero(programs);
       System.out.println("Number of programs attached to zero is " + attached);
       
        int groups = 0;
        int index = 2;
        while(programs.size() > 0){
            Program checked = programs.get(0);
            programs.remove(checked);
            findAllProgramsRelated(checked, programs);
            groups++;
            index--;
        }
        System.out.println("Number of program groups " + groups);
    }
    
    public static void findAllProgramsRelated(Program checked, ArrayList<Program> programs){
        LinkedList<Program> q = new LinkedList<Program>();
        LinkedList<Program> q2 = new LinkedList<Program>();
        
        q.addLast(checked);
       
        while(!q.isEmpty()){
            Program p = q.getFirst();
            programs.remove(p);
            q.remove(p);
            q2.addLast(p);
            ArrayList<Program> inner = p.getAttached();
            if(inner.size() > 0){
                for(int j = 0; j < inner.size(); j++){
                    if(!q.contains(inner.get(j)) && !q2.contains(inner.get(j))){
                        q.addLast(inner.get(j));
                    }   
                }
            }
        } // end while
    }
    
    public static void printPrograms(ArrayList<Program> programs){
        for(int i = 0; i < programs.size(); i++){
            System.out.println(programs.get(i).toString());
        }
    }
    
    public static int findProgramInPrograms(int programId, ArrayList<Program> programs){
        for(int i = 0; i < programs.size(); i++){
            Program p = programs.get(i);
            if(p.getProgramId() == programId){
                return i;
            }
        }
        return -1;
    }
    
    public static int findAllProgramsRelatedToZero(ArrayList<Program> programs){
        int result = 0;
        Program zero = null;
        for(int i = 0; i < programs.size(); i++){
            if(programs.get(i).getProgramId() == 0){
                zero = programs.get(i);
                break;
            }
        } // end for
        LinkedList<Program> q = new LinkedList<Program>();
        LinkedList<Program> q2 = new LinkedList<Program>();
        
        q.addLast(zero);
        while(!q.isEmpty()){
            Program p = q.getFirst();
            result++;
            q.remove(p);
            q2.addLast(p);
            ArrayList<Program> inner = p.getAttached();
            if(inner.size() > 0){
                for(int j = 0; j < inner.size(); j++){
                    if(!q.contains(inner.get(j)) && !q2.contains(inner.get(j))){
                        q.addLast(inner.get(j));
                    }   
                }
            }
        } // end while
        return result;
    }
}
