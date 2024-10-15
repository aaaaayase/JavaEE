import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class RedisDemoString {

    public static void test1(Jedis jedis) {
        jedis.flushAll();

        jedis.mset("key1","sdjhs","key2","sdjhshdjhjk","key3","dsjkjhdjh");

        List<String> mget = jedis.mget("key1", "key2", "key3");

        mget.forEach(System.out::println);

    }

    public static void test2(Jedis jedis) {
        jedis.flushAll();

        jedis.set("key","iin");

        long key1 = jedis.setrange("key1", 2, "gogogo!!!!");
        System.out.println(jedis.get("key1"));
        String str=jedis.getrange("key1",2,-1);
        System.out.println(str);
    }

    public static void test3(Jedis jedis) {
        jedis.flushAll();
        jedis.set("key1","1");
        System.out.println(jedis.get("key1"));

        jedis.append("key1","122");
        System.out.println(jedis.get("key1"));

        jedis.incr("key1");
        System.out.println(jedis.get("key1"));
        jedis.decrBy("key1",222);
        System.out.println(jedis.get("key1"));







    }

    public static void main(String[] args) {

        JedisPool jedisPool =new JedisPool("tcp://127.0.0.1:58080");

        try(Jedis jedis=jedisPool.getResource()) {

//            test1(jedis);
//            test2(jedis);
                test3(jedis);
        }


    }
}
