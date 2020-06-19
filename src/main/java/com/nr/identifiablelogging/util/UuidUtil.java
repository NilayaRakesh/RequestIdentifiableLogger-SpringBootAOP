package com.nr.identifiablelogging.util;

public class UuidUtil {

    // The generated UUID will be unique for approximately 8,925 years so long as
    // less than 10,000 IDs are generated per millisecond on the same device
    public static String getRandomUuid() {
        return org.apache.logging.log4j.core.util.UuidUtil.getTimeBasedUuid().toString();
    }
}
