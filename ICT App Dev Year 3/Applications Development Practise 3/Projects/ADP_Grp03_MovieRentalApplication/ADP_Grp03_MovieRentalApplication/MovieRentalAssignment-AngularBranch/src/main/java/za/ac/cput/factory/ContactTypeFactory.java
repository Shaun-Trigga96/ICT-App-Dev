package za.ac.cput.factory;

import za.ac.cput.entity.ContactType;

import java.util.UUID;

/* ContactTypeFactory.java
 entity for the ContactTypeFactory
 Author: Malcolm Camelo (217137334)
 Date: 10 June 2021
*/
public class ContactTypeFactory {

    public static ContactType build(String name, String description) {
        if (name.isEmpty())
            return null;

        String contactTypeId = UUID.randomUUID().toString();


        return new ContactType.contactTypeBuilder()
                .setName(name)
                .setDescription(description)
                .setContactTypeId(contactTypeId).build();
    }



}
