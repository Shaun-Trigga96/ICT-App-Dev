package za.ac.cput.repository.tertiaryInstitution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.tertiaryInstitution.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>{

}
