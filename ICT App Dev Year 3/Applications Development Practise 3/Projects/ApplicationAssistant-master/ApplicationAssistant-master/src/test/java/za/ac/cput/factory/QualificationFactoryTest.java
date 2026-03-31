package za.ac.cput.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.entity.previousQualification.Qualification;
import za.ac.cput.entity.previousQualification.Subject;
import za.ac.cput.factory.previousQualification.QualificationFactory;
import za.ac.cput.factory.previousQualification.SubjectFactory;

import java.util.HashSet;
import java.util.Set;

public class QualificationFactoryTest {
    private static Subject subject = SubjectFactory.createSubject("English", 50);
    private static Set<Subject> subjectList = new HashSet<>();

    @Test
    public void createQualification(){
        subjectList.add(subject);
        Qualification qualification = QualificationFactory.createQualification("National Senior Certificate");

        Assert.assertEquals("National Senior Certificate", qualification.getLevelOfQualifications());
    }
}