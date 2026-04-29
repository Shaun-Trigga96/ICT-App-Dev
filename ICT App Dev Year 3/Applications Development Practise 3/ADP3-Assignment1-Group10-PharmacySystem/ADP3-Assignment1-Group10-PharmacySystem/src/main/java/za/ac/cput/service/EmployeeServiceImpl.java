package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;

    @Autowired
    EmployeeServiceImpl(EmployeeRepository repository){
        this.repository = repository;
    }

    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Employee read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public boolean delete(String s) {
        if (this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAll() {
        return this.repository.findAll();
    }

}
