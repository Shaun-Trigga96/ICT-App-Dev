package za.ac.cput.service;

import za.ac.cput.domain.PharmacyContact;
import java.util.List;

public interface PharmacyContactService extends IService <PharmacyContact, String>{
        List<PharmacyContact> getAll();
}
