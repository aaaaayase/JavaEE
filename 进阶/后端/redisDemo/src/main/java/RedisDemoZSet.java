import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.ZAddParams;
import redis.clients.jedis.resps.Tuple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisDemoZSet {

    public static void test1(Jedis jedis) {

        jedis.flushAll();

        jedis.zadd("key", 10, "zhangsan");

        Map<String, Double> map = new HashMap<>();

        map.put("lisi", 20.0);
        map.put("wangwu", 30.0);
        map.put("zhaoliu", 40.0);

        jedis.zadd("key", map);

        System.out.println(jedis.zrange("key", 0, -1));

        List<Tuple> key = jedis.zrangeWithScores("key", 0, -1);
        System.out.println(key);
    }

    public static void test2(Jedis jedis) {
        jedis.flushAll();

        jedis.zadd("key", 0, "zhangsan");
        jedis.zadd("key", 10, "lisi");


        System.out.println(jedis.zcard("key"));

        jedis.zrem("key", "zhangsan");

        System.out.println(jedis.zcard("key"));


    }

    public static void test3(Jedis jedis){
        jedis.flushAll();

        jedis.zadd("key",10,"zhangsan");
        jedis.zadd("key",30,"wangwu");
        jedis.zadd("key",20,"zhaosi");

        System.out.println(jedis.zscore("key", "zhangsan"));
        System.out.println(jedis.zrank("key","wangwu"));
        System.out.println(jedis.zrank("key", "zhangsan"));
    }

    public static void main(String[] args) {

        JedisPool jedisPool = new JedisPool("tcp://127.0.0.1:58080");

        try (Jedis jedis = jedisPool.getResource()) {

//            test1(jedis);
//            test2(jedis);
            test3(jedis);

        }



    }

}
