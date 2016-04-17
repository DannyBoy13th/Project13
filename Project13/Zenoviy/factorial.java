package main.Proekt;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number from 1 to 170");
        String number= scanner.next();
            start(number);
        }

    public static void start(String number) {

        try {
            checkInteger(number);
            double result = getFactorial(number);

            System.out.println("Factorial of " +  number + " = " + result);
        }
        catch (NumberFormatException ine) {
                System.out.println("[Error]: Entered data isn't integer.");
        } catch (NegativeIntegerException nie) {
            System.out.println("[Error]: Entered number is " + nie.getValue() + ". Number should " +
                    "be" + " >= 1 .");
        } catch (LimitException ex) {
            System.out.println("[Error]: Entered number is " + ex.getValue() + ". Number should " +
                    "be" + " <= 170 .");
        }
    }

    public static void checkInteger(String number) throws NumberFormatException,  NegativeIntegerException, LimitException {

        Integer i = Integer.valueOf(number);
        if (i < 1) {
            throw new NegativeIntegerException(i);
        }
        if (i > 170) {
            throw new LimitException(i);
        }
    }

    public static Double getFactorial(String number) {
        double result = 1;
        Integer in = Integer.valueOf(number);
        for (int i = 1; i <= in; i++) {
            result *= i;
        }
        return result;
    }
}
