package com.nr.identifiablelogging.util;

import java.util.Objects;

public class ThreadLocalUtil {

    private static InheritableThreadLocal<String> ithForLogId = new InheritableThreadLocal<>();

    public static String getLogId() {
        return ithForLogId.get();
    }

    public static void setLogId(String value) {
        ithForLogId.set(value);
    }

    public static void removeLogId() {
        if (Objects.nonNull(ithForLogId)) {
            ithForLogId.remove();
        }
    }
}
