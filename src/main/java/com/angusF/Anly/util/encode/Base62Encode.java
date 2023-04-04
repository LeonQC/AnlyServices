package com.angusF.Anly.util.encode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Base62Encode {
    private final String table = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    @Value("${key.length}")
    private long length;

    private static int toBase62(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        return c - 'A' + 36;
    }

    public long getId(String shortUrl) {
        long id = 0;
        for (int i = 0; i < shortUrl.length(); ++i) {
            id = id * 62 + toBase62(shortUrl.charAt(i));
        }
        return id;
    }


    public String getKey(long id) {
        String short_url = "";
        int index = -1;
        while (id > 0) {
            index = (int) id % 62;
            short_url = table.charAt(index) + short_url;
            id = id / 62;
        }

        while (short_url.length() < length) {
            short_url = "0" + short_url;
        }

        return short_url;
    }
}
