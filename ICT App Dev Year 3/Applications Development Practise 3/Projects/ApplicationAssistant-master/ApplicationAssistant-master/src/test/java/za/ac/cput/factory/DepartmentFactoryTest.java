package za.ac.cput.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.factory.tertiaryInstitution.DepartmentFactory;

public class DepartmentFactoryTest {

    @Test
    public void createDepartment() {

        Department verification = DepartmentFactory.createDepartment( "Information Technology", "IT");

        Assert.assertEquals("Information Technology", verification.getDepartmentName());
        Assert.assertEquals("IT", verification.getDepartmentCode());
    }
}
