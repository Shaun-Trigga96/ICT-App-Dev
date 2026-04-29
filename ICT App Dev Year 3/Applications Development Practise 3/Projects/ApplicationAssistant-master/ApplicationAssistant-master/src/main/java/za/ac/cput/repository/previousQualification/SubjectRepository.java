package za.ac.cput.repository.previousQualification;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.previousQualification.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
}
