import ac.za.cput.controller.demography.GenderControllerTest;
import ac.za.cput.controller.demography.RaceControllerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GenderControllerTest.class,
        RaceControllerTest.class
})
public class TestAll {
}
