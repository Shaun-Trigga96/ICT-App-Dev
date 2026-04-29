/*SupplierService.java
 * Service class for Supplier
 * Author: Ilyaas Davids (219466242)
 * Date: 13 Oct 2022
 */
package za.ac.cput.service;

import za.ac.cput.domain.Supplier;

import java.util.List;

public interface SupplierService extends IService<Supplier,String>{

    List<Supplier> getAll();

}
