package com.Merchant.Registration.Utility;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class NumberValidation {
    public static boolean areAllValidFloats(List<String> arr) {
        if (arr == null) {
            return false;
        }

        for (String s : arr) {
            if (s != null) {
                if (!isValidFloat(s)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidFloat(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
