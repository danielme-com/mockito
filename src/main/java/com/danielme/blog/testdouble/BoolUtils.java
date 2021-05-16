package com.danielme.blog.testdouble;

public final class BoolUtils {

    private BoolUtils() {}

    public static boolean isTrue(Boolean bool) {
        return bool != null && bool;
    }
}
