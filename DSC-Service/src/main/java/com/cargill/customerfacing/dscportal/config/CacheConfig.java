package com.cargill.customerfacing.dscportal.config;

/**
 * Created by manikandanprabhu on 11/10/17.
 */
import com.google.common.cache.CacheBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    public final static String CACHE_ONE = "cacheOne";
    public final static String CACHE_TWO = "cacheTwo";
    public final static String CACHE_THREE = "cacheThree";
    public final static String CACHE_FOUR = "cacheFour";
    public final static String CACHE_FIVE = "cacheFive";
    public final static String CACHE_SIX = "cacheSix";
    public final static String CACHE_SEVEN = "cacheSeven";
    public final static String CACHE_EIGHT = "cacheEight";
    public final static String CACHE_NINE = "cacheNine";
    public final static String CACHE_TEN= "cacheTEN";
    public final static String CACHE_STATIC= "cache-static";
    public final static String CACHE_STATIC_CROPS= "cache-static-crops";

    @Bean
    public Cache cacheOne() {
        return new GuavaCache(CACHE_ONE, CacheBuilder.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build());
    }

    @Bean
    public Cache cacheTwo() {
        return new GuavaCache(CACHE_TWO, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build());
    }

    @Bean
    public Cache cacheThree() {
        return new GuavaCache(CACHE_THREE, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build());
    }

    @Bean
    public Cache cacheFour() {
        return new GuavaCache(CACHE_FOUR, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build());
    }

    @Bean
    public Cache cacheFive() {
        return new GuavaCache(CACHE_FIVE, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build());
    }

    @Bean
    public Cache cacheSix() {
        return new GuavaCache(CACHE_SIX, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build());
    }

    @Bean
    public Cache cacheSeven() {
        return new GuavaCache(CACHE_SEVEN, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build());
    }

    @Bean
    public Cache cacheEight() {
        return new GuavaCache(CACHE_EIGHT, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build());
    }

    @Bean
    public Cache cacheNine() {
        return new GuavaCache(CACHE_NINE, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build());
    }

    @Bean
    public Cache cacheTen() {
        return new GuavaCache(CACHE_TEN, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build());
    }

    @Bean
    public Cache cacheStatic() {
        return new GuavaCache(CACHE_STATIC, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.HOURS)
                .build());
    }

    @Bean
    public Cache cacheStaticCrops() {
        return new GuavaCache(CACHE_STATIC_CROPS, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.HOURS)
                .build());
    }

}