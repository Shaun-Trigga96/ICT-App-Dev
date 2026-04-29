package za.ac.cput.service.previousQualification.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.entity.previousQualification.Qualification;
import za.ac.cput.entity.previousQualification.Subject;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.factory.previousQualification.QualificationFactory;
import za.ac.cput.factory.previousQualification.SubjectFactory;
import za.ac.cput.factory.tertiaryInstitution.CourseFactory;
import za.ac.cput.repository.previousQualification.SubjectRepository;
import za.ac.cput.service.previousQualification.QualificationService;
import za.ac.cput.service.tertiaryInstitution.CourseService;
import za.ac.cput.service.tertiaryInstitution.impl.CourseServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class QualificationServiceImplTest {

    private  QualificationService service;//Remove the static, and everything after the =
    private static Qualification qualification;

    /*private static CourseService courseService = CourseServiceImpl.getService();
    private static Course course = CourseFactory.createCourse("ADP", "ADP23","15000");*/

    private static Subject subject = SubjectFactory.createSubject("English", 50);
    private static Set<Subject> subjectList = new HashSet<>();

    @Test
    public void d_getAll() {

        Set<Qualification> qualifications = service.getAll();
        assertEquals(1, qualifications.size());
        System.out.println("All Qualifications:"+ qualifications);

    }

    @Test
    public void a_create() {
        subjectList.add(subject);
        qualification  = QualificationFactory.createQualification("Tertiary");
        //Course createdCourse = courseService.create(course);
        Qualification created  = service.create(qualification);
        assertEquals(qualification.getQualificationId(), created.getQualificationId());
        assertEquals(qualification.getLevelOfQualifications(), created.getLevelOfQualifications());
        //assertEquals(qualification.getSubjectList(), created.getSubjectList());
        System.out.println("Created:"+ created);
    }

    @Test
    public void b_read() {
        Qualification read = service.read(qualification.getQualificationId());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update() {
        Qualification updated = new Qualification.Builder().copy(qualification).setLevelOfQualifications("Matric").build();
        updated =service.update(updated);
        System.out.println("updated:" + updated);
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(qualification.getQualificationId());
        Assert.assertTrue(deleted);


    }

    @Test
    public void e_getAllStartingWith() {

        Set<Qualification> secureWithD = service.getAllStartingWith("m");
        assertEquals(1,secureWithD.size());
        System.out.println("All secure" + secureWithD);
    }

    /*@Test
    public void f_checkQualified() {
        Set<Course> courseList = courseService.getAll();
        Qualification check = service.read(qualification.getQualificationId());
        ArrayList<Course> qualified = service.checkIfQualifies(check);
        Assert.assertEquals(1, qualified.size());
    }*/
}