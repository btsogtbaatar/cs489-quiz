package miu.edu.cs489.quiz.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Contact {
    private String firstName;
    private String lastName;
    private String company;
    private String jobTitle;
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    private List<EmailAddress> emailAddresses = new ArrayList<>();

    public Contact(String firstName, String lastName, String company, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.jobTitle = jobTitle;
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    public void addEmailAddress(EmailAddress emailAddress) {
        this.emailAddresses.add(emailAddress);
    }

    private String getPhoneNumbersJsonString() {
        String json = this.phoneNumbers.stream().map(PhoneNumber::toJsonString)
                .collect(Collectors.joining(","));

        return String.format("[%s]", json);
    }

    private String getEmailAddressesJsonString() {
        String json = this.emailAddresses.stream().map(EmailAddress::toJsonString)
                .collect(Collectors.joining(","));

        return String.format("[%s]", json);
    }

    public String toJsonString() {
        var phoneNumbersString = this.getPhoneNumbersJsonString();
        var emailAddressesString = this.getEmailAddressesJsonString();

        return String.format(
                "\t{\"firstName\": \"%s\", \"lastName\": \"%s\", \"company\": \"%s\", \"jobTitle\": \"%s\", \"phoneNumbers\": %s, \"emailAddresses\": %s}%n",
                firstName, lastName, company, jobTitle, phoneNumbersString, emailAddressesString);
    }
}
