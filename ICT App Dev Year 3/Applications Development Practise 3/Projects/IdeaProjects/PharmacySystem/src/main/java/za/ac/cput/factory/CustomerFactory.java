package za.ac.cput.factory;
import org.hibernate.validator.internal.util.StringHelper;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Name;

/*CustomerFactory.java
 * Factory for the Customer
 * Thabiso Matsaba 220296006
 * 10 August 202222
 */
public class CustomerFactory {

    public static Customer build(String customerId, Name name) {

        if (StringHelper.isNullOrEmptyString(customerId))
            throw new IllegalArgumentException();

        if (name == null)
            throw new IllegalArgumentException();

        return new Customer.Builder().customerId(customerId).name(name).build();
    }
}
