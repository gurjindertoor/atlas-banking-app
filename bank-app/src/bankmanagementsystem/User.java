package bankmanagementsystem;

public class User {
    String random, firstName, lastName, dob, address, city, state, zipcode, email, confirmEmail, gender, maritalStatus, ownOrRent, occupation, education, income, phoneNumber, mobileNumber, accountType, username, password;

    User(String random, String firstName, String lastName, String dob, String address, String city, String state, String zipcode, String email, String confirmEmail, String username, String password){
        this.random = random;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.email = email;
        this.confirmEmail = email;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.ownOrRent = ownOrRent;
        this.occupation = occupation;
        this.education = education;
        this.income = income;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.accountType = accountType;
        this.username = username;
        this.password = password;
    }
}
