package ac.za.cput.repostory.user.impl;

import ac.za.cput.domain.user.EmployeeGender;
import ac.za.cput.repostory.user.EmployeeGenderRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeGenderRepositoryImpl implements EmployeeGenderRepository {

    private static EmployeeGenderRepository employeeGenderRepository = null;
    private Set<EmployeeGender> employeeGenders;

    private EmployeeGenderRepositoryImpl() {
        this.employeeGenders = new HashSet<>();
    }

    public static EmployeeGenderRepository getEmployeeGenderRepository() {
        if (employeeGenderRepository == null) employeeGenderRepository = new EmployeeGenderRepositoryImpl();
        return employeeGenderRepository;
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        this.employeeGenders.add(employeeGender);
        return employeeGender;
    }

    @Override
    public EmployeeGender read(String s) {
        return this.employeeGenders.stream().filter(eg -> eg.getEmployeeEmail().equalsIgnoreCase(s)).findAny().orElse(null);
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        EmployeeGender eg = read(employeeGender.getEmployeeEmail());
        if (eg != null) {
            delete(eg.getEmployeeEmail());
            return create(employeeGender);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        EmployeeGender employeeGender = read(s);
        if (employeeGender != null) this.employeeGenders.remove(employeeGender);
    }
}
