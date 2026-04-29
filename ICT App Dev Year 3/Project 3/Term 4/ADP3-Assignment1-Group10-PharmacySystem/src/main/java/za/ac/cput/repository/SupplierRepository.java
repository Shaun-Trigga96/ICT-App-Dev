package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier,String> {

    List<Supplier> findAll();
    Optional<Supplier> findById(String id);

}
