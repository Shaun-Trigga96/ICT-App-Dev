package za.ac.cput.service;
/* ContactType.java
 Entity for the ContactType
 Author: Malcolm Camelo (217137334)
 Date: 22 August 2021
*/
import za.ac.cput.entity.ContactType;

import java.util.Set;

public interface IContactTypeService extends IService<ContactType,String>{
    Set<ContactType> getAll();
}