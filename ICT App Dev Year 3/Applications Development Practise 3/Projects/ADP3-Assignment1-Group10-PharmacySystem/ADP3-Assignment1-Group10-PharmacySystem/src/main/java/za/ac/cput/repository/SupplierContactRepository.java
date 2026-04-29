package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.SupplierContact;

import java.util.List;
import java.util.Optional;

public interface SupplierContactRepository extends JpaRepository<SupplierContact,String> {

    List<SupplierContact> findAll();
    Optional<SupplierContact> findById(String id);

}
