//package za.ac.cput.repository.previousQualification.impl;
//
//
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.entity.previousQualification.Subject;
//import za.ac.cput.factory.previousQualification.SubjectFactory;
//import za.ac.cput.repository.previousQualification.SubjectRepository;
//
//
////import static org.junit.Assert.*;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class SubjectRepositoryImplTest {
//
//    @Autowired
//    private SubjectRepository repository;
//    private static Subject subject = SubjectFactory.createSubject("App Development", 84);
//    @Test
//    public void d_getAll() {
//        System.out.println("Get All:" + repository.findAll());
//    }
//
//    @Test
//    public void a_create() {
//
//        Subject created  = repository.save(subject);
//        Assert.assertEquals(subject.getSubjectName(), created.getSubjectName());
//        Assert.assertEquals(subject.getSubjectMark(), created.getSubjectMark());
//             System.out.println("Created:"+ created);
//    }
//
//    @Test
//    public void b_read() {
//
//        Subject read =  repository.findById(subject.getSubjectId()).orElseGet(null);
//        System.out.println("Read:"+ read);
//
//    }
//
//    @Test
//    public void c_update() {
//
//        Subject updated = new Subject.Builder().copy(subject).setSubjectName("Multimedia").build();
//        updated = repository.save(updated);
//        System.out.println("Updated:" + updated);
//    }
//
//    @Test
//    public void e_delete() {
//        boolean deleted;
//        repository.deleteById(subject.getSubjectId());
//        if(repository.existsById(subject.getSubjectId())){
//            deleted = false;
//        }else{
//            deleted = true;
//        }
//        Assert.assertTrue(deleted);
//    }
//}