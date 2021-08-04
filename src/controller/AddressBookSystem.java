package controller;

import model.Person;
import service.AddressBookService;
import service.AddressBookServiceInterface;
import service.PersonService;
import service.PersonServiceInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created a address book system
 * Each address book contains multiple persons information
 * @author Tushar Akhade
 * @since 4 Jul 2021
 * @version 1.0
 */
public class AddressBookSystem {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, ArrayList<Person>> addressBook = new HashMap<String, ArrayList<Person>>();
        AddressBookServiceInterface addressBookServiceInterface = new AddressBookService();
        PersonServiceInterface personServiceInterface = new PersonService();

        boolean flag = true;
        while (flag) {
            System.out.println("Press 1 to Create new Address book\nPress 2 to edit address books" +
                    "\nPress 3 to view all the address books names." +
                    "\nPress 4 to view and count all the persons in particular city or state." +
                    "\nPress 5 to sort the person by Name, State, City or Zip\nPress 6 to Exit");
            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    ArrayList<Person> personArrayList = new ArrayList<Person>();
                    System.out.println("Enter a company/address book name : ");
                    String companyName = scanner.next();
                    addressBookServiceInterface.addAddressBook(addressBook, companyName, personArrayList);
                    System.out.println("");
                    break;
                case 2:
                    ArrayList<Person> personArrayList1 = new ArrayList<Person>();
                    System.out.println("Enter a company/address book name : ");
                    String companyName1 = scanner.next();
                    addressBookServiceInterface.editAddressBook(addressBook, companyName1, personArrayList1);
                    break;
                case 3:
                    addressBookServiceInterface.viewAddressBook(addressBook);
                    break;
                case 4:
                    addressBookServiceInterface.searchPersonByCityOrState(addressBook);
                    break;
                case 5:
                    System.out.println("Press 1 to Sort Persons by Name\nPress 2 to Sort Persons by State" +
                            "\nPress 3 to Sort Persons by City\nPress 4 to Sort Persons by Zip");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> personServiceInterface.sortPersonByName(addressBook);
                        case 2 -> personServiceInterface.sortPersonByState(addressBook);
                        case 3 -> personServiceInterface.sortPersonByCity(addressBook);
                        case 4 -> personServiceInterface.sortPersonByZip(addressBook);
                    }
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}
