//package za.ac.cput.repository.tertiaryInstitution.impl;
//
//import org.junit.*;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.entity.tertiaryInstitution.Faculty;
//import za.ac.cput.factory.tertiaryInstitution.FacultyFactory;
//import za.ac.cput.repository.tertiaryInstitution.FacultyRepository;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class FacultyRepositoryImplTest {
//
//    @Autowired
//    private static FacultyRepository repository;
//    private static Faculty faculty = FacultyFactory.createFaculty("2", "ICTMAF256S");
//
//    @Test
//    public void d_getAll()
//    {
//        System.out.println("Get All: " + repository.findAll());
//    }
//
//    @Test
//    public void a_create()
//    {
//        Faculty created = repository.save(faculty);
//        Assert.assertEquals(faculty.getFacultyName(), created.getFacultyName());
//        Assert.assertEquals(faculty.getFacultyCode(), created.getFacultyCode());
//
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    public void b_read()
//    {
//        Faculty read = repository.findById(faculty.getFacultyId()).orElseGet(null);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update()
//    {
//        Faculty updated = new Faculty.Builder().copy(faculty).setFacultyName("Engineering").build();
//        updated = repository.save(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete()
//    {
//        boolean deleted = repository.deleteById(faculty.getFacultyId());
//        Assert.assertTrue(deleted);
//    }
//
//}
