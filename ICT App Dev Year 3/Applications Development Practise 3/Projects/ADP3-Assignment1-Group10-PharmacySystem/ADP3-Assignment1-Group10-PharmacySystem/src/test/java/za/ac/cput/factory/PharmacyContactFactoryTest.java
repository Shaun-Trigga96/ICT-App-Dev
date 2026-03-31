//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import za.ac.cput.domain.Pharmacy;
//import za.ac.cput.domain.PharmacyContact;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class PharmacyContactFactoryTest {
//    @Test
//    @Order(1)
//    public void buildWithSuccess(){
//        Exception exception = assertThrows(IllegalArgumentException.class,()->
//                PharmacyContactFactory.build("123","0208348302","209023651@mycput.ac.za"));
//        String exceptionMessage = exception.getMessage();
//        System.out.println(exceptionMessage);
//    }
//
//
//    @Test
//    @Order(2)
//    public void buildWithError(){
//        PharmacyContact pharmacyContact = PharmacyContactFactory.build("123", "0208348302","209023651@mycput.ac.za");
//        assertNotNull(pharmacyContact);
//        System.out.println(pharmacyContact);
//    }
//}