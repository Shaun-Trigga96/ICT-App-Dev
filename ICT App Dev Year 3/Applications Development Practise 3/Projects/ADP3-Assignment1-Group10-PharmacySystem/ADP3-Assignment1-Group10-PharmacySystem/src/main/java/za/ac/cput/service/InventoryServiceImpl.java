/**
 * Author: Siphosethu Feni
 * Student Number: 217237614
 *  *  Group: 10
 * InventoryServiceImpl.java
 */

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Inventory;
import za.ac.cput.repository.IInventoryRepository;

@Service
public class InventoryServiceImpl implements IInventoryService{
    private final IInventoryRepository repository;
    @Autowired
    public  InventoryServiceImpl(IInventoryRepository repository){
        this.repository = repository;
    }

    @Override
    public Inventory save(Inventory inventory) {
        return this.repository.save(inventory);
    }

    @Override
    public Inventory find(Long s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Inventory update(Inventory inventory) {
        return this.repository.save(inventory);
    }

    @Override
    public boolean delete(Inventory inventory) {
        Inventory delete = this.find(inventory.getInventoryID());
        if(delete != null){
            this.repository.delete(delete);
            return true;
        }
        return false;
    }
}
