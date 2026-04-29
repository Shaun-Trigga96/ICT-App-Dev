package za.ac.cput.entity;

/* ContactType.java
 Entity for the ContactType
 Author: Malcolm Camelo (217137334)
 Date: 10 June 2021
*/

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ContactType {
    @Id
    private String contactTypeId;
    private String name, description;



    public ContactType(){}


    public String getContactTypeId() {
        return contactTypeId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    private ContactType(contactTypeBuilder contactTypeBuilder) {
        this.contactTypeId = contactTypeBuilder.contactTypeId;
        this.description = contactTypeBuilder.description;
        this.name = contactTypeBuilder.name;

    }

    public static class contactTypeBuilder {
        private String name, description;
        private String contactTypeId;

        public contactTypeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public contactTypeBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public contactTypeBuilder setContactTypeId(String contactTypeId) {
            this.contactTypeId = contactTypeId;
            return this;
        }

        public ContactType build() {

            return new ContactType(this);
        }

        public contactTypeBuilder copy(ContactType contactType)
        {
            this.contactTypeId = contactType.contactTypeId;
            this.name = contactType.name;
            this.description = contactType.description;


            return this;


        }
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", contactTypeId=" + contactTypeId +
                '}';
    }
}
