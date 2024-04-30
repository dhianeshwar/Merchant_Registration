package com.Merchant.Registration.Utility;

import com.Merchant.Registration.Exception.BadRequestException;
import com.Merchant.Registration.request.BoostMdrRequest;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;

public class FloatValidation {
    public static void validate(Object request) {
        Class<?> clazz = request.getClass();

        try {
            Method[] methods = clazz.getMethods();

            for (Method method : methods) {
                if (method.getReturnType()==String.class && method.getName().startsWith("get")) {
                    String value=null;
                    if(method.invoke(request)!=null)
                        value =  method.invoke(request).toString();
                    String key=method.getName().substring(3);
                    if(StringUtils.isBlank(value))
                    {
                        System.out.println("BLANK RETURNING method::"+method.getName());
                        throw new BadRequestException(key+" should not be blank");
                    }
                    if(!isValidFloat(value))
                    {
                        System.out.println("FLOAT MISMATCH method::"+method.getName());
                        throw new BadRequestException(key+" and value is "+value+ "  is not a valid(need it in decimal) Mdr");
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("REASON FOR THE ERROR:::"+e.getMessage());
             throw new BadRequestException(e.getMessage());
        }
    }
    private static boolean isValidFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        BoostMdrRequest boostMdrRequest=new BoostMdrRequest("1.2"
                ,"1.2",
                "4.5",
                "2.2","1.2","0.4");
        validate(boostMdrRequest);
        String str="1123";
        int count =0;
        count++;
        count++;
        count++;
        String value="abcd"+ (Long.parseLong(str)+count);
        System.out.println(value);


    }
}
