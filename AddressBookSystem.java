import java.util.Scanner;

/**
 * Getting input from user and set that input in the constructor
 * @author Tushar Akhade
 * @since 17 Jun 2021
 * @version 1.0
 */
public class AddressBookSystem {
    String firstName, lastName, address, city, state, email;
    long phoneNumber, zipCode;

    public void AddressBookSystem(String firstName, String lastName, String address, String city, String state, String email, long phoneNumber, long zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter address: ");
        String address = scanner.next();
        System.out.print("Enter city: ");
        String city = scanner.next();
        System.out.print("Enter state: ");
        String state = scanner.next();
        System.out.print("Enter zip: ");
        long zip = scanner.nextLong();
        System.out.print("Enter phone no: ");
        long phNumber = scanner.nextLong();
        System.out.print("Enter email: ");
        String email = scanner.next();

        AddressBookSystem addressBookSystem = new AddressBookSystem(firstName, lastName, address, city, state, email, phNumber, zip);

    }
}
