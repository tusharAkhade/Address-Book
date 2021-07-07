package service;

import model.Person;

import java.util.ArrayList;

public interface PersonServiceInterface {
    public  abstract ArrayList<Person> addPersonInfo(ArrayList<Person> personArrayList);
    public abstract ArrayList<Person> editPersonInfo(ArrayList<Person> personArrayList);
    public abstract ArrayList<Person> deletePersonInfo(ArrayList<Person> personArrayList);
    public abstract void viewPersonInfo(ArrayList<Person> personArrayList);
}
