package go.azabelin.homework2;

public class MyArrayDataException extends Exception {
    private int i, j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public String toString() {
        return String.format("Could not parse int in array[%d][%d]", this.i, this.j);
    }
}
