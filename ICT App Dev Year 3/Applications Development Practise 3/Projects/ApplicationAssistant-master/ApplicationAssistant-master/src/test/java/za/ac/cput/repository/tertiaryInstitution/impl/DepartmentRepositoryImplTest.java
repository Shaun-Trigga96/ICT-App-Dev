//package za.ac.cput.repository.tertiaryInstitution.impl;
//
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.entity.tertiaryInstitution.Department;
//import za.ac.cput.factory.tertiaryInstitution.DepartmentFactory;
//import za.ac.cput.repository.tertiaryInstitution.DepartmentRepository;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class DepartmentRepositoryImplTest {
//
//    @Autowired
//    private DepartmentRepository repository;
//    private static Department department = DepartmentFactory.createDepartment("Engineering", "Eng123");
//
//    @Test
//    public void d_getAll()
//    {
//        System.out.println("Get All: " + repository.getAll());
//    }
//
//    @Test
//    public void a_create()
//    {
//        Department created = repository.create(department);
//        Assert.assertEquals(department.getDepartmentName(), created.getDepartmentName());
//        Assert.assertEquals(department.getDepartmentCode(), created.getDepartmentCode());
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    public void b_read()
//    {
//        Department read = repository.read(department.getDepartmentId());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update()
//    {
//        Department updated = new Department.Builder().copy(department).setDepartmentName("Mechanical Engineering").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete()
//    {
//        boolean deleted = repository.delete(department.getDepartmentId());
//        Assert.assertTrue(deleted);
//    }
//}