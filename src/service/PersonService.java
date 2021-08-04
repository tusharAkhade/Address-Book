package service;

import model.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Performing a CRED operation on person
 * And printing sorted Person entries in address book alphabetically by Person's first name
 * And also printing sorted entries in address book by City, State or Zip.
 */
public class PersonService implements PersonServiceInterface {
    static Scanner scanner = new Scanner(System.in);

    /**
     * adding person info to the address book
     * @param personArrayList it stores all the persons
     * @return updated personArrayList
     */
    @Override
    public ArrayList<Person> addPersonInfo(ArrayList<Person> personArrayList) {
        Person person = new Person();
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        person.setFirstName(firstName);

        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        person.setLastName(lastName);

        /**
         * Ensure there is no duplicate entry of the same person in a particular address book
         */
        for (int i = 0; i < personArrayList.size(); i++) {
            if (personArrayList.get(i).getFirstName().equals(firstName) && personArrayList.get(i).getLastName().equals(lastName)) {
                System.out.println("Already present.");
                return personArrayList;
            }
        }

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
        System.out.println("Added person info successfully.");
        return personArrayList;
    }

    /**
     * edit the person info from address book
     * @param personArrayList it stores all the persons
     * @return updated personArrayList
     */
    @Override
    public ArrayList<Person> editPersonInfo(ArrayList<Person> personArrayList) {
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

    /**
     * deleting the person info from address book
     * @param personArrayList it stores all the persons
     * @return updated personArrayList
     */
    @Override
    public ArrayList<Person> deletePersonInfo(ArrayList<Person> personArrayList) {
        System.out.print("Enter a first name: ");
        String firstName = scanner.next();
        System.out.print("Enter a last name: ");
        String lastName = scanner.next();
        for (int i=0; i<personArrayList.size(); i++) {
            System.out.println();
            if (personArrayList.get(i).getFirstName().equals(firstName) && personArrayList.get(i).getLastName().equals(lastName)) {
                personArrayList.remove(i);
                return personArrayList;
            }
        }
        return personArrayList;
    }

    /**
     * 'viewPersonInfo()' will show all the persons information inside address book
     * @param personArrayList it stores all the persons
     */
    @Override
    public void viewPersonInfo(ArrayList<Person> personArrayList) {
        for (Person c: personArrayList) {
            System.out.println(c.getFirstName() + " " + c.getLastName() + " " + c.getAddress() + " " + c.getCity() + " " + c.getState() + " "  + c.getZipCode()
                    + " " + c.getPhoneNumber() + " " + c.getEmail());
        }
    }

    /**
     * Printing all the sorted Person entries in address book alphabetically by Person's first name
     * @param addressBooks
     */
    @Override
    public void sortPersonByName(HashMap<String, ArrayList<Person>> addressBooks) {
        addressBooks.keySet().forEach(entry -> {
            List<Person> persons = addressBooks.get(entry)
                    .stream().sorted(Comparator.comparing(Person::getFirstName))
                    .collect(Collectors.toList());
            System.out.println(persons);
        });
    }

    /**
     * Printing all the sorted Person entries in address book by Person's State
     * @param addressBooks
     */
    @Override
    public void sortPersonByState(HashMap<String, ArrayList<Person>> addressBooks) {
        addressBooks.keySet().forEach(entry -> {
            List<Person> persons = addressBooks.get(entry)
                    .stream().sorted(Comparator.comparing(Person::getState))
                    .collect(Collectors.toList());
            System.out.println(persons);
        });
    }

    /**
     * Printing all the sorted Person entries in address book by Person's City
     * @param addressBooks
     */
    @Override
    public void sortPersonByCity(HashMap<String, ArrayList<Person>> addressBooks) {
        addressBooks.keySet().forEach(entry -> {
            List<Person> persons = addressBooks.get(entry)
                    .stream().sorted(Comparator.comparing(Person::getCity))
                    .collect(Collectors.toList());
            System.out.println(persons);
        });
    }

    /**
     * Printing all the sorted Person entries in address book by Person's Zip code
     * @param addressBooks
     */
    @Override
    public void sortPersonByZip(HashMap<String, ArrayList<Person>> addressBooks) {
        addressBooks.keySet().forEach(entry -> {
            List<Person> persons = addressBooks.get(entry)
                    .stream().sorted(Comparator.comparing(Person::getZipCode))
                    .collect(Collectors.toList());
            System.out.println(persons);
        });
    }
}
