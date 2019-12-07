package cn.ctgu.javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheTest {
    @Autowired
    private CacheManager cacheManager;

//    public CacheTest(CacheManager cacheManager){
//        this.cacheManager=cacheManager;
//    }

    @GetMapping("/cache1")
    public void test1(){
        ConcurrentMapCache cache= (ConcurrentMapCache) cacheManager.getCache("people");

        for(int i=0;i<2;i++){
            cache.put("id"+i,i);
        }

        cache.evict("id0");


        System.out.println(cacheManager);
    }
    @GetMapping("/cache2/{id}")
    public void test2(@PathVariable int id){
        cacheManager.getCache("people").put("name"+id,id);

        System.out.println(cacheManager);
    }
}
