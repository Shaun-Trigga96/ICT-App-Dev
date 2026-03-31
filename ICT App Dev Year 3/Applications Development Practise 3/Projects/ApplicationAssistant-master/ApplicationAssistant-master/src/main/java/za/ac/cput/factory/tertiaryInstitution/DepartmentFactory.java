package za.ac.cput.factory.tertiaryInstitution;

import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.util.GenericHelper;
import za.ac.cput.util.StringHelper;

public class DepartmentFactory {

    public static Department createDepartment(String departmentName, String departmentCode)
    {
        if (StringHelper.isNullorEmpty(departmentName)) return new Department.Builder().build();
        if (StringHelper.isNullorEmpty(departmentCode)) return new Department.Builder().build();
        String departmentId = GenericHelper.generateRandom();
        Department verification = new Department.Builder()
                .setDepartmentId(departmentId)
                .setDepartmentName(departmentName)
                .setDepartmentCode(departmentCode)
                .build();
        return verification;
    }
}
