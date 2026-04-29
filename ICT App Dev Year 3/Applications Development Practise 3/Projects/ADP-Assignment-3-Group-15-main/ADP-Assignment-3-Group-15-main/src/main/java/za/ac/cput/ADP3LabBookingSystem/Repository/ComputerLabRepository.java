/*
 * ComputerLabRepository.java
 * ComputerLabRepository class.
 * Author: Avuyile Mgxotshwa (219132488)
 * Date: 26 July 2021
 * */
package za.ac.cput.ADP3LabBookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.ADP3LabBookingSystem.Entity.ComputerLab;

import java.util.HashSet;
import java.util.Set;

@Repository
public interface ComputerLabRepository extends JpaRepository<ComputerLab, String> {

}
