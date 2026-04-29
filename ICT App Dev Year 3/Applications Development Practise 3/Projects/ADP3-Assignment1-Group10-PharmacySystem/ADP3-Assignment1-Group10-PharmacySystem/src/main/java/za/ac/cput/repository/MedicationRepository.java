package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Medication;

import java.util.List;
import java.util.Optional;

public interface MedicationRepository extends JpaRepository<Medication,String> {

}
