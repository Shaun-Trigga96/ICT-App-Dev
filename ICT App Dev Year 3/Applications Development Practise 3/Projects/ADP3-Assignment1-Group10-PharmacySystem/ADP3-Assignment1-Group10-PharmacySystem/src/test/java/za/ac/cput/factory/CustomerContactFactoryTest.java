package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CustomerContact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerContactFactoryTest {

    @Test
    void createCustomerContact() {
        CustomerContact customerContact = CustomerContactFactory.createCustomerContact("14XP", "MP55");
        assertNotNull(customerContact);
        assertEquals("MP55",customerContact.getContactId());
        System.out.println(customerContact);
    }
}