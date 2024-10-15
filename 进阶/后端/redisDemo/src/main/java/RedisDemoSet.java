import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDemoSet {

    public static void test1(Jedis jedis) {
        jedis.flushAll();

        jedis.sadd("key","111","222","333");

        System.out.println(jedis.smembers("key"));

    }

    public static void test2(Jedis jedis) {
        jedis.flushAll();

        jedis.sadd("key","111","222","333");

        System.out.println(jedis.sismember("key", "1"));

        System.out.println(jedis.scard("key"));

        System.out.println(jedis.spop("key"));
    }

    public static  void test3(Jedis jedis) {
        jedis.flushAll();

        jedis.sadd("key1","111","222","333","444");
        jedis.sadd("key2","111","222","333","555");

        System.out.println(jedis.sinter("key1", "key2"));

        jedis.sinterstore("key3","key1","key2");

        System.out.println(jedis.smembers("key3"));
    }

    public static void main(String[] args) {

        JedisPool jedisPool=new JedisPool("tcp://127.0.0.1:58080");

        try (Jedis jedis=jedisPool.getResource()){

//            test1(jedis);
//            test2(jedis);
            test3(jedis);
        }



    }


}
