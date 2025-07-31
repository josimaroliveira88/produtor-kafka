package br.com.exemplo.produtor.cache;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import io.quarkus.cache.CacheKeyGenerator;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomCacheKeyGenerator implements CacheKeyGenerator {

    @Override
    public Object generate(Method method, Object... methodParams) {
        return Arrays.stream(methodParams)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }


}
