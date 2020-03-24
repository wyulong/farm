package com.farm.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author xhua
 * @Date 2020/3/24 16:24
 **/
public class RegexUtil {
    /** 手机号码正则 **/
    private final static String PHONE_REGEX = "^1[0-9]{10}$";

    private final static int PHONE_LENGTH = 11;

    public static Boolean regexPhone(String phone){
        if (phone.length() != PHONE_LENGTH){
            return false;
        }else {
            Pattern p = Pattern.compile(PHONE_REGEX);
            Matcher m = p.matcher(phone);
            return m.find();
        }
    }

}
