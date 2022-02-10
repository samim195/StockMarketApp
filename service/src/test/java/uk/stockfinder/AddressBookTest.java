package uk.stockfinder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

public class AddressBookTest {
    @Test
    public void TestAddressBook() throws Exception {
        URL resource = getClass().getClassLoader().getResource("address.txt");
        File fileName = Paths.get(Objects.requireNonNull(resource).toURI()).toFile();
        AddressBook ab = new AddressBook(String.valueOf(fileName));
        ab.processDataFromFile();
        String address = ab.getAddressByName("James", "Smith").get();
        Assertions.assertEquals("43 Gibbon View Altrincham Manchester", address);
    }
}