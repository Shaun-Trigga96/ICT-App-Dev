package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.PharmacyContact;
import za.ac.cput.domain.Supplier;

import java.util.List;
import java.util.Optional;

@Repository
public interface PharmacyContactRepository extends JpaRepository<PharmacyContact, String> {


}

