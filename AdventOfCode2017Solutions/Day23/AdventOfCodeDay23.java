/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcodeday23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author ShokoBanana
 */
public class AdventOfCodeDay23 {

    private static int timesMulUsed = 0;
    private static int lineIndex = 0;
    
    public static void main(String[] args) {
        String fileName = "C:/Users/ShokoBanana/Downloads/AdventOfCodeDay23/src/adventofcodeday23/puzzle.txt";
        Register[] registers = new Register[8];
        Register a = new Register("a");
        Register b = new Register("b");
        Register c = new Register("c");
        Register d = new Register("d");
        Register e = new Register("e");
        Register f = new Register("f");
        Register g = new Register("g");
        Register h = new Register("h");
        a.setValue(1);
        registers[0] = a;
        registers[1] = b;
        registers[2] = c;
        registers[3] = d;
        registers[4] = e;
        registers[5] = f;
        registers[6] = g;
        registers[7] = h;
        
        LineOfCode[] lines = new LineOfCode[32];
        int index = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null)
            {
                LineOfCode l = new LineOfCode(line);
                lines[index] = l;
                index++;
            } // end while

            reader.close();
        }
        catch(IOException exception)
        {
            System.err.format("Exception occurred trying to read '%s'.", fileName);
        }
        startOperation(lines, registers);         
    }
    
    public static void startOperation(LineOfCode[] lines, Register[] registers) {
        while(lineIndex < lines.length) {
            LineOfCode l = lines[lineIndex];
            switch(l.getOperation()) {
                case "set" :
                     handleSet(l, registers);
                     lineIndex++;
                break;
                case "mul":
                    handleMul(l, registers);
                    timesMulUsed++;
                    lineIndex++;
                break;
         
                case "sub" :
                     handleSub(l, registers);
                     lineIndex++;
                break;
                case "jnz":
                    handleJnz(l, registers);
                break;
                default:
                    System.out.println("Wrong operation");
                
            } // end switch
            //printValues(registers);
        } // end while
        //System.out.println("Mul used " + timesMulUsed);
        System.out.println("Value of h " + registers[7].getValue());
    }
    
    public static void handleSet(LineOfCode l, Register[] registers) {
        String[] lineRegisters = l.getRegisters();
        String first = lineRegisters[0];
        String second = lineRegisters[1];
        if(tryToParseStringToInt(second)) {
            int value = Integer.parseInt(second);
            int index = findIndex(registers, first);
            Register reg = registers[index];
            reg.setValue(value);
       } else {
         int indexOne = findIndex(registers, first);
         int indexTwo = findIndex(registers, second);
         Register reg1 = registers[indexOne];
         Register reg2 = registers[indexTwo];
         reg1.setValue(reg2.getValue());
       }
    }
    
    public static void handleMul(LineOfCode l, Register[] registers) {
        String[] lineRegisters = l.getRegisters();
        String first = lineRegisters[0];
        String second = lineRegisters[1];
        int value = 0;
        int index = findIndex(registers, first);
        Register reg = registers[index];
        if(tryToParseStringToInt(second)) {
            value = Integer.parseInt(second);
        } else {
            int indexTwo = findIndex(registers, second);
            Register reg2 = registers[indexTwo];
            value = reg2.getValue();
        }
        
        reg.setValue(reg.getValue() * value);
    }
    
   
    public static void handleSub(LineOfCode l, Register[] registers) {
        String[] lineRegisters = l.getRegisters();
        String first = lineRegisters[0];
        String second = lineRegisters[1];
        if(tryToParseStringToInt(second)){
            int value = Integer.parseInt(second);
            int index = findIndex(registers, first);
            Register reg = registers[index];
            reg.setValue(reg.getValue() - value);
        } else {
            int indexOne = findIndex(registers, first);
            int indexTwo = findIndex(registers, second);
            Register reg1 = registers[indexOne];
            Register reg2 = registers[indexTwo];
            reg1.setValue(reg1.getValue() - reg2.getValue());
          }
    }
    
    public static void handleJnz(LineOfCode l, Register[] registers) {
        String[] lineRegisters = l.getRegisters();
        String first = lineRegisters[0];
        int firstVal = 0;
        int index = 0;
        Register reg = null;
         if(tryToParseStringToInt(first)) {
             firstVal = Integer.parseInt(first);
         } else {
             index = findIndex(registers, first);
              reg = registers[index];
              firstVal = reg.getValue();
         }
        
        if(firstVal != 0) {
            String second = lineRegisters[1];
            if(tryToParseStringToInt(second)){
                int val = Integer.parseInt(second);
                lineIndex += val;
            } else {
               index = findIndex(registers, second);
               Register reg2 = registers[index];
               lineIndex += reg2.getValue();
            }
        } else {
            lineIndex++;
        }
    }
    
    public static void printValues(Register[] registers){
        for(int i = 0; i < registers.length; i++){
            System.out.println("Register at index " + i + " is " + registers[i].getName() + " with value " + registers[i].getValue());
        }
    }
    
    public static int findIndex(Register[] registers, String key){
        for(int i = 0; i < registers.length; i++){
            if(registers[i].getName().equals(key)){
                return i;
            }
        }
        return -1;
    }
    
    public static boolean tryToParseStringToInt(String valueToParse){
     try{
         Integer.parseInt(valueToParse);
         return true;
     } catch(NumberFormatException e) {
         return false;
     }
    }
    
}
