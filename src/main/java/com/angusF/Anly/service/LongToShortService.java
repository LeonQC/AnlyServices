package com.angusF.Anly.service;

import com.angusF.Anly.model.LongToShort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LongToShortService {
    private static final List<LongToShort> longList = new ArrayList<>();
    static {
        for (int i = 0; i < 10; i++) {
            longList.add(new LongToShort(i, "www.apiTestForLongToShort." + i + ".com"));
        }
    }

    public List<LongToShort> getAllLong() {
        return longList;
    }
}
