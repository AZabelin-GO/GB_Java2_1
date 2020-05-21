package go.azabelin.homework2;

public class Main {

    public static int calculateSumInArray(String[][] inputArray) throws MyArraySizeException, MyArrayDataException {
        if(inputArray.length !=4) {
            throw new MyArraySizeException();
        }

        for (String[] strings : inputArray) {
            if (strings.length != 4) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[1].length; j++) {
                try {
                    sum += Integer.parseInt(inputArray[i][j]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3", "4", "5"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};;

        try {
            System.out.println(calculateSumInArray(array));
        } catch (MyArraySizeException | MyArrayDataException myException) {
            System.out.println(myException);
        }

    }
}
