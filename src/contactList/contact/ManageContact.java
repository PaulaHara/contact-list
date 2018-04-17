package contactList.contact;

import contactList.person.Person;

import java.util.*;

/**
 * @author paula on 16/04/18.
 * @author robson
 * @author sho
 */
public class ManageContact {

    private HashMap<String, Person> contactList = new HashMap<>();

    public void add(Person person){
        contactList.put(person.getFullName(), person);
    }

    public void remove(String fullName){
        if(contactList.containsKey(fullName)) {
            contactList.remove(fullName);
        }else{
            System.out.println("Contact not found!");
        }
    }

    public Person search(String fullName){
        if(contactList.containsKey(fullName)) {
            return contactList.get(fullName);
        }
        System.out.println("Contact not found!");
        return null;
    }

    public void list(){
        SortedSet<Person> values = new TreeSet<Person>(contactList.values());

        for(Person person : values){
            System.out.println("First Name: " + person.getFirstName());
            System.out.println("Last Name: " + person.getLastName());
            System.out.println("Email: " + person.getEmail());
            System.out.println("Phone Number: " + person.getPhoneNumber());
            System.out.println("Full name: " + person.getFullName());
            System.out.println("\n");
        }
    }

    public void update(Person person){
        contactList.replace(person.getFullName(), person);
    }

    public HashMap<String, Person> getContactList() {
        return contactList;
    }

    public void setContactList(HashMap<String, Person> contactList) {
        this.contactList = contactList;
    }
}
