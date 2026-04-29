package ac.za.cput.service.user.impl;

import ac.za.cput.domain.user.EmployeeGender;
import ac.za.cput.repostory.user.EmployeeGenderRepository;
import ac.za.cput.repostory.user.impl.EmployeeGenderRepositoryImpl;
import ac.za.cput.service.user.EmployeeGenderService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeGenderServiceImpl implements EmployeeGenderService {

    private static EmployeeGenderService employeeGenderService = null;
    private EmployeeGenderRepository employeeGenderRepository;

    private EmployeeGenderServiceImpl() {
        this.employeeGenderRepository = EmployeeGenderRepositoryImpl.getEmployeeGenderRepository();
    }

    public static EmployeeGenderService getEmployeeGenderService() {
        if (employeeGenderService == null) employeeGenderService = new EmployeeGenderServiceImpl();
        return employeeGenderService;
    }


    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        return this.employeeGenderRepository.create(employeeGender);
    }

    @Override
    public EmployeeGender read(String s) {
        return this.employeeGenderRepository.read(s);
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        return this.employeeGenderRepository.update(employeeGender);
    }

    @Override
    public void delete(String s) {
        this.employeeGenderRepository.delete(s);
    }
}
