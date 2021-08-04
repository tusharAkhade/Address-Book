package service;

import model.Person;

import java.util.ArrayList;
import java.util.HashMap;

public interface PersonServiceInterface {
    public  abstract ArrayList<Person> addPersonInfo(ArrayList<Person> personArrayList);
    public abstract ArrayList<Person> editPersonInfo(ArrayList<Person> personArrayList);
    public abstract ArrayList<Person> deletePersonInfo(ArrayList<Person> personArrayList);
    public abstract void viewPersonInfo(ArrayList<Person> personArrayList);
    public abstract void sortPersonByName(HashMap<String, ArrayList<Person>> addressBooks);
    public abstract void sortPersonByState(HashMap<String, ArrayList<Person>> addressBooks);
    public abstract void sortPersonByCity(HashMap<String, ArrayList<Person>> addressBooks);
    public abstract void sortPersonByZip(HashMap<String, ArrayList<Person>> addressBooks);
}
