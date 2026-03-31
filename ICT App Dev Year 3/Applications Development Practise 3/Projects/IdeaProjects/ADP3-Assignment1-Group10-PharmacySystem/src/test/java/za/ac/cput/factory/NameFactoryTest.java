package za.ac.cput.factory;
import za.ac.cput.domain.Name;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {
    @Test
    public void testNameWithSuccess() {
        Name name = NameFactory.build("Thabiso","Patrick", "Matsaba") ;
        System.out.println(name);
        assertNotNull(name);
    }
    @Test
    public void testNameWithNullFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()->NameFactory.build("", "Patrick","Matsaba"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("First Name is null", exceptionMessage);
    }
    @Test
    public void testNameWithNullMiddleName(){
        Name name2 = NameFactory.build("Thabiso","", "Matsaba");
        assertAll(
                ()-> assertTrue(name2.getMiddleName().isEmpty()),
                ()-> assertNotNull(name2)
        );
        System.out.println(name2);
    }

}