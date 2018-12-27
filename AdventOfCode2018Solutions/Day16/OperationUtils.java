public class OperationUtils {

    public OperationUtils() {

    }

    public boolean isAddition(int[] registersStateBefore,
                                      int[] registersStateAfter,
                                      int sourceRegister,
                                      int secondSourceRegister,
                                      int resultRegister) {

        //addi
        if (registersStateBefore[sourceRegister] + secondSourceRegister
                == registersStateAfter[resultRegister]) {
            return true;
        }
        // addr
        else if (registersStateBefore[sourceRegister] + registersStateBefore[secondSourceRegister]
                == registersStateAfter[resultRegister]) {
            return true;
        }

        return false;
    }

    public boolean isMultiplication(int[] registersStateBefore,
                                            int[] registersStateAfter,
                                            int sourceRegister,
                                            int secondSourceRegister,
                                            int resultRegister) {

        //muli
        if (registersStateBefore[sourceRegister] * secondSourceRegister
                == registersStateAfter[resultRegister]) {
            return true;
        }
        // mulr
        else if (registersStateBefore[sourceRegister] * registersStateBefore[secondSourceRegister]
                == registersStateAfter[resultRegister]) {
            return true;
        }

        return false;
    }

    public boolean isAnd(int[] registersStateBefore,
                                 int[] registersStateAfter,
                                 int sourceRegister,
                                 int secondSourceRegister,
                                 int resultRegister) {

        //bori
        int result = registersStateBefore[sourceRegister] & secondSourceRegister;
        if (result == registersStateAfter[resultRegister]) {
            return true;
        }
        // borr
        result = registersStateBefore[sourceRegister] & registersStateBefore[secondSourceRegister];
        if (result == registersStateAfter[resultRegister]) {
            return true;
        }


        return false;
    }

    public boolean isOr(int[] registersStateBefore,
                                int[] registersStateAfter,
                                int sourceRegister,
                                int secondSourceRegister,
                                int resultRegister) {

        //bani
        int result = registersStateBefore[sourceRegister] | secondSourceRegister;
        if (result == registersStateAfter[resultRegister]) {
            return true;
        }
        // banr
        result = registersStateBefore[sourceRegister] | registersStateBefore[secondSourceRegister];
        if (result == registersStateAfter[resultRegister]) {
            return true;
        }


        return false;
    }

    public boolean isAssignment(int[] registersStateBefore,
                                        int[] registersStateAfter,
                                        int sourceRegister,
                                        int resultRegister) {

        //seti
        if (registersStateAfter[resultRegister] == sourceRegister) {
            return true;
        }
        //setr
        if (registersStateBefore[sourceRegister] == registersStateAfter[resultRegister]) {
            return true;
        }
        return false;
    }

    public boolean isGreaterThan(int[] registersStateBefore,
                                         int[] registersStateAfter,
                                         int sourceRegister,
                                         int secondSourceRegister,
                                         int resultRegister) {
        //gtir
        if ((registersStateAfter[resultRegister] == 1 && sourceRegister > registersStateBefore[secondSourceRegister]) ||
                (registersStateAfter[resultRegister] == 0 && sourceRegister <= registersStateBefore[secondSourceRegister])){
            return true;
        }

        //gtri
        if ((registersStateAfter[resultRegister] == 1 && registersStateBefore[sourceRegister] > secondSourceRegister) ||
                (registersStateAfter[resultRegister] == 0 && registersStateBefore[sourceRegister] <= secondSourceRegister)){
            return true;
        }

        //gtrr
        if ((registersStateAfter[resultRegister] == 1 && registersStateBefore[sourceRegister] > registersStateBefore[secondSourceRegister]) ||
                (registersStateAfter[resultRegister] == 0 && registersStateBefore[sourceRegister] <= registersStateBefore[secondSourceRegister])){
            return true;
        }


        return false;
    }

    public boolean isEqual(int[] registersStateBefore,
                                 int[] registersStateAfter,
                                 int sourceRegister,
                                 int secondSourceRegister,
                                 int resultRegister) {

        //eqir
        if ((registersStateAfter[resultRegister] == 1 && sourceRegister == registersStateBefore[secondSourceRegister]) ||
                (registersStateAfter[resultRegister] == 0 && sourceRegister != registersStateBefore[secondSourceRegister])){
            return true;
        }

        //eqri
        if ((registersStateAfter[resultRegister] == 1 && registersStateBefore[sourceRegister] == secondSourceRegister) ||
                (registersStateAfter[resultRegister] == 0 && registersStateBefore[sourceRegister] != secondSourceRegister)){
            return true;
        }

        //eqrr
        if ((registersStateAfter[resultRegister] == 1 && registersStateBefore[sourceRegister] == registersStateBefore[secondSourceRegister]) ||
                (registersStateAfter[resultRegister] == 0 && registersStateBefore[sourceRegister] != registersStateBefore[secondSourceRegister])){
            return true;
        }


        return false;
    }


}
