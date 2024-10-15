package com.yun.springredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class MyController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/testString")
    public String testString() {

        redisTemplate.opsForValue().set("key1", "111");
        redisTemplate.opsForValue().set("key2", "222");
        redisTemplate.opsForValue().set("key3", "333");

        System.out.println(redisTemplate.opsForValue().get("key1"));
        System.out.println(redisTemplate.opsForValue().get("key2"));
        System.out.println(redisTemplate.opsForValue().get("key3"));


        return "OK";
    }

    @RequestMapping("/testList")
    public String testList() {
        redisTemplate.execute((RedisConnection redisConnection) -> {
            redisConnection.flushAll();
            return null;
        });


        redisTemplate.opsForList().leftPush("key1", "111");
        redisTemplate.opsForList().leftPush("key1", "112");
        redisTemplate.opsForList().leftPush("key1", "113");
        redisTemplate.opsForList().leftPush("key1", "114");

        System.out.println(redisTemplate.opsForList().rightPop("key1"));
        System.out.println(redisTemplate.opsForList().rightPop("key1"));
        System.out.println(redisTemplate.opsForList().rightPop("key1"));
        System.out.println(redisTemplate.opsForList().rightPop("key1"));
        return "OK";
    }

    @RequestMapping("/testSet")
    public String testSet() {
        redisTemplate.execute((RedisConnection connection) -> {
            connection.flushAll();
            return null;
        });

        redisTemplate.opsForSet().add("key", "111", "222", "333");

        System.out.println(redisTemplate.opsForSet().members("key"));
        System.out.println(redisTemplate.opsForSet().isMember("key", "111"));
        System.out.println(redisTemplate.opsForSet().size("key"));
        System.out.println(redisTemplate.opsForSet().remove("key", "111", "222"));
        System.out.println(redisTemplate.opsForSet().size("key"));

        return "OK";
    }

    @RequestMapping("/testHash")
    public String testHash() {
        redisTemplate.execute((RedisConnection redisConnection) -> {
            redisConnection.flushAll();
            return null;
        });

        redisTemplate.opsForHash().put("key", "f1", "111");
        redisTemplate.opsForHash().put("key", "f2", "112");
        redisTemplate.opsForHash().put("key", "f3", "113");
        redisTemplate.opsForHash().put("key", "f4", "114");

        System.out.println(redisTemplate.opsForHash().get("key", "f1"));
        System.out.println(redisTemplate.opsForHash().delete("key", "f1"));
        System.out.println(redisTemplate.opsForHash().hasKey("key", "f2"));
        System.out.println(redisTemplate.opsForHash().size("key"));

        return "OK";
    }

    @RequestMapping("/testZSet")
    public String testZSet() {

        redisTemplate.execute((RedisConnection connection) -> {
            connection.flushAll();

            return null;

        });

        redisTemplate.opsForZSet().add("key", "zhangsan", 10);
        redisTemplate.opsForZSet().add("key", "lisi", 20);
        redisTemplate.opsForZSet().add("key", "wangwu", 30);
        redisTemplate.opsForZSet().add("key", "zhaoliu", 40);

        System.out.println(redisTemplate.opsForZSet().size("key"));
        System.out.println(redisTemplate.opsForZSet().range("key", 0, -1));
        Set<ZSetOperations.TypedTuple<String>> key = redisTemplate.opsForZSet().rangeWithScores("key", 0, -1);
        System.out.println(key);
        System.out.println(redisTemplate.opsForZSet().score("key", "lisi"));

        System.out.println(redisTemplate.opsForZSet().remove("key", "zhangsan", "wangwu"));

        System.out.println(redisTemplate.opsForZSet().range("key", 0, -1));

        return "OK";
    }
}
