package goit.gojava2.javacore.project13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciSequence {
    public static void main(String[] args) {
        FibonacciSequence fibSeq = new FibonacciSequence();
        fibSeq.start();
    }

    public void start() {

        try {
            int enteredInteger = connectUser();
            List<Integer> result = getFibSeq(enteredInteger);
            System.out.println("Fibonacci sequence < " + enteredInteger + " = " + result);
        } catch (NumberFormatException nfe) {
            System.out.println("[Error]: Entered data isn't integer.");
        } catch (NegativeIntegerException nie) {
            System.out.println("[Error]: Entered number is " + nie.getValue() + ". Number should " +
                    "be" + " > 0.");
        }
    }

    private int connectUser() throws NumberFormatException, NegativeIntegerException {
        int enteredInteger;

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter positive integer");

            enteredInteger = Integer.parseInt(in.next());
            checkInteger(enteredInteger);
        }

        return enteredInteger;
    }

    private void checkInteger(int enteredInteger) throws NegativeIntegerException {
        if (enteredInteger < 1) {
            throw new NegativeIntegerException(enteredInteger);
        }
    }

    private List<Integer> getFibSeq(int limit) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(1);
        sequence.add(1);
        for (int i = 2; sequence.get(i - 1) + sequence.get(i - 2) < limit; i++) {
            sequence.add(i, sequence.get(i - 1) + sequence.get(i - 2));
        }
        return sequence;

    }
}
