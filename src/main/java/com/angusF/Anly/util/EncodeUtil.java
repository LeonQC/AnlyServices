package com.angusF.Anly.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EncodeUtil {
    @Value("${encode.table}")
    private String table;
    @Value("${key.length}")
    private long length;
    @Value("${encode.strategy}")
    private String encodeStrategy;

    public String getKey() {
        String key = "";
        switch (encodeStrategy) {
            case "random": key = getKeyByRandom(); break;
            case "hash": key = getKeyByHash(); break;
        }
        return key;
    }

    private String getKeyByHash() {
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

    private String getKeyByRandom() {
        String key = "";
        java.util.Random root = new java.util.Random();
        for (int i = 0; i < length; i++) {
            int rand = root.nextInt(0, table.length() - 1);
            key = key + table.charAt(rand);
        }
        return key;
    }

}
