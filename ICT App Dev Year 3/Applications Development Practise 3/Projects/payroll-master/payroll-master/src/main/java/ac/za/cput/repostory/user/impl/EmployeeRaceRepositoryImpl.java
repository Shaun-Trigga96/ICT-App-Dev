package ac.za.cput.repostory.user.impl;

import ac.za.cput.domain.user.EmployeeRace;
import ac.za.cput.repostory.user.EmployeeRaceRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRaceRepositoryImpl implements EmployeeRaceRepository {

    private static EmployeeRaceRepository employeeRaceRepository = null;
    private Set<EmployeeRace> employeeRaces;

    private EmployeeRaceRepositoryImpl() {
        this.employeeRaces = new HashSet<>();
    }

    public static EmployeeRaceRepository getEmployeeRaceRepository() {
        if (employeeRaceRepository == null) employeeRaceRepository = new EmployeeRaceRepositoryImpl();
        return employeeRaceRepository;
    }

    @Override
    public EmployeeRace create(EmployeeRace employeeRace) {
        this.employeeRaces.add(employeeRace);
        return employeeRace;
    }

    @Override
    public EmployeeRace read(String s) {
        return this.employeeRaces.stream().filter(er -> er.getEmployeeEmail().equalsIgnoreCase(s)).findAny().orElse(null);
    }

    @Override
    public EmployeeRace update(EmployeeRace employeeRace) {
        EmployeeRace er = read(employeeRace.getEmployeeEmail());
        if (er != null) {
            delete(er.getEmployeeEmail());
            return create(employeeRace);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        EmployeeRace employeeRace = read(s);
        if (employeeRace != null) {
            this.employeeRaces.remove(employeeRace);
        }
    }
}
