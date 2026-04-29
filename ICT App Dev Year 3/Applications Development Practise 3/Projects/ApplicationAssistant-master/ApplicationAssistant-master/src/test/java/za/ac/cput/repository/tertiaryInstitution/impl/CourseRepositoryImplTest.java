//package za.ac.cput.repository.tertiaryInstitution.impl;
//
//import org.junit.*;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.entity.previousQualification.Subject;
//import za.ac.cput.entity.tertiaryInstitution.Course;
//import za.ac.cput.factory.previousQualification.SubjectFactory;
//import za.ac.cput.factory.tertiaryInstitution.CourseFactory;
//import za.ac.cput.repository.previousQualification.SubjectRepository;
//import za.ac.cput.repository.previousQualification.impl.SubjectRepositoryImpl;
//import za.ac.cput.repository.tertiaryInstitution.CourseRepository;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class CourseRepositoryImplTest {
//
//    @Autowired
//    private static CourseRepository repository;
//    private static Course course = CourseFactory.createCourse("ICT: Multimedia", "ICT256S","15000");
//
//    private static SubjectRepository subjectRepository = SubjectRepositoryImpl.getRepository();
//    private static Subject subject = SubjectFactory.createSubject("App Development", 84);
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
//        Subject createdSubject = subjectRepository.create(subject);
//        Course created = repository.create(course);
//        Assert.assertEquals(course.getCourseName(), created.getCourseName());
//        Assert.assertEquals(course.getCourseCode(), created.getCourseCode());
//      //  Assert.assertEquals(course.getCourseRequirement(), created.getCourseRequirement());
//        Assert.assertEquals(course.getCourseFees(), created.getCourseFees());
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    public void b_read()
//    {
//        Course read = repository.read(course.getCourseId());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update()
//    {
//        Course updated = new Course.Builder().copy(course).setCourseCode("AD123987").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete()
//    {
//        boolean deleted = repository.delete(course.getCourseId());
//        Assert.assertTrue(deleted);
//    }
//}
