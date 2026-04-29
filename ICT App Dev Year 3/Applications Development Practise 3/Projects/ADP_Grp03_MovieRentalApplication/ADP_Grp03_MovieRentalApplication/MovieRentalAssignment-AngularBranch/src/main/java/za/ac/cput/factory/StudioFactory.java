package za.ac.cput.factory;

import za.ac.cput.entity.Studio;

/* MovieGenre.java
        Factory class for StudioFactory entity
        Author: Marchello Carolus 218234457
        Date: 11 June 2021
        */

public class StudioFactory {

    public static Studio build(String studioId, String studioName){

        if(studioId.isEmpty() ||  studioName.isEmpty())
            return null;

        Studio studio = new Studio.Builder()
                .setStudioId(studioId)
                .setStudioName(studioName)
                .build();
        return studio;

    }



}


