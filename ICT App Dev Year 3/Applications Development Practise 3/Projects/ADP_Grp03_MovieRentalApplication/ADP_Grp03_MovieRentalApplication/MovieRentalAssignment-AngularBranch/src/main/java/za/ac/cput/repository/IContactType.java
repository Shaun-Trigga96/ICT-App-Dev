package za.ac.cput.repository;
/* ContactType.java
 Entity for the ContactType
 Author: Malcolm Camelo (217137334)
 Date: 25 June 2021
*/

import za.ac.cput.entity.ContactType;

import java.util.Set;
@Deprecated
public interface IContactType extends IRepository<ContactType, String> {
    public Set<ContactType> getAll();
}
