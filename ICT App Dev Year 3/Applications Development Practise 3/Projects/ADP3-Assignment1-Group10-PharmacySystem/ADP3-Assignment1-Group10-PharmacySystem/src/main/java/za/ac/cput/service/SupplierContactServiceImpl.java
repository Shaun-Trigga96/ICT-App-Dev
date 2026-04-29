/*SupplierContactServiceImpl.java
 * Service Impl class for Supplier Contact
 * Author: Ilyaas Davids (219466242)
 * Date: 13 Oct 2022
 */
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.SupplierContact;
import za.ac.cput.repository.SupplierContactRepository;

import java.util.List;
@Service
public class SupplierContactServiceImpl implements SupplierContactService{
    private SupplierContactRepository supplierContactRepository;

    @Autowired
    SupplierContactServiceImpl(SupplierContactRepository supplierContactRepository){
        this.supplierContactRepository = supplierContactRepository;
    }

    @Override
    public SupplierContact save(SupplierContact supplierContact) {
        return this.supplierContactRepository.save(supplierContact);
    }

    @Override
    public SupplierContact read(String s) {
        return this.supplierContactRepository.findById(s).orElse(null);
    }

    @Override
    public boolean delete(String s) {
        if (this.supplierContactRepository.existsById(s)) {
            this.supplierContactRepository.deleteById(s);
            return true;
        }
        return false;
    }

    public SupplierContact updateSupplierContact(SupplierContact supplierContact){
        return supplierContactRepository.save(supplierContact);
    }

    @Override
    public List<SupplierContact> getAll() {
        return this.supplierContactRepository.findAll();
    }
}
