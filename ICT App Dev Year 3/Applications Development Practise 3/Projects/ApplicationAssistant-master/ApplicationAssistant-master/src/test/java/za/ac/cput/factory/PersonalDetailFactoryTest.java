package za.ac.cput.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.entity.user.PersonalDetail;
import za.ac.cput.factory.user.PersonalDetailFactory;

public class PersonalDetailFactoryTest {

    @Test
    public void createPersonalDetails() {
        PersonalDetail information = PersonalDetailFactory.createPersonalDetails("274758381@mycput.ac.za", "0982852948", "application development");

        Assert.assertEquals("274758381@mycput.ac.za", information.getContactEmail());
        Assert.assertEquals("0982852948", information.getContactCellNumber());
        Assert.assertEquals("application development", information.getQualificationType());
    }
}