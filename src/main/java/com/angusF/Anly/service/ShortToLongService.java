package com.angusF.Anly.service;

import com.angusF.Anly.model.ShortToLong;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShortToLongService {
    private static final List<ShortToLong> shortList = new ArrayList<>();
    static {
        for (int i = 0; i < 10; i++) {
            shortList.add(new ShortToLong(i, "apiTestForShortToLong." + i));
        }
    }

    public List<ShortToLong> getAllShort() {
        return shortList;
    }
}
