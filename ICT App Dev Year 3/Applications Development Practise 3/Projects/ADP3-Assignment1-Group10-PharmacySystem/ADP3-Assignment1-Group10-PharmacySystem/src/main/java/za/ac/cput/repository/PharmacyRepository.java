package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Pharmacy;
import za.ac.cput.domain.PharmacyContact;

import java.util.List;
import java.util.Optional;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, String> {

}
