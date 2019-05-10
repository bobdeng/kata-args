package cn.bobdeng.utils.args;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class ValueConverterFactory {
    public static Map<Class, Function<String, Object>> converters=new HashMap<>();

    static {
        converters.put(String.class, (str) -> str);
        converters.put(Integer.class, Integer::new);
        converters.put(Boolean.class, (str) -> "true".equalsIgnoreCase(str));
    }

    public static Object parseObject(String value, Class clz){
        return Optional.ofNullable(converters.get(clz))
                .map(converter -> converter.apply(value))
                .orElse(null);
    }
}
