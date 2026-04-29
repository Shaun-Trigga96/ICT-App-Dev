package za.ac.cput.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.entity.previousQualification.Subject;
import za.ac.cput.factory.previousQualification.SubjectFactory;

public class SubjectFactoryTest {

    @Test
    public void createSubject() {
        Subject subject = SubjectFactory.createSubject("Physical Science", 69);

        Assert.assertEquals("Physical Science", subject.getSubjectName());
        Assert.assertEquals(69, subject.getSubjectMark());

    }

}