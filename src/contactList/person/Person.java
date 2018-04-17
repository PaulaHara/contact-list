package contactList.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author paula on 16/04/18.
 * @author robson
 * @author sho
 */
public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String fullName;

    public Person(String firstName, String lastName, String email, String phoneNumber) throws ExceptionInInitializerError{
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;

        if(isValidEmail(email)) {
            this.email = email;
        }else{
            throw new ExceptionInInitializerError();
        }

        if(isValidPhone(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }else{
            throw new ExceptionInInitializerError();
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(isValidEmail(email)) {
            this.email = email;
        }else{
            System.out.println("Not a valid email!");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(isValidPhone(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }else{
            System.out.println("Not a valid phone number!");
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private boolean isValidEmail(String email){
        String regex = new String("^(.+)@(.+)$");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPhone(String phoneNumber){
        String regex = new String("^(\\()[0-9]{3}(\\))[0-9]{3}(\\-)[0-9]{4}$");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    @Override
    public int compareTo(Person person) {
        if(person != null) {
            return this.getFullName().compareToIgnoreCase(person.getFullName());
        }
        return 1;
    }
}
