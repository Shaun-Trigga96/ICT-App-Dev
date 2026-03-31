package za.ac.cput.factory.user;

import za.ac.cput.entity.user.PersonalDetail;
import za.ac.cput.util.GenericHelper;
import za.ac.cput.util.StringHelper;

public class PersonalDetailFactory {

    public static PersonalDetail createPersonalDetails(String contactEmail, String contactCellNumber, String qualificationType) {
        if (StringHelper.isNullorEmpty(contactEmail)) return new PersonalDetail.Builder().build();
        if (StringHelper.isNullorEmpty(contactCellNumber)) return new PersonalDetail.Builder().build();
        if (StringHelper.isNullorEmpty(qualificationType)) return new PersonalDetail.Builder().build();
        String personalId = GenericHelper.generateRandom();
        PersonalDetail information = new PersonalDetail.Builder()
                .setPersonalId(personalId)
                .setContactEmail(contactEmail)
                .setContactCellNumber(contactCellNumber)
                .setQualificationType(qualificationType)
                .build();
        return information;
    }
}
