package ac.za.cput.service.user.impl;

import ac.za.cput.domain.user.Employee;
import ac.za.cput.repostory.user.EmployeeRepository;
import ac.za.cput.repostory.user.impl.EmployeeRepositoryImpl;
import ac.za.cput.service.user.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    private EmployeeServiceImpl() {
        this.employeeRepository = EmployeeRepositoryImpl.getEmployeeRepository();
    }

    public static EmployeeService getEmployeeService() {
        if (employeeService == null) employeeService = new EmployeeServiceImpl();
        return employeeService;
    }


    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.create(employee);
    }

    @Override
    public Employee read(String s) {
        return this.employeeRepository.read(s);
    }

    @Override
    public Employee update(Employee employee) {
        return this.employeeRepository.update(employee);
    }

    @Override
    public void delete(String s) {
        this.employeeRepository.delete(s);
    }
}
