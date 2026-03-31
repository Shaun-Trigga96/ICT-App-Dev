package za.ac.cput.service.user.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.user.PersonalDetail;
import za.ac.cput.factory.user.PersonalDetailFactory;
import za.ac.cput.service.user.PersonalDetailService;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonalDetailServiceImplTest {

    @Autowired
    private PersonalDetailService service ;
    private static PersonalDetail personalDetail = PersonalDetailFactory.createPersonalDetails("john.doe@gmail.com", "0729482386", "National Diploma");

    @Test
    public void d_getAll() {
        Set<PersonalDetail> personalDetails = service.getAll();
        assertEquals(1, personalDetails.size());
        System.out.println("All personal details: " + personalDetails);
    }

    @Test
    public void a_create() {
        PersonalDetail created = service.create(personalDetail);
        Assert.assertEquals(personalDetail.getPersonalId(), created.getPersonalId());
        Assert.assertEquals(personalDetail.getContactEmail(), created.getContactEmail());
        Assert.assertEquals(personalDetail.getContactCellNumber(), created.getContactCellNumber());
        Assert.assertEquals(personalDetail.getQualificationType(),created.getQualificationType());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        PersonalDetail read = service.read(personalDetail.getPersonalId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        PersonalDetail updated = new PersonalDetail.Builder().copy(personalDetail).setContactCellNumber("0761238080").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(personalDetail.getPersonalId());
        Assert.assertTrue(deleted);
    }

    @Test
    public void e_getAllStartingWith076() {
        Set<PersonalDetail> personalDetails = service.getAll();
        assertEquals(1, personalDetails.size());
        System.out.println("All personal details: " + personalDetails);
    }
}