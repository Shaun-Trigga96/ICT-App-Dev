package za.ac.cput.repository.tertiaryInstitution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.tertiaryInstitution.Faculty;
import za.ac.cput.repository.IRepository;
import java.util.*;
@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> { }
