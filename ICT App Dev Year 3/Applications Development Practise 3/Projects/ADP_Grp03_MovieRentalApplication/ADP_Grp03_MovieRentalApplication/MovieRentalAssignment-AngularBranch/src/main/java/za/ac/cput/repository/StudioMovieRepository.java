package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.StudioMovie;

@Repository
public interface StudioMovieRepository extends JpaRepository<StudioMovie, String> {

}