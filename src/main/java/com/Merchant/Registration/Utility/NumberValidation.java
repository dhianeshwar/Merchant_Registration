package com.Merchant.Registration.Utility;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class NumberValidation {
    public static boolean areAllValidFloats(List<String> arr) {

        for (String s : arr) {
                if (!isValidFloat(s)) {
                    return false;
                }
        }
        return true;
    }

    private static boolean isValidFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
