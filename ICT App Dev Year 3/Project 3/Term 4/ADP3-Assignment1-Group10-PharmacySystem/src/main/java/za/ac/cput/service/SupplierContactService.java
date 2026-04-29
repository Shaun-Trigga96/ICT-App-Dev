/*SupplierContactService.java
 * Service class for Supplier Contact
 * Author: Ilyaas Davids (219466242)
 * Date: 13 Oct 2022
 */
package za.ac.cput.service;

import za.ac.cput.domain.SupplierContact;

import java.util.List;

public interface SupplierContactService extends IService<SupplierContact,String>{

    List<SupplierContact> getAll();

}
