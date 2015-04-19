package com.language.properties;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

/**
 * Created by Dodd on 2015/4/19.
 */
public class GetLanguage {
    public static String getString(HttpServletRequest request, String key) {
        ResourceBundle lang = ResourceBundle.getBundle("com.language.properties.language", request.getLocale());
        try {
            return new String(lang.getString("reg").getBytes("ISO-8859-1"), "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "unknowtext";
    }
}
