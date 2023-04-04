package com.angusF.Anly.util.encode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Random1Encode {
    private final String table = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    @Value("${key.length}")
    private long length;

    public String getKey() {
        String key = "";
        java.util.Random root = new java.util.Random();
        for (int i = 0; i < length; i++) {
            int rand = root.nextInt(0, table.length() - 1);
            key = key + table.charAt(rand);
        }
        return key;
    }
}
