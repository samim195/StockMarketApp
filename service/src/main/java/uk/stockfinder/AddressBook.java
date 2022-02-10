package uk.stockfinder;

import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Getter
public class AddressBook {
    private final List<String> firstNames = new ArrayList<>();
    int firstNameCount = 0;
    private final List<String> lastNames = new ArrayList<>();
    int lastNameCount = 0;
    private final List<String> addresses = new ArrayList<>();
    int addressCount = 0;

    private final String filename;

    public AddressBook(String filename) {
        this.filename = filename;
    }

    public Scanner scanFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File((filename)));
        sc.useDelimiter(",");
        return sc;
    }

    public void processDataFromFile() throws Exception {
        Scanner sc = scanFile();
        int bitCount = 0;
        while (sc.hasNext()) {
            String bit = sc.next();
            switch (bitCount++) {
                case 0:
                    //first name
                    firstNames.add(bit);
                    break;
                case 1:
                    //second name
                    lastNames.add(bit);
                    break;
                case 2:
                    addresses.add(bit);
                    break;
            }
            if (bitCount > 2)
                bitCount = 0;
        }
    }
        public void add(String firstName, String lastName, String address){
            firstNames.add(firstName);
            lastNames.add(lastName);
            addresses.add(address);
        }
        public Optional<String> getAddressByName (String firstName, String lastName){
            for (int idx = 0; idx < 999; idx++) {
                if (firstNames.get(idx).equals(firstName) && lastNames.get(idx).equals(lastName)) {
                    return Optional.of(addresses.get(idx));
                }
            }
            return Optional.empty();
        }
    }
