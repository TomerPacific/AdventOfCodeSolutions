/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcodeday23;

/**
 *
 * @author ShokoBanana
 */
public class LineOfCode {
    private String code;
    private String operation;
    private String[] registers = new String[2];
    
    public LineOfCode(String line){
        code = line;
        parseLineOfCode();
    }
    
    private void parseLineOfCode() {
        String[] split = code.split("\\s+");
        operation = split[0];
        switch(split[0]){
            case "set" :
            case "mul" :
            case "sub":
            case "jnz":
                  registers[0] = split[1];
                  registers[1] = split[2];
                break;
            default:
                System.out.println("Unrecognized command " + split[0]);
                break;   
        } // end switch
    }
    
    public String getOperation() {
        return operation;
    }
    
    public String[] getRegisters() {
        return registers;
    }
    
    public String getCode() {
        return code;
    }
}
