package com.redisson;

import io.micrometer.core.instrument.util.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.redisson.config.SentinelServersConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * base sentinel redis
 * the config of redisson
 * @Author: PengMvc
 * @Date: 2022/05/27/15:53
 */
public class RedissonConfig {

    @Value("${spring.redis.sentinel.nodes}") private String nodes;

    @Value("${spring.redis.sentinel.master}") private String master;

    @Value("${spring.redis.sentinel.fail-max}") private int failMax;

    @Value("${spring.redis.pool.conn-timeout}") private int timeout;

    @Value("${ spring.redis.pool.size}") private int size;

    @Value("${spring.redis.password}") private String password;


    // the config of sentinel
    @Bean
    RedissonClient redissonSentinel() {
        Config config = new Config();
        String[] nodeStr = nodes.split(",");
        List<String> newNodes = new ArrayList(nodeStr.length);
        Arrays.stream(nodeStr).forEach((index) -> newNodes.add(
                index.startsWith("redis://") ? index : "redis://" + index));

        SentinelServersConfig serverConfig = config.useSentinelServers()
                .addSentinelAddress(newNodes.toArray(new String[0]))
                .setMasterName(master)
                .setReadMode(ReadMode.SLAVE)
                .setFailedAttempts(failMax)
                .setTimeout(timeout)
                .setMasterConnectionPoolSize(size)
                .setSlaveConnectionPoolSize(size);

        if (StringUtils.isNotBlank(password)) {
            serverConfig.setPassword(password);
        }
        return Redisson.create(config);
    }

}
