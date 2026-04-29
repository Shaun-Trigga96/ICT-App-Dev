package ac.za.cput.adp3.xyzcongolmerate.domain.user;

/**
 * DO NOT MODIFY!
 */
public class User {

    private String userEmail, firstName, lastName;

    private User() {}

    public User(Builder builder) {
        this.userEmail = builder.userEmail;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + userEmail + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder {
        private String userEmail, firstName, lastName;

        public Builder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(User user) {
            this.lastName = user.lastName;
            this.firstName = user.firstName;
            this.userEmail = user.userEmail;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
