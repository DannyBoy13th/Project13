package goit.gojava2.javacore.project13;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Factorial item = new Factorial();
        item.start();
    }

    public void start() {

        try {
            int enteredInteger = connectUser();
            long result = getFactorial(connectUser());
            System.out.println("Factorial of " + enteredInteger + " = " + result);
        } catch (NumberFormatException nfe) {
            System.out.println("[Error]: Entered data isn't integer.");
        } catch (NegativeIntegerException nie) {
            System.out.println("[Error]: Entered number is " + nie.getValue() + ". Number should " +
                    "be" + " > 0.");
        } catch (LimitException ex) {
            System.out.println("[Error]: Entered number is " + ex.getValue() + ". Number should " +
                    "be" + " <= 20 .");
        }
    }

    public int connectUser() throws NumberFormatException, NegativeIntegerException,
            LimitException {
        int enteredInteger;
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter positive integer <= 20");
            enteredInteger = Integer.parseInt(in.next());
            checkInteger(enteredInteger);
        }

        return enteredInteger;
    }

    public void checkInteger(int enteredInteger) throws NegativeIntegerException, LimitException {
        if (enteredInteger < 1) {
            throw new NegativeIntegerException(enteredInteger);
        }
        if (enteredInteger > 20) {
            throw new LimitException(enteredInteger);
        }
    }

    private long getFactorial(int positiveInteger) {
        long result = 1;
        for (int i = 1; i <= positiveInteger; i++) {
            result *= i;
        }
        return result;
    }


}
