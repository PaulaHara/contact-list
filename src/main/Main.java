package main;

import contactList.contact.ManageContact;
import contactList.person.Person;

/**
 * @author paula on 16/04/18.
 * @author robson
 * @author sho
 */
public class Main {
    public static void main(String[] args) {
        ManageContact manageContact = new ManageContact();

        try {
            Person person1 = new Person("Maria", "Kar", "maria@mail.com", "(604)555-8569");
            Person person2 = new Person("Joao", "Bla", "joao@mail.com", "(604)558-0015");
            Person person3 = new Person("Alice", "Ko", "alice@mail.com", "(604)577-7845");
            Person person4 = new Person("Bruno", "Mer", "bruno@mail.com", "(604)666-2210");

            manageContact.add(person1);
            manageContact.add(person2);
            manageContact.add(person3);
            manageContact.add(person4);

            manageContact.search(person2.getFullName());

            System.out.println("Listing contact List: ");
            manageContact.list();

            manageContact.remove(person1.getFullName());

            person3.setEmail("newAlice@mail.com");
            person3.setPhoneNumber("(604)999-4529");
            manageContact.update(person3);

            System.out.println("Listing contact List after removing Maria and Updated Alice: ");
            manageContact.list();

            // Error with email
            //Person person5 = new Person("Bruno", "Mer", "brunomail.com", "(604)666-2210");

            // Erro with phone number
            Person person5 = new Person("Bruno", "Mer", "bruno@mail.com", "(604)66-2210");
        }catch (ExceptionInInitializerError e){
            System.out.println("Error creating Person!!");
            System.out.println(e);
        }

    }
}
