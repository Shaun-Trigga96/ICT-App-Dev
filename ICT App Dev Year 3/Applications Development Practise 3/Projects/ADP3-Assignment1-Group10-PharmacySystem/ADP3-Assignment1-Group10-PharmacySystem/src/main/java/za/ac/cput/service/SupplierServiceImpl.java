/*SupplierServiceImpl.java
 * Service Impl class for Supplier
 * Author: Ilyaas Davids (219466242)
 * Date: 13 Oct 2022
 */
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.SupplierContact;
import za.ac.cput.repository.SupplierRepository;

import java.util.List;
@Service
public class SupplierServiceImpl implements SupplierService{

    private SupplierRepository supplierRepository;
    @Autowired
    SupplierServiceImpl(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier save(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }

    @Override
    public Supplier read(String s) {
        return this.supplierRepository.findById(s).orElse(null);
    }

    @Override
    public boolean delete(String s) {
        if (this.supplierRepository.existsById(s)) {
            this.supplierRepository.deleteById(s);
            return true;
        }
        return false;
    }

    public Supplier updateSupplier(Supplier supplier){
        return supplierRepository.save(supplier);
    }
    @Override
    public List<Supplier> getAll() {
        return this.supplierRepository.findAll();
    }
}
