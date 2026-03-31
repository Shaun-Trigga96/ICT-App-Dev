package ac.za.cput.adp3.xyzcongolmerate;

import ac.za.cput.adp3.xyzcongolmerate.factory.demography.GenderFactoryTest;
import ac.za.cput.adp3.xyzcongolmerate.factory.demography.RaceFactoryTest;
import ac.za.cput.adp3.xyzcongolmerate.factory.misc.RoleFactoryTest;
import ac.za.cput.adp3.xyzcongolmerate.factory.org.OrganisationFactoryTest;
import ac.za.cput.adp3.xyzcongolmerate.factory.org.OrganisationUserFactoryTest;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserDemographyFactoryTest;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserFactoryTest;
import ac.za.cput.adp3.xyzcongolmerate.factory.user.UserRoleFactoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GenderFactoryTest.class,
        RaceFactoryTest.class,
        RoleFactoryTest.class,
        OrganisationFactoryTest.class,
        OrganisationUserFactoryTest.class,
        UserDemographyFactoryTest.class,
        UserFactoryTest.class,
        UserRoleFactoryTest.class
})

/**
 * DO NOT MODIFY
 */
public class JUnitTestSuite {
}
