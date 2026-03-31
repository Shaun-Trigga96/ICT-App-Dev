package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: Muhammad Yaasin Cole
 * Student Number: 218340869
 *
 */
@Entity
public class User {

    @Id
    private String userId;

    private String firstName,lastName, address, idNumber, email, cellNumber;

    public User() {}

    private User(userBuilder userBuilder)
    {
        this.userId = userBuilder.userId;
        this.address = userBuilder.address;
        this.idNumber = userBuilder.idNumber;
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
        this.cellNumber = userBuilder.cellNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public static class userBuilder
    {
        private String firstName,lastName,userId, address, idNumber,email,cellNumber;


        public userBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public userBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public userBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public userBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public userBuilder setIdNumber(String idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public userBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public userBuilder setCellNumber(String cellNumber) {
            this.cellNumber = cellNumber;
            return this;
        }

        public userBuilder copy(User user)
        {
            this.userId = user.userId;
            this.address = user.address;
            this.idNumber = user.idNumber;
            this.firstName = user.firstName;
            this.lastName = user.lastName;

            return this;

        }

        public User build()
        {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", email='" + email + '\'' +
                ", cellNumber='" + cellNumber + '\'' +
                '}';
    }
}