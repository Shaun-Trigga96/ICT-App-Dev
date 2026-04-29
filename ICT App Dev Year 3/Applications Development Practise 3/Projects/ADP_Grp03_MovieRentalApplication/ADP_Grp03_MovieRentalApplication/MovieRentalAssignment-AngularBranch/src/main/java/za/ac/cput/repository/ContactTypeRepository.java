package za.ac.cput.repository;
/* ContactType.java
 Entity for the ContactType
 Author: Malcolm Camelo (217137334)

*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.ContactType;

@Repository
public interface ContactTypeRepository extends JpaRepository<ContactType,String> {

}
