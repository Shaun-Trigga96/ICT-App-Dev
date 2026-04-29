/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * CustomerContactFactory.java
 */

package za.ac.cput.factory;

import za.ac.cput.domain.CustomerContact;
import za.ac.cput.util.SiphosethuHelper;

public class CustomerContactFactory {
    public static CustomerContact createCustomerContact(String customerId, String contactId){
        if(!SiphosethuHelper.isValid(customerId) || !SiphosethuHelper.isValid(contactId))
            return null;
        return new CustomerContact.Builder().setCustomerId(customerId).setContactId(contactId).build();
    }
}
