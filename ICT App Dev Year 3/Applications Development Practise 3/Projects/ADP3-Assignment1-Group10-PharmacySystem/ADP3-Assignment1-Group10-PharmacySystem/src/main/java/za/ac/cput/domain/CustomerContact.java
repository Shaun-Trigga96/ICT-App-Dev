/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * CustomerContact.java
 */

package za.ac.cput.domain;

import javax.persistence.*;


@Entity
@Table
public class CustomerContact {
    @Column@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String customerId;
    @Column
    private String contactId;

    public long getId() {
        return id;
    }
    public String getCustomerId() {
        return customerId;
    }

    public String getContactId() {
        return contactId;
    }

    public CustomerContact(){}

    public CustomerContact(Builder builder){
        this.customerId = builder.customerId;
        this.contactId = builder.contactId;
        if(builder.id > 0)
            this.id = builder.id;
    }

    public static class Builder{
        private long id;
        private String customerId, contactId;

        public Builder setCustomerId(String customerId){
            this.customerId = customerId;
            return this;
        }

        public Builder setContactId(String contactId){
            this.contactId = contactId;
            return this;
        }

        public Builder copy(CustomerContact customerContact){
            this.id = customerContact.id;
            this.customerId = customerContact.customerId;
            this.contactId = customerContact.contactId;
            return this;
        }

        public CustomerContact build(){
            return new CustomerContact(this);
        }
    }

    @Override
    public String toString() {
        return "CustomerContact{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", contactId='" + contactId + '\'' +
                '}';
    }
}
