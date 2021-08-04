package service;

import model.Person;

import java.util.ArrayList;
import java.util.HashMap;

public interface AddressBookServiceInterface {
    public abstract void addAddressBook(HashMap<String, ArrayList<Person>> addressBook, String companyName, ArrayList<Person> personArrayList);
    public abstract void editAddressBook(HashMap<String, ArrayList<Person>> addressBook, String companyName, ArrayList<Person> personArrayList);
    public abstract void viewAddressBook(HashMap<String, ArrayList<Person>> addressBook);
    public abstract void searchPersonByCityOrState(HashMap<String, ArrayList<Person>> addressBook);
}
