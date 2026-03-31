package za.ac.cput.domain;

/* Pharmacy.java
Domain for the Pharmacy
Author: Waseem Dollie (216040566)
Date: 10 October 2022 */

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;
import java.util.Objects;

@Embeddable
public class PharmacyContact {

    @NotNull
    @Id
    private String  PharmId;
    @NotNull
    @Embedded
    private Contact contact;

    public Contact getContact()
    {
        return contact;
    }

    protected PharmacyContact() {}

    PharmacyContact(PharmacyContact.Builder builder){
        this.PharmId = builder.build().PharmId;
        this.contact = builder.build().contact;
    }

    public String getPharmId() {
        return PharmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyContact that = (PharmacyContact) o;
        return PharmId.equals(that.PharmId) && contact.equals(that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PharmId, contact);
    }

    @Override
    public String toString() {
        return "Builder{" +
                "PharmId='" + PharmId + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder {
        private String PharmId;
        private Contact contact;

        public PharmacyContact.Builder setPharmId(String PharmId) {
            this.PharmId = PharmId;
            return this;
        }

        public PharmacyContact.Builder setContact(Contact contact){
            this.contact = contact;
            return this;
        }


        public PharmacyContact.Builder copy(PharmacyContact pharmacyContact) {
            this.PharmId = pharmacyContact.PharmId;
            this.contact = pharmacyContact.contact;
            return this;
        }

        public PharmacyContact build() {
            return new PharmacyContact(this);
        }


    }


}

