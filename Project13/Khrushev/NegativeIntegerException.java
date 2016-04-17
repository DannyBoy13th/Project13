package goit.gojava2.javacore.project13;

class NegativeIntegerException extends Exception {
private int value;

    public NegativeIntegerException(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
