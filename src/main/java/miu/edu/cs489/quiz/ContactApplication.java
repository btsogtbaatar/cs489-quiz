package miu.edu.cs489.quiz;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import miu.edu.cs489.quiz.model.Contact;
import miu.edu.cs489.quiz.model.EmailAddress;
import miu.edu.cs489.quiz.model.PhoneNumber;

public class ContactApplication {
    private static void printContacts(List<Contact> contacts) {
        String json = contacts.stream().map(Contact::toJsonString).collect(Collectors.joining(","));
        System.out.println("Printing contacts in JSON format:");
        System.out.println(String.format("[%n%s]", json));
    }

    public static void main(String[] args) {
        var contact1 = new Contact("David", "Sanger", "Argos LLC", "Sales Manager");

        contact1.addPhoneNumber(new PhoneNumber("240-133-0011", "Home"));
        contact1.addPhoneNumber(new PhoneNumber("240-112-0123", "Mobile"));
        contact1.addEmailAddress(new EmailAddress("dave.sang@gmail.com", "Home"));
        contact1.addEmailAddress(new EmailAddress("dsanger@argos.com", "Work"));

        var contact2 = new Contact("Carlos", "Jimenez", "Zappos", "Director");

        var contact3 = new Contact("Ali", "Gafar", "BMI Services", "HR Manager");
        contact3.addPhoneNumber(new PhoneNumber("412-116-9988", "Work"));
        contact3.addEmailAddress(new EmailAddress("ali@bmi.com", "Work"));

        var list = List.of(contact1, contact2, contact3).stream().sorted(Comparator.comparing(Contact::getLastName))
                .toList();

        printContacts(list);
    }
}