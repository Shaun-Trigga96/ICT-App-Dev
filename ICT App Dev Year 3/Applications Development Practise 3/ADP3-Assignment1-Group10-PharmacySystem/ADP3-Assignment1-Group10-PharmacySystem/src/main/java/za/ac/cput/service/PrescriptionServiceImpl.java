package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Prescription;
import za.ac.cput.repository.PrescriptionRepository;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{

    private PrescriptionRepository repository;

    @Autowired
    PrescriptionServiceImpl(PrescriptionRepository repository){
        this.repository = repository;
    }

    @Override
    public Prescription save(Prescription prescription) {
        return this.repository.save(prescription);
    }

    @Override
    public Prescription read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public boolean delete(String s) {
        if(this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Prescription> getAll() {
        return this.repository.findAll();
    }
}
