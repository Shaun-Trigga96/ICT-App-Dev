package za.ac.cput.service;

import za.ac.cput.domain.Prescription;

import java.util.List;

public interface PrescriptionService extends IService <Prescription, String>{

    List<Prescription> getAll();
}
