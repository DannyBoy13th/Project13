package Project13.Khrushev;

class NegativeIntegerException extends Exception {
private int value;

    public NegativeIntegerException(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
