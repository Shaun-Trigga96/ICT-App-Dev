package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Pharmacy;
import za.ac.cput.repository.PharmacyRepository;

import java.util.List;


@Service
public class PharmacyServiceImpl implements PharmacyService {

    private final PharmacyRepository pharmacyrepository;


    @Autowired public PharmacyServiceImpl(PharmacyRepository pharmacyrepository){
        this.pharmacyrepository = pharmacyrepository;
    }

    @Override
    public Pharmacy save(Pharmacy pharmacy) {return this.pharmacyrepository.save(pharmacy);}

    @Override
    public Pharmacy read(String s) {
        return this.pharmacyrepository.findById(s).orElse(null);
    }

    @Override
    public boolean delete(String s) {
        if (this.pharmacyrepository.existsById(s)) {
            this.pharmacyrepository.deleteById(s);
            return true;
        }
        return false;
    }


    @Override
    public List<Pharmacy> getAll() {
        return this.pharmacyrepository.findAll();
    }



}
