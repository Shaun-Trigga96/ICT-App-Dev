package ac.za.cput.repostory.user.impl;

import ac.za.cput.domain.user.Employee;
import ac.za.cput.repostory.user.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private Set<Employee> employees;
    private static EmployeeRepository employeeRepository;

    private EmployeeRepositoryImpl() {
        this.employees = new HashSet<>();
    }

    public static EmployeeRepository getEmployeeRepository() {
        if (employeeRepository == null) employeeRepository = new EmployeeRepositoryImpl();
        return employeeRepository;
    }


    @Override
    public Employee create(Employee employee) {
        this.employees.add(employee);
        return employee;
    }

    @Override
    public Employee read(String s) {
        Employee employee = this.employees.stream()
                .filter(e -> e.getEmail().equalsIgnoreCase(s))
                .findAny().orElse(null);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee emp = read(employee.getEmail());
        if (emp != null) {
            Employee updated = new Employee.Builder().copy(emp)
                    .firstName(employee.getFirstName())
                    .build();
            delete(emp.getEmail());
            this.employees.add(updated);
            emp = updated;
        }
        return emp;
    }

    @Override
    public void delete(String s) {
        Employee employee = read(s);
        this.employees.remove(employee);
    }
}
