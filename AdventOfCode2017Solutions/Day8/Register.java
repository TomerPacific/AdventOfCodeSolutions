package adventofcodeday8;

/**
 *
 * @author Tomer Ben Rachel
 * Created December 8th, 2017
 */
public class Register {
    
    private int value;
    private String name;
    
    public Register(String nameOfRegister){
        value = 0;
        name = nameOfRegister;
    }
    
    public void modifyValue(String instruction, int valueToModify){
        if(instruction.equals("inc")){
            value += valueToModify;
        }
        else{
            value -= valueToModify;
        }
    }
    
    public String getRegisterName(){
        return name;
    }
    
    public int getRegisterValue(){
        return value;
    }
    
    @Override
    public String toString(){
        return "Register " + name + " with value " + value;
    }
}
