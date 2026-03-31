package za.ac.cput.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.entity.tertiaryInstitution.Institution;
import za.ac.cput.factory.tertiaryInstitution.InstitutionFactory;


public class InstitutionFactoryTest {

    @Test
    public void createInstitution() {
        Institution verification = InstitutionFactory.createInstitution("CPUT", "1234");

        Assert.assertEquals("CPUT", verification.getInstitutionName());
        Assert.assertEquals("1234", verification.getInstitutionCode());
    }
}
