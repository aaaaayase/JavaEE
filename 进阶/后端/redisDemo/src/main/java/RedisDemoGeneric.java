import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

public class RedisDemoGeneric {

    public static void test1(Jedis jedis) {
        jedis.flushAll();
        jedis.set("key1","sds");
        jedis.set("key2","sdjhajs");

        System.out.println(jedis.get("key1"));
        System.out.println(jedis.get("key2"));

    }

    public static void test2(Jedis jedis) {
        jedis.flushAll();

        jedis.set("key1","dsa");
        jedis.set("key2","sdjshjd");
        jedis.set("key3","dsjhahdshjkahsjkhdjh");

        System.out.println(jedis.exists("key1"));

        System.out.println(jedis.del("key1","key2"));

        System.out.println(jedis.del("key3"));

    }

    public static void test3(Jedis jedis) {
        jedis.flushAll();

        jedis.set("key1","sdjhkja");
        jedis.set("key2","sdjhkja");
        jedis.set("key3","sdjhkja");

        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
    }

    public static void test4(Jedis jedis) throws InterruptedException {
        jedis.flushAll();

        jedis.set("key1","sdasda");

        jedis.expire("key1",10);

        Thread.sleep(3000);
        long key1 = jedis.ttl("key1");

        System.out.println(key1);
    }

    public static void test5(Jedis jedis) {
        jedis.flushAll();
        jedis.set("key1", "sdaj");

        jedis.hset("key2","jdsjj","sjjsd");

        jedis.lpush("key3","sdjshj");

        jedis.sadd("key4","sdjhj");

        jedis.zadd("key5",12787,"hdshjd");

        System.out.println(jedis.type("key1"));
        System.out.println(jedis.type("key2"));
        System.out.println(jedis.type("key3"));
        System.out.println(jedis.type("key4"));
        System.out.println(jedis.type("key5"));
    }

    public static void main(String[] args) {
        JedisPool jedisPool=new JedisPool("tcp://127.0.0.1:58080");
        try(Jedis jedis=jedisPool.getResource()) {

//            System.out.println(jedis.ping());

//            test1(jedis);
//            test2(jedis);
//            test3(jedis);

//            test4(jedis);

            test5(jedis);
        }

    }
}
