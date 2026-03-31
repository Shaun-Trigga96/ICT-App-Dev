package ac.za.cput.domain.user;

public class Employee {

    private String email, firstName, lastName;

    private Employee(){}

    public Employee(Builder builder) {
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;

    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder{
        private String email, firstName, lastName;

        public Builder email(String email) {
            this.email = email;
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

        public Builder copy(Employee employee) {
            this.email = employee.email;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;

            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
