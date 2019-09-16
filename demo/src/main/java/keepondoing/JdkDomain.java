package keepondoing;

import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理方式实现切面，代理对象和目标对象没直接关系；getproxy方法获得代理对象后调用目标对象方法
 */
public class JdkDomain implements InvocationHandler {

    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        System.out.println("日志后置增强");

        return result;
    }

    public JdkDomain(Object target) {
        super();
        this.target = target;
    }

    public Object getProxy(){
        //4
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}
