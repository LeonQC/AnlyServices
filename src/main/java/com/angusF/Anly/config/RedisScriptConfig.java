package com.angusF.Anly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

@Configuration
public class RedisScriptConfig {
//    @Bean
//    public RedisScript<Long> counterScript() {
//        Resource scriptSource = new ClassPathResource("redisCounter.lua");
//        return RedisScript.of(scriptSource, Long.class);
//    }

    @Bean
    public DefaultRedisScript<Long> counterScript() {
        DefaultRedisScript<Long> script = new DefaultRedisScript<>();
        script.setResultType(Long.class);
        script.setScriptSource(new ResourceScriptSource(new ClassPathResource("redisCounter.lua")));
        return script;
    }
}

