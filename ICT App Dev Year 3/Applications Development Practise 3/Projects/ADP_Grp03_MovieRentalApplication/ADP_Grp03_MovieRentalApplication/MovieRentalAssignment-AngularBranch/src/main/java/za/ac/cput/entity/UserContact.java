package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/* UserContact.java
 Entity for the UserContact
 Author: Malcolm Camelo (217137334)
 Date: 10 June 2021
*/
@Entity
public class UserContact {

    public UserContact(){}
    @Id
    private String userId;
    private String contactTypeId;
    private String Contact;



    private UserContact(userContactBuilder userContactBuilder) {
        this.contactTypeId = userContactBuilder.contactTypeId;
        this.userId = userContactBuilder.userId;
        this.Contact = userContactBuilder.Contact;

    }

    public String getContactId() {
        return contactTypeId;
    }
    public String getContact() {
        return Contact;
    }
    public String getUserId() { return userId; }

    public static class userContactBuilder {
        private String userId;
        private String contactTypeId;
        private String Contact;

        public userContactBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public userContactBuilder setContactTypeId(String contactTypeId) {
            this.contactTypeId = contactTypeId;
            return this;
        }

        public userContactBuilder setContact(String Contact) {
          this.Contact = Contact;
            return this;
        }

        public UserContact build() {

            return new UserContact(this);
        }
        public userContactBuilder copy(UserContact userContact)
        {
            this.userId =userContact.userId;
            this.Contact = userContact.Contact;
            this.contactTypeId = userContact.contactTypeId;


            return this;


        }
    }


    @Override
    public String toString() {
        return "UserContact " +
                "userId= " + userId +
                ", contactTypeId= " + contactTypeId +
                ", Contact='" + Contact + '\'';
    }
}
