package za.ac.cput.factory;
import org.hibernate.validator.internal.util.StringHelper;
import za.ac.cput.domain.Name;

/* NameFactory.java
 * Factory for the Name entity
 * Thabiso Matsaba 220296006
 * 10 August 2022
 */
public class NameFactory {
    public static Name build(String firstName, String middleName, String lastName) {

        if (StringHelper.isNullOrEmptyString(firstName) || StringHelper.isNullOrEmptyString(lastName))
            throw new IllegalArgumentException();

        if (StringHelper.isNullOrEmptyString(middleName))
            middleName = "";

        return new Name.Builder().firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                .build();
    }

    public static Name build(String firstName, String lastName) {

        if (StringHelper.isNullOrEmptyString(firstName) || StringHelper.isNullOrEmptyString(lastName))
            throw new IllegalArgumentException();
        return new Name.Builder().firstName(firstName)
                .middleName("")
                .lastName(lastName)
                .build();
    }
}

