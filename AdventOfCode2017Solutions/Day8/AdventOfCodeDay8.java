package adventofcodeday8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Tomer Ben Rachel
 * Created December 8th, 2017
 */
public class AdventOfCodeDay8 {

    private static int largestValueDuringRun = 0;
    
    final static String FILENAME = "puzzle.txt";
    public static void main(String[] args) {
        ArrayList<Register> registers = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            String line;
            
            //Creating registers
            while ((line = reader.readLine()) != null)
            {
                String[] splitted = line.split("\\s+");     
                Register register = new Register(splitted[0]);
                registers.add(register);
            }
            reader.close();

            BufferedReader reader2 = new BufferedReader(new FileReader(FILENAME));
            while ((line = reader2.readLine()) != null){
                String[] splitted = line.split("\\s+");
                String firstRegister = splitted[0];
                String secondRegister = splitted[4];
                String ifOperation = splitted[5];
                String ifValue = splitted[6];
                String mainOperation = splitted[1];
                String mainOperationValue = splitted[2]; 
                Register registerToModify = findRegister(registers, firstRegister);
                Register registerToCheckValue = findRegister(registers, secondRegister);
                handleOperation(ifOperation, ifValue, mainOperation, mainOperationValue, registerToModify, registerToCheckValue);
            }
            int maximumValueInRegsiters = findMaximumValue(registers);
            System.out.println("The maximum value held in a register after the process is " + maximumValueInRegsiters);
            System.out.println("Largest value held in a register during the process is " + largestValueDuringRun);
      } catch (Exception e) {
        System.err.format("Exception occurred trying to read '%s'.", FILENAME);
        e.printStackTrace();
      }
    }
    
    public static int findMaximumValue(ArrayList<Register> registers) {
        int maximumValue = 0;
        for(int i = 0; i < registers.size(); i++) {
            Register reg = registers.get(i);
            if(reg.getRegisterValue() > maximumValue) {
                maximumValue = reg.getRegisterValue();
            }
        }
        
        return maximumValue;
    }
    
    public static Register findRegister(ArrayList<Register> registers, String name){
        for(int i = 0; i < registers.size(); i++){
            if(registers.get(i).getRegisterName().equals(name)){
                return registers.get(i);
            }
        }
        return null;
    }
    
    public static void handleOperation(String ifOperation, String ifValue, 
                                       String mainOperation, String mainOperationValue, 
                                       Register registerToModify, Register registerToCheckValue){
        switch(ifOperation){
            case "!=":
                if(registerToCheckValue.getRegisterValue() != Integer.parseInt(ifValue)){
                    registerToModify.modifyValue(mainOperation, Integer.parseInt(mainOperationValue));
                }
                break;
            case ">=":
                if(registerToCheckValue.getRegisterValue() >= Integer.parseInt(ifValue)){
                    registerToModify.modifyValue(mainOperation, Integer.parseInt(mainOperationValue));
                }
                break;
            case "<=":
                if(registerToCheckValue.getRegisterValue() <= Integer.parseInt(ifValue)){
                    registerToModify.modifyValue(mainOperation, Integer.parseInt(mainOperationValue));
                }
                break;
            case "==":
                if(registerToCheckValue.getRegisterValue() == Integer.parseInt(ifValue)){
                    registerToModify.modifyValue(mainOperation, Integer.parseInt(mainOperationValue));
                }
                break;
            case ">":
                if(registerToCheckValue.getRegisterValue() > Integer.parseInt(ifValue)){
                    registerToModify.modifyValue(mainOperation, Integer.parseInt(mainOperationValue));
                }
                break;
            case "<":
                if(registerToCheckValue.getRegisterValue() < Integer.parseInt(ifValue)){
                    registerToModify.modifyValue(mainOperation, Integer.parseInt(mainOperationValue));
                }
                break;
            default:
                System.out.println("Unidentified operation " + ifOperation);
        }
        largestValueDuringRun = registerToModify.getRegisterValue() > largestValueDuringRun ? registerToModify.getRegisterValue() : largestValueDuringRun;
    }
    
}
