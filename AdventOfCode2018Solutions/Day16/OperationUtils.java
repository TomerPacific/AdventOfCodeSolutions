public class OperationUtils {

    public OperationUtils() {

    }

    public int isAddition(int[] registersStateBefore,
                                      int[] registersStateAfter,
                                      int sourceRegister,
                                      int secondSourceRegister,
                                      int resultRegister) {

        int matches = 0;

        //addi
        if (registersStateBefore[sourceRegister] + secondSourceRegister
                == registersStateAfter[resultRegister]) {
            matches++;
        }
        // addr
        else if (registersStateBefore[sourceRegister] + registersStateBefore[secondSourceRegister]
                == registersStateAfter[resultRegister]) {
            matches++;
        }

        return matches;
    }

    public int isMultiplication(int[] registersStateBefore,
                                            int[] registersStateAfter,
                                            int sourceRegister,
                                            int secondSourceRegister,
                                            int resultRegister) {

        int matches = 0;

        //muli
        if (registersStateBefore[sourceRegister] * secondSourceRegister
                == registersStateAfter[resultRegister]) {
            matches++;
        }
        // mulr
        else if (registersStateBefore[sourceRegister] * registersStateBefore[secondSourceRegister]
                == registersStateAfter[resultRegister]) {
            matches++;
        }

        return matches;
    }

    public int isAnd(int[] registersStateBefore,
                                 int[] registersStateAfter,
                                 int sourceRegister,
                                 int secondSourceRegister,
                                 int resultRegister) {
        int matches=0;

        //bori
        int result = registersStateBefore[sourceRegister] & secondSourceRegister;
        if (result == registersStateAfter[resultRegister]) {
            matches++;
        }
        // borr
        result = registersStateBefore[sourceRegister] & registersStateBefore[secondSourceRegister];
        if (result == registersStateAfter[resultRegister]) {
            matches++;
        }


        return matches;
    }

    public int isOr(int[] registersStateBefore,
                                int[] registersStateAfter,
                                int sourceRegister,
                                int secondSourceRegister,
                                int resultRegister) {

        int matches=0;

        //bani
        int result = registersStateBefore[sourceRegister] | secondSourceRegister;
        if (result == registersStateAfter[resultRegister]) {
            matches++;
        }
        // banr
        result = registersStateBefore[sourceRegister] | registersStateBefore[secondSourceRegister];
        if (result == registersStateAfter[resultRegister]) {
            matches++;
        }


        return matches;
    }

    public int isAssignment(int[] registersStateBefore,
                                        int[] registersStateAfter,
                                        int sourceRegister,
                                        int resultRegister) {
        int matches=0;

        //seti
        if (registersStateAfter[resultRegister] == sourceRegister) {
            matches++;
        }
        //setr
        if (registersStateBefore[sourceRegister] == registersStateAfter[resultRegister]) {
            matches++;
        }
        return matches;
    }

    public int isGreaterThan(int[] registersStateBefore,
                                         int[] registersStateAfter,
                                         int sourceRegister,
                                         int secondSourceRegister,
                                         int resultRegister) {
        int matches=0;

        //gtir
        if ((registersStateAfter[resultRegister] == 1 && sourceRegister > registersStateBefore[secondSourceRegister]) ||
                (registersStateAfter[resultRegister] == 0 && sourceRegister <= registersStateBefore[secondSourceRegister])){
            matches++;
        }

        //gtri
        if ((registersStateAfter[resultRegister] == 1 && registersStateBefore[sourceRegister] > secondSourceRegister) ||
                (registersStateAfter[resultRegister] == 0 && registersStateBefore[sourceRegister] <= secondSourceRegister)){
            matches++;
        }

        //gtrr
        if ((registersStateAfter[resultRegister] == 1 && registersStateBefore[sourceRegister] > registersStateBefore[secondSourceRegister]) ||
                (registersStateAfter[resultRegister] == 0 && registersStateBefore[sourceRegister] <= registersStateBefore[secondSourceRegister])){
            matches++;
        }


        return matches;
    }

    public int isEqual(int[] registersStateBefore,
                                 int[] registersStateAfter,
                                 int sourceRegister,
                                 int secondSourceRegister,
                                 int resultRegister) {

        int matches=0;

        //eqir
        if ((registersStateAfter[resultRegister] == 1 && sourceRegister == registersStateBefore[secondSourceRegister]) ||
                (registersStateAfter[resultRegister] == 0 && sourceRegister != registersStateBefore[secondSourceRegister])){
            matches++;
        }

        //eqri
        if ((registersStateAfter[resultRegister] == 1 && registersStateBefore[sourceRegister] == secondSourceRegister) ||
                (registersStateAfter[resultRegister] == 0 && registersStateBefore[sourceRegister] != secondSourceRegister)){
            matches++;
        }

        //eqrr
        if ((registersStateAfter[resultRegister] == 1 && registersStateBefore[sourceRegister] == registersStateBefore[secondSourceRegister]) ||
                (registersStateAfter[resultRegister] == 0 && registersStateBefore[sourceRegister] != registersStateBefore[secondSourceRegister])){
            matches++;
        }


        return matches;
    }


}
