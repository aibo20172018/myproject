package util;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class ThreadLocals {
    private static ThreadLocal<Map<Object, Object>> threadLocal = new ThreadLocal<>();

    public static final void init(Map<Object, Object> map) {
        threadLocal.set(map);
    }

    public static final void destroy() {
        threadLocal.remove();
    }

    public static final Object put(Object key, Object value) {
        Map<Object, Object> m = getMap();
        return m.put(key, value);
    }

    public static final <T> T put(T value) {
        return (T) put(value.getClass(), value);
    }

    public static final Object get(Object key) {
        Map<Object, Object> m = getMap();
        return m.get(key);
    }

    public static final <T> T get(Class<T> key) {
        Map<Object, Object> m = getMap();
        return (T) m.get(key);
    }

    public static final Object get(Object key, Function<Object, Object> valueFunction) {
        Map<Object, Object> m = getMap();
        return m.computeIfAbsent(key, valueFunction);
    }

    private static final Map<Object, Object> getMap() {
        Map<Object, Object> m = threadLocal.get();
        return Optional.ofNullable(m).orElse(new HashMap());
    }
}
