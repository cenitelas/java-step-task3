package org.step;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleImpl {
    private ResourceBundle bundle;

    public LocaleImpl(Locale locale) {
        bundle = ResourceBundle.getBundle("resources/locale", locale);
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }

    public Enumeration<String> getAllKeys(){
        return this.bundle.getKeys();
    }
}
