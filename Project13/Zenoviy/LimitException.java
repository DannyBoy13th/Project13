package main.Proekt;

public class LimitException extends Exception{
    private int value;

    public LimitException(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}