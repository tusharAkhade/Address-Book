import java.util.ArrayList;
import java.util.Scanner;

/**
 * Getting input from user and set that input in the constructor
 * And adding contact to address book
 * And editing person details
 * And deleting the contact
 * @author Tushar Akhade
 * @since 17 Jun 2021
 * @version 1.0
 */
public class AddressBookSystem {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Contact> contactArrayList = new ArrayList<Contact>();

    public static void main(String[] args) {

        Contact contact = new Contact();
        System.out.println("Press 1 - Add contact\nPress 2 - Edit Contact\nPress 3 - Delete contact");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addContact(contact, contactArrayList);
                break;
            case 2:
                editContact(contact);
                break;
            case 3:
                deleteContact(contact);
            default:
                System.out.println("Invalid input");
        }



    }

    // adding contact to the address book
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

    // edit the contact
    public static void editContact(Contact contact) {
        System.out.print("Enter a first name: ");
        String firstName = scanner.next();
        System.out.print("Enter a last name: ");
        String lastName = scanner.next();
        for (int i=0; i<contactArrayList.size(); i++) {
            if (contactArrayList.get(i).getFirstName().equals(firstName) && contactArrayList.get(i).getLastName().equals(lastName)) {
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

                for (Contact c: contactArrayList) {
                    System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getAddress() + " " + c.getCity() + " " + c.getState() + " "  + c.getZipCode()
                            + " " + c.getPhoneNumber() + " " + c.getEmail());
                }
            }
        }
    }

    // deleting the contact
    public static void deleteContact(Contact contact) {
        System.out.print("Enter a first name: ");
        String firstName = scanner.next();
        System.out.print("Enter a last name: ");
        String lastName = scanner.next();
        for (int i=0; i<contactArrayList.size(); i++) {
            if (contactArrayList.get(i).getFirstName().equals(firstName) && contactArrayList.get(i).getLastName().equals(lastName)) {
                contactArrayList.remove(i);
            }
        }
    }
}
