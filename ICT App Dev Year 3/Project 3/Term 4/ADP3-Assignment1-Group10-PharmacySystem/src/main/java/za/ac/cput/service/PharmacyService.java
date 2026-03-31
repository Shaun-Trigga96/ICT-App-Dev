package za.ac.cput.service;

import za.ac.cput.domain.Pharmacy;
import java.util.List;


public interface PharmacyService extends IService <Pharmacy, String>{

    List<Pharmacy> getAll();
}
