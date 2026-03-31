package ac.za.cput.domain.user;

public class EmployeeRace {

    private String employeeEmail, raceId;

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getRaceId() {
        return raceId;
    }

    public EmployeeRace(String employeeEmail, String raceId) {
        this.employeeEmail = employeeEmail;
        this.raceId = raceId;
    }
}
