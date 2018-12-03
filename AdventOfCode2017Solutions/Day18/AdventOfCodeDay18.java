/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcodeday18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 *
 * @author ShokoBanana
 */
public class AdventOfCodeDay18 {

    private static int lastSoundPlayed = 0;
    private static int lineIndex = 0;
    
    public static void main(String[] args) {
        String fileName = "C:/Users/ShokoBanana/Downloads/AdventOfCodeDay18/src/adventofcodeday18/puzzle.txt";
        Register[] registers = new Register[5];
        Register a = new Register("a");
        Register b = new Register("b");
        Register f = new Register("f");
        Register i = new Register("i");
        Register p = new Register("p");
        registers[0] = a;
        registers[1] = b;
        registers[2] = f;
        registers[3] = i;
        registers[4] = p;
        LineOfCode[] lines = new LineOfCode[41];
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
        }catch (IOException e){
            System.err.format("Exception occurred trying to read '%s'.", fileName);
        }
        startOperation(lines, registers);         
    }
    
    public static void startOperation(LineOfCode[] lines, Register[] registers) {
        System.out.println("Amount of lines " + lines.length);
        while(lineIndex < lines.length) {
            LineOfCode l = lines[lineIndex];
            System.out.println("Executing line " + l.getCode());
            switch(l.getOperation()) {
                case "set" :
                     handleSet(l, registers);
                     lineIndex++;
                break;
                case "mul":
                    handleMul(l, registers);
                    lineIndex++;
                break;
                case "snd":
                    handleSend(l, registers);
                    lineIndex++;
                break;
                case "add" :
                     handleAdd(l, registers);
                     lineIndex++;
                break;
                case "mod":
                    handleMod(l, registers);
                    lineIndex++;
                break;
                case "rcv":
                    handleRcv(l, registers);
                    lineIndex++;
                break;
                case "jgz":
                    handleJgz(l, registers);
                break;
                default:
                    System.out.println("Wrong operation");
                
            } // end switch
            //printValues(registers);
        } // end while
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
        int value = Integer.parseInt(second);
        int index = findIndex(registers, first);
        Register reg = registers[index];
        reg.setValue(reg.getValue() * value);
    }
    
    public static void handleSend(LineOfCode l, Register[] registers) {
        String[] lineRegisters = l.getRegisters();
        int index = findIndex(registers, lineRegisters[0]);
        lastSoundPlayed = registers[index].getValue();
        System.out.println("Playing sound of " + lineRegisters[0] + " value " + registers[index].getValue());
    }
    
    public static void handleAdd(LineOfCode l, Register[] registers) {
        String[] lineRegisters = l.getRegisters();
        String first = lineRegisters[0];
        String second = lineRegisters[1];
        if(tryToParseStringToInt(second)){
            int value = Integer.parseInt(second);
            int index = findIndex(registers, first);
            Register reg = registers[index];
            reg.setValue(reg.getValue() + value);
        } else {
            int indexOne = findIndex(registers, first);
            int indexTwo = findIndex(registers, second);
            Register reg1 = registers[indexOne];
            Register reg2 = registers[indexTwo];
            reg1.setValue(reg1.getValue() + reg2.getValue());
          }
    }
    
    public static void handleMod(LineOfCode l, Register[] registers) {
        String[] lineRegisters = l.getRegisters();
        String first = lineRegisters[0];
        String second = lineRegisters[1];
        if(tryToParseStringToInt(second)){
            int value = Integer.parseInt(second);
            int index = findIndex(registers, first);
            Register reg = registers[index];
            reg.setValue(reg.getValue() % value);
          } else {
                int indexOne = findIndex(registers, first);
                int indexTwo = findIndex(registers, second);
                Register reg1 = registers[indexOne];
                Register reg2 = registers[indexTwo];
                reg1.setValue(reg1.getValue() % reg2.getValue());
        }
    }
    
    public static void handleRcv(LineOfCode l, Register[] registers) {
        String[] lineRegisters = l.getRegisters();
        String first = lineRegisters[0];
        int index = findIndex(registers, first);
        if(registers[index].getValue() != 0){
            System.out.println("Recovered last Sound Played " + lastSoundPlayed);
        }
    }
    
    public static void handleJgz(LineOfCode l, Register[] registers) {
        String[] lineRegisters = l.getRegisters();
        String first = lineRegisters[0];
        int index = findIndex(registers, first);
        Register reg = registers[index];
        if(reg.getValue() > 0) {
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
