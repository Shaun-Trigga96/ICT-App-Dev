package ac.za.cput.domain.user;

import java.util.Objects;

public class EmployeeGender {
    private String employeeEmail, genderId;

    private EmployeeGender() {}

    public EmployeeGender(String employeeEmail, String genderId) {
        this.employeeEmail = employeeEmail;
        this.genderId = genderId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getGenderId() {
        return genderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeGender that = (EmployeeGender) o;
        return employeeEmail.equals(that.employeeEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeEmail);
    }
}
