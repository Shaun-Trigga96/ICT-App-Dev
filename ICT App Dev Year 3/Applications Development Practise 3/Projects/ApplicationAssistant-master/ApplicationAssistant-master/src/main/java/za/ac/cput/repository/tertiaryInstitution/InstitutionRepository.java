package za.ac.cput.repository.tertiaryInstitution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.tertiaryInstitution.Institution;
import za.ac.cput.repository.IRepository;

import java.util.Set;
@Repository
public interface InstitutionRepository extends JpaRepository<Institution, String> {
}
