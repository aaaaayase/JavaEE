import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class RedisDemoList {

    public static void test1(Jedis jedis) {
        jedis.flushAll();

        jedis.lpush("key", "111", "222", "333", "444");

        List<String> key = jedis.lrange("key", 0, -1);
        System.out.println(key);


    }

    public static void test2(Jedis jedis) {
        jedis.flushAll();

        jedis.rpush("key", "111", "222", "333");

        List<String> key = jedis.lrange("key", 0, -1);

        System.out.println(key);
    }

    public static void test3(Jedis jedis) {
        jedis.flushAll();
        jedis.rpush("key", "111", "222", "333", "444");

        System.out.println(jedis.llen("key"));


        System.out.println(jedis.lpop("key"));
        System.out.println(jedis.rpop("key"));
    }

    public static void test4(Jedis jedis) {
        jedis.flushAll();
        jedis.lpush("key","111");
        jedis.lpop("key");
        System.out.println(jedis.blpop(100, "key"));
    }

    public static void main(String[] args) {

        JedisPool jedisPool = new JedisPool("tcp://127.0.0.1:58080");

        try (Jedis jedis = jedisPool.getResource()) {

            //            test1(jedis);
//            test2(jedis);

//            test3(jedis);

            test4(jedis);
        }

    }

}
