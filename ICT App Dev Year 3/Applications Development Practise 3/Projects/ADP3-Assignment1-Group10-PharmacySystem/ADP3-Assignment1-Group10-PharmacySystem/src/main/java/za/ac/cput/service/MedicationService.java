/*MedicationService.java
 * Service class for Medication
 * Author: Ilyaas Davids (219466242)
 * Date: 11 Oct 2022
 */
package za.ac.cput.service;

import za.ac.cput.domain.Medication;

import java.util.List;

public interface MedicationService extends IService<Medication,String>{

    List<Medication> getAll();


}
