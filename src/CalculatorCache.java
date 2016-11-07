import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * Created by Acer on 30.10.2016.
 */
public class CalculatorCache implements InvocationHandler {
    private final Map<List<Object>, Object> cache = new HashMap<>();
    private final Object delegate;

    private CalculatorCache(Object delegate) {
        this.delegate = delegate;
    }

    public static <T> T getProxy(T delegate) {
        return (T) Proxy.newProxyInstance(
                CalculatorCache.class.getClassLoader(),
                delegate.getClass().getInterfaces(),
                new CalculatorCache(delegate));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Annotation[] annotations = method.getAnnotations();
        if (annotations.length < 1)
            return method.invoke(delegate, args);
        Object result = null;
        if (method.getAnnotation(Cache.class) != null || method.getAnnotation(Save.class) != null) {
            List<Object> key = getKey(method, args);
            if (method.getAnnotation(Save.class) != null) {
                cache.clear();
            } else {
                result = cache.get(key);
            }
            if (result == null) {
                result = method.invoke(delegate, args);
                cache.put(key, result);
            }
        }
        return result;
    }

    private List<Object> getKey(Method method, Object[] args) {
        return new ArrayList<>(Arrays.asList(method, Arrays.asList(args)));
    }
}
