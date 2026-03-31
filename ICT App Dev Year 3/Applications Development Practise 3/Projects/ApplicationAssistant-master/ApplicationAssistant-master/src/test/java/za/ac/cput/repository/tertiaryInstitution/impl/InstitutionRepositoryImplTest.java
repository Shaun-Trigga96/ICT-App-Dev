//package za.ac.cput.repository.tertiaryInstitution.impl;
//
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.entity.tertiaryInstitution.Department;
//import za.ac.cput.entity.tertiaryInstitution.Institution;
//import za.ac.cput.factory.tertiaryInstitution.DepartmentFactory;
//import za.ac.cput.factory.tertiaryInstitution.InstitutionFactory;
//import za.ac.cput.repository.tertiaryInstitution.DepartmentRepository;
//import za.ac.cput.repository.tertiaryInstitution.InstitutionRepository;
//
//import static org.junit.Assert.*;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class InstitutionRepositoryImplTest {
//
//    @Autowired
//    private static InstitutionRepository repository;
//    private static Institution institution = InstitutionFactory.createInstitution("CPUT", "cPuT1324");
//
//    @Test
//    public void d_getAll()
//    {
//        System.out.println("Get All: " + repository.findAll().stream().coll);
//    }
//
//    @Test
//    public void a_create()
//    {
//        Institution created = repository.create(institution);
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    public void b_read()
//    {
//        Institution read = repository.read(institution.getInstitutionId());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update()
//    {
//        Institution updated = new Institution.Builder().copy(institution).setInstitutionName("Cape Peninsula University of Technology").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete()
//    {
//        boolean deleted = repository.delete(institution.getInstitutionId());
//        Assert.assertTrue(deleted);
//    }
//}