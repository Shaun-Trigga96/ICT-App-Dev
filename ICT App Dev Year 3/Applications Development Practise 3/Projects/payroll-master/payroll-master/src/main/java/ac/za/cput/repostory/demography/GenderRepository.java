package ac.za.cput.repostory.demography;

import ac.za.cput.domain.demography.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, String> {
}
