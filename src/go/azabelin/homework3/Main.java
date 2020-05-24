package go.azabelin.homework3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static final Random rnd = new Random();

    public static String[] names = {"Max", "Bella", "Simba", "Chloe", "Luna",
            "Max", "Lucy", "Lily", "John", "David",
            "Bender", "Max", "Lucy", "Lily", "John"};

    public static String generatePhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            phoneNumber.append(rnd.nextInt(10));
        }

        return phoneNumber.toString();
    }

    public static void main(String[] args) {
        DuplicatesChecker.printDuplicates(names);

        PhoneBook phoneBook = PhoneBook.getInstance();

        for (int i = 0; i < names.length; i++) {
            phoneBook.add(names[rnd.nextInt(names.length)], generatePhoneNumber());
        }

        System.out.println();

        HashSet<String> tmp = phoneBook.get(names[rnd.nextInt(names.length)]);

        if (tmp != null) {
            System.out.println(Arrays.toString(tmp.toArray()));
        } else {
            System.out.println("Client not found");
        }
    }
}
