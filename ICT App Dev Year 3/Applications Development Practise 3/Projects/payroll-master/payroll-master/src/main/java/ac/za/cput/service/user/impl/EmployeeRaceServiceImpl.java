package ac.za.cput.service.user.impl;

import ac.za.cput.domain.user.EmployeeRace;
import ac.za.cput.repostory.user.EmployeeRaceRepository;
import ac.za.cput.repostory.user.impl.EmployeeRaceRepositoryImpl;
import ac.za.cput.service.user.EmployeeRaceService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRaceServiceImpl implements EmployeeRaceService {

    private static EmployeeRaceService employeeRaceService = null;
    private EmployeeRaceRepository employeeRaceRepository;

    private EmployeeRaceServiceImpl() {
        this.employeeRaceRepository = EmployeeRaceRepositoryImpl.getEmployeeRaceRepository();
    }

    public static EmployeeRaceService getEmployeeRaceService () {
        if (employeeRaceService == null) employeeRaceService = new EmployeeRaceServiceImpl();
        return employeeRaceService;
    }

    @Override
    public EmployeeRace create(EmployeeRace employeeRace) {
        return this.employeeRaceRepository.create(employeeRace);
    }

    @Override
    public EmployeeRace read(String s) {
        return this.employeeRaceRepository.read(s);
    }

    @Override
    public EmployeeRace update(EmployeeRace employeeRace) {
        return this.employeeRaceRepository.update(employeeRace);
    }

    @Override
    public void delete(String s) {
        this.employeeRaceRepository.delete(s);
    }
}
