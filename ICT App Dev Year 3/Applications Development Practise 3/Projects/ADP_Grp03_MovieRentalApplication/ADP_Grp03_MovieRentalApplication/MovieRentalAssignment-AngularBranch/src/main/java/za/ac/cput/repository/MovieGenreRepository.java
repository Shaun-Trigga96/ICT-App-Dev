package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.MovieGenre;
import za.ac.cput.entity.Studio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Studio.java
        studio repo
        Author: Marchello Carolus 218234457
        Date: 26 July 2021
        */

public interface MovieGenreRepository extends JpaRepository<MovieGenre, String> {


}
