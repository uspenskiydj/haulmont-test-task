package com.haulmont.testtask.util;

import com.haulmont.testtask.model.Credit;
import com.haulmont.testtask.util.exception.NotFoundException;

import java.math.BigDecimal;
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

    public static boolean isValidCreditAmount(String creditAmountStr, Credit credit) {
        try {
            BigDecimal creditAmount = new BigDecimal(creditAmountStr);
            if (creditAmount.compareTo(credit.getLimit()) > 0 || creditAmount.compareTo(BigDecimal.TEN) < 0) {
                return false;
            }
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
}