package za.ac.cput.service;
/* UserContact.java

 Author: Malcolm Camelo (217137334)
 Date: 22 August 2021
*/

import za.ac.cput.entity.UserContact;

import java.util.Set;

public interface IUserContactService extends IService<UserContact,String>{
    Set<UserContact> getAll();
}