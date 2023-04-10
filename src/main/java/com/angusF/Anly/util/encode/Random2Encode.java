package com.angusF.Anly.util.encode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Random2Encode {
    private final String table = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    @Value("${key.length}")
    private long length;

    public String getKey() {
        long max = (long)Math.pow(table.length(), length);
        long min = (long)Math.pow(table.length(), length - 1) + 1;
        java.util.Random root = new java.util.Random();
        long rand = root.nextLong(min, max);
        String key = "";
        int index;
        while(rand > 0) {
            index = (int) rand % table.length();
            key = key + table.charAt(index);
            rand = rand / table.length();
        }
        return key;
    }
}
