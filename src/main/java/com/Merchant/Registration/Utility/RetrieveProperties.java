package com.Merchant.Registration.Utility;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class RetrieveProperties {
    public static List<String> getAllFloatValues(Object request) {
        List<String> fieldValues = new ArrayList<>();
        Class<?> clazz = request.getClass();

        try {
            Method[] methods = clazz.getMethods();

            for (Method method : methods) {
                if (method.getName().startsWith("get") && method.getParameterCount() == 0 && method.getReturnType()== Float.class) {
                    Object value = method.invoke(request);
                    fieldValues.add((String) value);
                }
            }
        } catch (Exception e) {
            return fieldValues;
        }
        return fieldValues;
    }
}
