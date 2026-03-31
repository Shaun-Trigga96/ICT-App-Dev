/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * CustomerContactServiceImpl.java
 */

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.CustomerContact;
import za.ac.cput.repository.ICustomerContactRepository;

@Service
public class CustomerContactServiceImpl implements ICustomerContactService{
    private final ICustomerContactRepository repository;
    @Autowired
    public CustomerContactServiceImpl(ICustomerContactRepository repository){
        this.repository = repository;
    }

    @Override
    public CustomerContact save(CustomerContact customerContact) {
        return repository.save(customerContact);
    }

    @Override
    public CustomerContact find(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public CustomerContact update(CustomerContact customerContact) {
        return this.repository.save(customerContact);
    }

    @Override
    public boolean delete(CustomerContact customerContact) {
        CustomerContact delete = this.find(customerContact.getId());
        if(delete != null){
            this.repository.delete(customerContact);
            return true;
        }
        return false;
    }
}
