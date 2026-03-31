package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
