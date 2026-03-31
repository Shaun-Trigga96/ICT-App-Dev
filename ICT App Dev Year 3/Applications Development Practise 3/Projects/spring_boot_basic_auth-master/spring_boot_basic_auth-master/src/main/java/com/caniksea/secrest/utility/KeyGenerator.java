package com.caniksea.secrest.utility;

import java.util.UUID;

/**
 * Created by caniksea on 8/9/17.
 */
public class KeyGenerator {
    public static String getEntityId() {
        return UUID.randomUUID().toString();
    }
}
