import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RedisDemoHash {

    public static void test1(Jedis jedis) {
        jedis.flushAll();

        jedis.hset("key", "f", "111");
        String hget = jedis.hget("key", "f");

        System.out.println(hget);

    }

    public static void test2(Jedis jedis) {
        jedis.flushAll();

        jedis.hset("key","f","111");

        System.out.println(jedis.hexists("key", "f"));
        System.out.println(jedis.hdel("key","f"));
        System.out.println(jedis.hexists("key", "f"));

    }

    public static void test3(Jedis jedis) {
        jedis.flushAll();

        jedis.hset("key","f1","111");
        jedis.hset("key","f2","222");
        jedis.hset("key","f3","333");

        Set<String> key = jedis.hkeys("key");
        System.out.println(key);
        System.out.println(jedis.hvals("key"));


    }

    public static void test4(Jedis jedis) {
        jedis.flushAll();

        jedis.hset("key","f1","111");

        Map<String,String> map=new HashMap<>();
        map.put("f2","222");
        map.put("f3","223");
        map.put("f4","224");
        map.put("f5","225");

        jedis.hmset("key",map);

        System.out.println(jedis.hmget("key","f1","f2","f3","f4","f5"));

    }

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool("tcp://127.0.0.1:58080");

        try (Jedis jedis = jedisPool.getResource()) {
//            test1(jedis);
//                test2(jedis);
//test3(jedis);

        test4(jedis);
        }


    }


}
