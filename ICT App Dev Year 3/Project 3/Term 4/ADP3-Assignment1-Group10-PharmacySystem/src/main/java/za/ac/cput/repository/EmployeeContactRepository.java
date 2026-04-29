/*EmployeeContactRepository.java
 *IRepository for the EmployeeContact
 * Author: Daniella Burgess 219446482
 * Date: 13 October 2022
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.EmployeeContact;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeContactRepository extends JpaRepository <EmployeeContact, String> {

}
