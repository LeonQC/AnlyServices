package com.angusF.Anly.service.impl;

import com.angusF.Anly.data.Base62Repository;
import com.angusF.Anly.model.Base62Url;
import com.angusF.Anly.service.AnlyService;
import com.angusF.Anly.util.UrlValidation;
import com.angusF.Anly.util.encode.Base62Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@Service("base62")
public class Base62Service implements AnlyService {
    private final Base62Repository base62Repository;

    public Base62Service(Base62Repository base62Repository) {
        this.base62Repository = base62Repository;
    }

    @Autowired
    @Qualifier("counterScript")
    private DefaultRedisScript<Long> redisCounterScript;

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, Long> sequenceIdRedisTemplate;

    private Long getNextSequenceIdByLua() {
        List<String> keys = new ArrayList<>();
        keys.add("GLOBAL_SEQUENCE_ID");
        return sequenceIdRedisTemplate.execute(redisCounterScript, keys);
    }

    @Autowired
    UrlValidation urlValidation;

    @Autowired
    Base62Encode encodeUtil;

    @Cacheable(cacheNames = "bs_lts", key = "#longUrl")
    @Override
    public String longUrlHandler(String longUrl) throws Exception {
        if (!urlValidation.isValidUrl(longUrl)) {
            throw new MalformedURLException();
        }
        Base62Url base62Url = base62Repository.getByLongUrl(longUrl);
        if (base62Url != null) {
            return encodeUtil.getKey(base62Url.getId());
        }

        long currentId = getNextSequenceIdByLua();
        String key = encodeUtil.getKey(currentId);

        base62Repository.saveAndFlush(new Base62Url(currentId, longUrl));
        return key;
    }

    @Cacheable(cacheNames = "bs_stl", key = "#key")
    @Override
    public String shortUrlHandler(String key) throws Exception{
        long id = encodeUtil.getId(key);
        Base62Url base62Url = base62Repository.getById(id);
        if (base62Url == null) {
            return null;
        }
        return base62Url.getLongUrl();
    }
}
