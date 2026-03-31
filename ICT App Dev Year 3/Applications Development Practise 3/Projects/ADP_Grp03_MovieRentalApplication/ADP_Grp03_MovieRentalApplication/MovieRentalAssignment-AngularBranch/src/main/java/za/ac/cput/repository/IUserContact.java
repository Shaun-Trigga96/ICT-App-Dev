package za.ac.cput.repository;
/* ContactType.java
 Entity for the ContactType
 Author: Malcolm Camelo (217137334)
 Date: 25 June 2021
*/

import za.ac.cput.entity.UserContact;

import java.util.Set;

public interface IUserContact extends IRepository<UserContact, String> {
    public Set<UserContact> getAll();
}
