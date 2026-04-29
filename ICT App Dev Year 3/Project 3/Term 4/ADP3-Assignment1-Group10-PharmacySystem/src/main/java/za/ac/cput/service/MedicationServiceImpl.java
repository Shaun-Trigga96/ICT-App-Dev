/*MedicationServiceImpl.java
 * Service Impl class for Medication
 * Author: Ilyaas Davids (219466242)
 * Date: 13 Oct 2022
 */
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Medication;
import za.ac.cput.repository.MedicationRepository;

import java.util.List;
@Service
public class MedicationServiceImpl implements MedicationService{

    private MedicationRepository medicationRepository;

    @Autowired
    MedicationServiceImpl(MedicationRepository medicationRepository){
        this.medicationRepository = medicationRepository;
    }

    @Override
    public Medication save(Medication medication) {
        return this.medicationRepository.save(medication);
    }

    @Override
    public Medication read(String s) {
        return this.medicationRepository.findById(s).orElse(null);
    }

    @Override
    public boolean delete(String s) {
        if (this.medicationRepository.existsById(s)) {
            this.medicationRepository.deleteById(s);
            return true;
        }
        return false;
    }
public Medication updateMedication(Medication medication){
        return medicationRepository.save(medication);
}

    @Override
    public List<Medication> getAll() {
        return this.medicationRepository.findAll();
    }
}
