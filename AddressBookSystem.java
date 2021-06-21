import java.util.ArrayList;
import java.util.Scanner;

/**
 * Getting input from user and set that input in the constructor
 * And adding contact to address book
 * @author Tushar Akhade
 * @since 17 Jun 2021
 * @version 1.0
 */
public class AddressBookSystem {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contact> contactArrayList = new ArrayList<Contact>();

    public static void main(String[] args) {

        Contact contact = new Contact();

        // adding contact to the address book
        addContact(contact, contactArrayList);

    }

    public static void addContact(Contact contact, ArrayList<Contact> contactArrayList) {
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        contact.setFirstName(firstName);

        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        contact.setLastName(lastName);

        System.out.print("Enter address: ");
        String address = scanner.next();
        contact.setAddress(address);

        System.out.print("Enter city: ");
        String city = scanner.next();
        contact.setCity(city);

        System.out.print("Enter state: ");
        String state = scanner.next();
        contact.setState(state);

        System.out.print("Enter zip: ");
        long zip = scanner.nextLong();
        contact.setZipCode(zip);

        System.out.print("Enter phone no: ");
        long phNumber = scanner.nextLong();
        contact.setPhoneNumber(phNumber);

        System.out.print("Enter email: ");
        String email = scanner.next();
        contact.setEmail(email);

        contactArrayList.add(contact);

        for (Contact c: contactArrayList) {
            System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getAddress() + " " + c.getCity() + " " + c.getState() + " "  + c.getZipCode()
                    + " " + c.getPhoneNumber() + " " + c.getEmail());
        }
    }
}
