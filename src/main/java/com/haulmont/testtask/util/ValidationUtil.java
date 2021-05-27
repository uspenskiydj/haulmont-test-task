package com.haulmont.testtask.util;

import com.haulmont.testtask.util.exception.NotFoundException;
import java.util.UUID;

public class ValidationUtil {

    public static <T> T checkNotFoundWithId(T object, UUID id) {
        checkNotFoundWithId(object != null, id);
        return object;
    }

    public static void checkNotFoundWithId(boolean found, UUID id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }
}