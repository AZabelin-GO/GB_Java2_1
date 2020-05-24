package go.azabelin.homework3;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private static PhoneBook instance = null;

    private HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

    public PhoneBook() {
    }

    public static PhoneBook getInstance() {
        if (instance == null) {
            instance = new PhoneBook();
        }

        return instance;
    }

    public void add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phone);
        } else {
            HashSet<String> tmpPhones = new HashSet<>();
            tmpPhones.add(phone);
            phoneBook.put(name, tmpPhones);
        }
    }

    public HashSet<String> get(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }

        return null;
    }
}
