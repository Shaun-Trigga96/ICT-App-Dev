/*EmployeeContactService.java
 *IService for the EmployeeContact
 * Author: Daniella Burgess 219446482
 * Date: 13 October 2022
 */

package za.ac.cput.service;

import za.ac.cput.domain.EmployeeContact;
import java.util.List;

public interface EmployeeContactService extends IService<EmployeeContact, String>{

    List<EmployeeContact> getAll();


}
