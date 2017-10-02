package cachefun;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableCaching
public class CachingConfig {
    //애너테이션 주도 캐싱
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    //EhCache 캐싱
    @Bean
    public EhCacheCacheManager ehCacheManager(net.sf.ehcache.CacheManager cacheManager) {
        return new EhCacheCacheManager(cacheManager);
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();

        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource(""));

        return ehCacheManagerFactoryBean;
    }

    //다중 캐시 매니저 선언
    @Bean
    public CacheManager cacheManager(net.sf.ehcache.CacheManager cm,
                                     javax.cache.CacheManager jcm) {
        CompositeCacheManager cacheManager = new CompositeCacheManager();
        List<CacheManager> managers = new ArrayList<CacheManager>();

        managers.add(new JCacheCacheManager(jcm));
        managers.add(new EhCacheCacheManager(cm));

        cacheManager.setCacheManagers(managers);

        return cacheManager;
    }
}
