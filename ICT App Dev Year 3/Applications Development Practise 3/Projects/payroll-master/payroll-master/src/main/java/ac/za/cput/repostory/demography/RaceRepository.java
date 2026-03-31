package ac.za.cput.repostory.demography;

import ac.za.cput.domain.demography.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RaceRepository extends JpaRepository<Race, String> {
}
