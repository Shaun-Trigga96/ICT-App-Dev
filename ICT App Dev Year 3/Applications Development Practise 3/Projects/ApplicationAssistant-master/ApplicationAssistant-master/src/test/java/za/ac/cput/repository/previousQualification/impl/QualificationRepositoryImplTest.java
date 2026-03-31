//package za.ac.cput.repository.previousQualification.impl;
//
//
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import za.ac.cput.entity.previousQualification.Qualification;
//import za.ac.cput.entity.previousQualification.Subject;
//import za.ac.cput.factory.previousQualification.QualificationFactory;
//import za.ac.cput.factory.previousQualification.SubjectFactory;
//import za.ac.cput.repository.previousQualification.QualificationRepository;
//import za.ac.cput.repository.previousQualification.SubjectRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
////import static org.junit.Assert.*;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
////Comment out this test
//public class QualificationRepositoryImplTest {
//
//    private static Subject subject = SubjectFactory.createSubject("English", 50);
//    private static Set<Subject> subjectList = new HashSet<>();
//
//    private static QualificationRepository repository = QualificationRepositoryImpl.getRepository();
//    private static Qualification qualification;
//    @Test
//    public void d_getAll() { System.out.println("Get All"+ repository.getAll());
//    }
//
//    @Test
//    public void a_create() {
//        subjectList.add(subject);
//        qualification  = QualificationFactory.createQualification("Tertiary");
//        Qualification created = repository.create(qualification);
//        Assert.assertEquals(qualification.getLevelOfQualifications(), created.getLevelOfQualifications());
//        //Assert.assertEquals(qualification.getSubjectList(), created.getSubjectList());
//        System.out.println("Created" + created);
//
//    }
//
//    @Test
//    public void b_read() {
//
//        Qualification read  = repository.read(qualification.getQualificationId());
//        System.out.println("Read" + read);
//    }
//
//    @Test
//    public void c_update() {
//        Qualification updated = new Qualification.Builder().copy(qualification).setLevelOfQualifications("Secondary").build();
//        updated =repository.update(updated);
//        System.out.println("Updated:" + updated);
//    }
//
//    @Test
//    public void e_delete() {
//
//        boolean deleted = repository.delete(qualification.getQualificationId());
//        Assert.assertTrue(deleted);
//    }
//}