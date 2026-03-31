package za.ac.cput.ADP3LabBookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.ADP3LabBookingSystem.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
