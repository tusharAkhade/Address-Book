package service;
import model.Person;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Add, read and view operation on address book
 * And View all Person in particular City or State across multiple address book
 */
public class AddressBookService implements AddressBookServiceInterface {
    Scanner scanner = new Scanner(System.in);
    PersonServiceInterface personServiceInterface = new PersonService();

    /**
     *
     * @param addressBook contains address book of all company
     * @param companyName contains the address book 'key'
     * @param personArrayList contains all the persons information in particular company/address book
     */
    @Override
    public void addAddressBook(HashMap<String, ArrayList<Person>> addressBook, String companyName, ArrayList<Person> personArrayList) {
        // validating to add new address book
        if (!addressBook.containsKey(companyName)) {
            boolean flag = true;
            while (flag) {
                System.out.println("Press 1 to Add person information in " + companyName.toUpperCase() + "\nPress 2 to Exit from " + companyName.toUpperCase() + " address book" );
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        personArrayList = personServiceInterface.addPersonInfo(personArrayList);
                        addressBook.put(companyName, personArrayList);
                        break;
                    default:
                        flag = false;
                        System.out.println("Exit from " + companyName + " address book.");
                }
            }
        } else {
            System.out.println(companyName + " address book already present.");
        }
    }

    /**
     * Editing the address book like
     * 1. add person information into existing address book
     * 2. edit person information from existing address book
     * 3. delete person information from existing address book
     * 4. view all the persons information from existing address book
     * @param addressBook contains address book of all company
     * @param companyName contains the address book 'key'
     * @param personArrayList contains all the persons information in particular company/address book
     */
    @Override
    public void editAddressBook(HashMap<String, ArrayList<Person>> addressBook, String companyName, ArrayList<Person> personArrayList) {
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
                            personArrayList = personServiceInterface.addPersonInfo(personArrayList);
                            break;
                        case 2:
                            personArrayList = personServiceInterface.editPersonInfo(personArrayList);
                            break;
                        case 3:
                            personArrayList = personServiceInterface.deletePersonInfo(personArrayList);
                            break;
                        case 4:
                            personServiceInterface.viewPersonInfo(personArrayList);
                            break;
                        default:
                            flag = false;
                            addressBook.put(companyName, personArrayList);
                            System.out.println("Exit ");
                    }
                }
                // adding contact list to the dictionary (Address book)
                addressBook.put(companyName, personArrayList);
            } else {
                System.out.println("No such address book");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Shows all existing address books name
     * @param addressBook contains all the company/address book
     */
    @Override
    public void viewAddressBook(HashMap<String, ArrayList<Person>> addressBook) {
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

    /**
     * View all Person in particular City or State across multiple address book
     * @param addressBooks contain multiple address book
     */
    @Override
    public void searchPersonByCityOrState(HashMap<String, ArrayList<Person>> addressBooks) {
        Dictionary<String, ArrayList<String>> personsByCity = new Hashtable();
        Dictionary<String, ArrayList<String>> personsByState = new Hashtable();
        System.out.println("Press 1 to view and count persons in particular city\nPress 2 to view and count persons in particular state");
        int choice = scanner.nextInt();
        if (choice == 1) {
            ArrayList<String> personArrayList = new ArrayList<>();
            System.out.println("Enter a city name : ");
            String cityName = scanner.next();
            int personCountInCity = 0;
            System.out.println("People from " + cityName.toUpperCase() + " city are : ");
            for (HashMap.Entry<String, ArrayList<Person>> addressBook : addressBooks.entrySet()) {
                for (int j = 0; j<addressBook.getValue().size(); j++) {
                    if (addressBook.getValue().get(j).getCity().equals(cityName)) {
                        String personName = addressBook.getValue().get(j).getFirstName() + " " + addressBook.getValue().get(j).getLastName();
                        personArrayList.add(personName);
                        personsByCity.put(cityName, personArrayList);
                        personCountInCity++;
                    }
                }
            }
            Enumeration<String> setOfKeys = personsByCity.keys();
            while (setOfKeys.hasMoreElements()) {
                String person = setOfKeys.nextElement();
                System.out.println(personsByCity.get(person));
            }
            System.out.println("Number of Person in " + cityName.toUpperCase() + " : " + personCountInCity);
            System.out.println();
        }
        else if (choice == 2) {
            ArrayList<String> personArrayList = new ArrayList<>();
            System.out.println("Enter a state name : ");
            String stateName = scanner.next();
            int personCountInState = 0;
            System.out.println("People from " + stateName.toUpperCase() + " state are : ");
            for (HashMap.Entry<String, ArrayList<Person>> addressBook : addressBooks.entrySet()) {
                for (int j = 0; j<addressBook.getValue().size(); j++) {
                    if (addressBook.getValue().get(j).getState().equals(stateName)) {
                        String personName = addressBook.getValue().get(j).getFirstName() + " " + addressBook.getValue().get(j).getLastName();
                        personArrayList.add(personName);
                        personsByState.put(stateName, personArrayList);
                        personCountInState++;
                    }
                }
            }
            Enumeration<String> setOfKeys = personsByState.keys();
            while (setOfKeys.hasMoreElements()) {
                String person = setOfKeys.nextElement();
                System.out.println(personsByState.get(person));
            }
            System.out.println("Number of Person in " + stateName.toUpperCase() + " : " + personCountInState);
            System.out.println();
        }
    }

}
