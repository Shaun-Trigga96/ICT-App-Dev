package za.ac.cput.repository;
/* ContactType.java
 Entity for the ContactType
 Author: Malcolm Camelo (217137334)
 Date: 25 June 2021
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.UserContact;

@Repository
public interface UserContactRepository extends JpaRepository<UserContact,String> {

}
