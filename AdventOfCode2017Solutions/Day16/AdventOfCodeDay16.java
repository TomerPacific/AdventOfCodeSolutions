/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcodeday16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;


/**
 *
 * @author ShokoBanana
 */
public class AdventOfCodeDay16 {
    
    final static long ITERATIONS = 100;
    
    public static void main(String[] args) {
         String fileName = "C:/Users/ShokoBanana/Downloads/AdventOfCodeDay16/src/adventofcodeday16/puzzle.txt";
         char[] programs = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'};
         HashMap<Long, String> seen2 = new HashMap<Long,String>();
         for(long i = 0; i < ITERATIONS; i++){
             try{
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line;

                while ((line = reader.readLine()) != null)
                {
                    String[] split = line.split(",");
                    for (String split1 : split) {
                        performAction(programs, split1);           
                    }

                }
                String image = String.valueOf(programs);
                Long keyToBeFound = 0L;
                if(seen2.containsValue(image)){
                    for(Entry<Long, String> et : seen2.entrySet()){
                        if(Objects.equals(image, et.getValue())){
                            keyToBeFound = et.getKey();
                            break;
                        }
                    }
                    System.out.println("Found " + image + " at iteration " + i + "since iteration " + keyToBeFound);
                }
                else{
                    seen2.put(i, image);
                }
                reader.close();
            }catch (IOException e){
                System.err.format("Exception occurred trying to read '%s'.", fileName);
            }
        }
        printArr(programs);
         
    }

    public static void performAction(char[] programs, String action){
        
        char act = action.charAt(0);
        
        switch (act) {
            case 'p':
                {
                    char swapOne = action.charAt(1);
                    char swapTwo = action.charAt(3);
                    int indexSwapOne = findIndex(programs, swapOne);
                    int indexSwapTwo = findIndex(programs, swapTwo);
                    programs[indexSwapOne] = swapTwo;
                    programs[indexSwapTwo] = swapOne;
                    break;
                }
            case 'x':
                {
                    int indexOfSlash = action.indexOf("/");
                    String first = action.substring(1, indexOfSlash);
                    String second = action.substring(indexOfSlash + 1);
                    int swapOne = Integer.parseInt(first);
                    int swapTwo = Integer.parseInt(second);
                    char temp = programs[swapOne];
                    programs[swapOne] = programs[swapTwo];
                    programs[swapTwo] = temp;
                    break;
                }
            case 's':
                int rotateFrom = Integer.parseInt(action.substring(1));
                shiftElements(programs, rotateFrom);
                break;
            default:
                System.out.println("Wrong action");
                break;
        }
    }
    
    public static int findIndex(char[] programs, char toFind){
        for(int i = 0; i < programs.length; i++){
            if(programs[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    
    public static void shiftElements(char[] programs, int amountToRotate){
        while(amountToRotate > 0){
            char endElement = programs[programs.length - 1];
            for(int i = programs.length - 1; i > 0 ; i--){
                programs[i] = programs[i - 1];
            }
            programs[0] = endElement;
            endElement = programs[programs.length - 1];
            amountToRotate--;
        }
    }
    
    public static void printArr(char[] programs){
        for(int i = 0; i < programs.length; i++){
            System.out.print(programs[i] + " ");
        }
        
        System.out.println("");
    }
    
}
