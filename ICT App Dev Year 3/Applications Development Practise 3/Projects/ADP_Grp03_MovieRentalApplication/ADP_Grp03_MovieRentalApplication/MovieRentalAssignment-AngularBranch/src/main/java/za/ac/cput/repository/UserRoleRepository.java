package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.userRole;

@Repository
public interface UserRoleRepository extends JpaRepository<userRole, String> {
}
