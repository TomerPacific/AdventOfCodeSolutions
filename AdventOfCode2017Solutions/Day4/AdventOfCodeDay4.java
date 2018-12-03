package adventofcodeday4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 *
 * @author Tomer Ben Rachel
 * Created December 8th. 2017
 */
public class AdventOfCodeDay4 {

    final static String FILENAME = "puzzle.txt";
    public static void main(String[] args) {
       
        int countValid = 0;
        String line;
        boolean valid = true;
        HashMap<String,String> words = new HashMap<String, String>();
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            
            while ((line = reader.readLine()) != null)
            {
               String[] splitted = line.split("\\s+");
               valid = checkAnagram(splitted);
               for(int i = 0; i < splitted.length && valid; i++){
                    if(words.containsKey(splitted[i])){
                        valid = false;
                     } 
                    else{
                        words.put(splitted[i], splitted[i]);
                    }
               }
               if(valid){
                   countValid++;
               }
               valid = true;
            }
            reader.close();
      }
      catch (Exception e)
      {
        System.err.format("Exception occurred trying to read '%s'.", FILENAME);
        e.printStackTrace();
      }

      System.out.println("Valid " + countValid);
    }
    
    public static boolean checkAnagram(String[] words){
        
        for(int i = 0; i < words.length; i++){
            String wordToCheck = words[i];
            for(int j = i+1; j < words.length; j++){
                if(wordToCheck.length() == words[j].length()){
                    char[] lettersA = wordToCheck.toCharArray();
                    char[] lettersB = words[j].toCharArray();
                    boolean[] sameLetters = new boolean[lettersA.length];
                    for(int k = 0; k < lettersA.length; k++){
                        for(int f = 0; f < lettersB.length; f++){
                            if(lettersA[k] == lettersB[f]){
                                sameLetters[k] = true;
                            }
                        }
                    }
                    boolean areTheSame = true;
                    for(int k = 0; k < sameLetters.length && areTheSame; k++){
                        if(!sameLetters[k]){
                            areTheSame = false;
                        }
                    }
                    if(areTheSame){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
}
