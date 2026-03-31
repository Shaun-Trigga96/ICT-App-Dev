package ac.za.cput.factory.user;

import ac.za.cput.domain.user.EmployeeRace;

public class EmployeeRaceFactory {

    public static EmployeeRace buildEmployeeRace(String employeeEmail, String raceId) {
        return new EmployeeRace(employeeEmail, raceId);
    }
}
