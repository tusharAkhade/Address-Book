import java.util.*;

/**
 * We are storing multiple address book
 * each address book contains multiple person information
 *
 * @author Tushar Akhade
 * @since 17 Jun 2021
 * @version 2.0
 */

public class AddressBookSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, ArrayList<Person>> addressBook = new HashMap<String, ArrayList<Person>>();

        while (true) {
            System.out.println("Press 1 to Create new Address book\nPress 2 to edit address books\nPress 3 to view all the address books names.\nPress 4 to Exit");
            int op = scanner.nextInt();

            if (op == 1) {
                ArrayList<Person> personArrayList = new ArrayList<Person>();
                System.out.println("Enter a company name : ");
                String companyName = scanner.next();
                // validating to add new address book
                if (!addressBook.containsKey(companyName)) {
                    boolean flag = true;
                    while (flag) {
                        Person person = new Person();
                        System.out.println("Press 1 to Add contact in " + companyName + "\nPress 2 to Exit from " + companyName );
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                personArrayList = addContact(person, personArrayList);
                                addressBook.put(companyName, personArrayList);
                                System.out.println("Added person info in " + companyName + " successfully.");
                                break;
                            default:
                                flag = false;
                                System.out.println("Exit from " + companyName + " address book.");
                        }
                    }
                } else {
                    System.out.println(companyName + " address book already present.");
                }
                System.out.println("");
            }

            // Edit the existed address book
            else if (op == 2) {
                ArrayList<Person> personArrayList = new ArrayList<Person>();
                System.out.println("Enter a address book name : ");
                String companyName = scanner.next();
                try {
                    if (addressBook.containsKey(companyName)) {
                        personArrayList = (ArrayList<Person>) addressBook.get(companyName);
                        boolean flag = true;
                        while (flag) {
                            Person person = new Person();
                            System.out.println("Press 1 to Add contact in " + companyName + "\nPress 2 to Edit Contact from " + companyName + "\nPress 3 to Delete contact from " + companyName + "\nPress 4 to View contact from " + companyName + "\nPress 5 to Exit " + companyName);
                            int choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    personArrayList = addContact(person, personArrayList);
                                    break;
                                case 2:
                                    personArrayList = editContact(person, personArrayList);
                                    break;
                                case 3:
                                    personArrayList = deleteContact(person, personArrayList);
                                    break;
                                case 4:
                                    viewContact(personArrayList);
                                    break;
                                default:
                                    flag = false;
                                    addressBook.put(companyName, personArrayList);
                                    System.out.println("Exit ");
                            }
                        }
                        // adding contact list to the dictionary (Address book)
                        addressBook.put(companyName, personArrayList);
                        break;
                    } else {
                        System.out.println("No such address book");
                    }
                } catch (Exception e) {
                    System.out.println("No such address book");
                    break;
                }

            }

            // shows address book names
            else if (op == 3) {
                if (!addressBook.isEmpty()) {
                    System.out.println("Address book names : ");
                    for (String key : addressBook.keySet()) {
                        System.out.print(key);
                    }
                    System.out.println();
                } else {
                    System.out.println("Address book is empty.");
                }
            }

            // exit
            else {
                break;
            }
        }
    }

    // adding person info to the address book
    public static ArrayList<Person> addContact(Person person, ArrayList<Person> personArrayList) {
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        person.setFirstName(firstName);

        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        person.setLastName(lastName);

        System.out.print("Enter address: ");
        String address = scanner.next();
        person.setAddress(address);

        System.out.print("Enter city: ");
        String city = scanner.next();
        person.setCity(city);

        System.out.print("Enter state: ");
        String state = scanner.next();
        person.setState(state);

        System.out.print("Enter zip: ");
        long zip = scanner.nextLong();
        person.setZipCode(zip);

        System.out.print("Enter phone no: ");
        long phNumber = scanner.nextLong();
        person.setPhoneNumber(phNumber);

        System.out.print("Enter email: ");
        String email = scanner.next();
        person.setEmail(email);

        personArrayList.add(person);
        return personArrayList;
    }

    // edit the person info from address book
    public static ArrayList<Person> editContact(Person person, ArrayList<Person> personArrayList) {

        System.out.print("Enter a first name: ");
        String firstName = scanner.next();
        System.out.print("Enter a last name: ");
        String lastName = scanner.next();
        for (int i=0; i<personArrayList.size(); i++) {
            if (personArrayList.get(i).getFirstName().equals(firstName) && personArrayList.get(i).getLastName().equals(lastName)) {
                System.out.print("Enter address: ");
                String address = scanner.next();
                personArrayList.get(i).setAddress(address);

                System.out.print("Enter city: ");
                String city = scanner.next();
                personArrayList.get(i).setCity(city);

                System.out.print("Enter state: ");
                String state = scanner.next();
                personArrayList.get(i).setState(state);

                System.out.print("Enter zip: ");
                long zip = scanner.nextLong();
                personArrayList.get(i).setZipCode(zip);

                System.out.print("Enter phone no: ");
                long phNumber = scanner.nextLong();
                personArrayList.get(i).setPhoneNumber(phNumber);

                System.out.print("Enter email: ");
                String email = scanner.next();
                personArrayList.get(i).setEmail(email);

                return personArrayList;
            }
        }
        return personArrayList;
    }

    // deleting the person info from address book
    public static ArrayList<Person> deleteContact(Person person, ArrayList<Person> personArrayList) {
        System.out.print("Enter a first name: ");
        String firstName = scanner.next();
        System.out.print("Enter a last name: ");
        String lastName = scanner.next();
        for (int i=0; i<personArrayList.size(); i++) {
            if (personArrayList.get(i).getFirstName().equals(firstName) && personArrayList.get(i).getLastName().equals(lastName)) {
                personArrayList.remove(i);
            }
            return personArrayList;
        }
        return personArrayList;
    }

    // 'viewContact()' will show all the persons information inside address book
    public static void viewContact(ArrayList<Person> personArrayList) {
        for (Person c: personArrayList) {
            System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getAddress() + " " + c.getCity() + " " + c.getState() + " "  + c.getZipCode()
                    + " " + c.getPhoneNumber() + " " + c.getEmail());
        }
    }
}
