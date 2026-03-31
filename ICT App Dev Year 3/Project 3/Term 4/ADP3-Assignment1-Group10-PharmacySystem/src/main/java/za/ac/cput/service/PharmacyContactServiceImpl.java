package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.PharmacyContact;
import za.ac.cput.repository.PharmacyContactRepository;

import java.util.List;

@Service
public class PharmacyContactServiceImpl implements PharmacyContactService {

    private final PharmacyContactRepository pharmacyContactrepository;


    @Autowired
    public PharmacyContactServiceImpl(PharmacyContactRepository pharmacyContactrepository)
    {this.pharmacyContactrepository = pharmacyContactrepository;}


    @Override
    public PharmacyContact save(PharmacyContact pharmacyContact) {return this.pharmacyContactrepository.save(pharmacyContact);}

    @Override
    public PharmacyContact read(String s) {return this.pharmacyContactrepository.findById(s).orElse(null);
    }

    @Override
    public boolean delete(String s) {
        if (this.pharmacyContactrepository.existsById(s)) {
            this.pharmacyContactrepository.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<PharmacyContact> getAll() {
        return this.pharmacyContactrepository.findAll();
    }
}
