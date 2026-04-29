package ac.za.cput.factory.user;

import ac.za.cput.domain.user.Employee;
import ac.za.cput.util.Misc;

public class EmployeeFactory {

    public static Employee buildEmployee(String email, String firstName, String lastName) {
        return new Employee.Builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
