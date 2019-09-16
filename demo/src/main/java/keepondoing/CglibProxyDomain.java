package keepondoing;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

public class CglibProxyDomain implements MethodInterceptor {

  // CglibProxy 以拦截器方式实现代理
    private Enhancer enhancer = new Enhancer();
    //11
    @Transactional(propagation= Propagation.MANDATORY,rollbackFor = Exception.class)
    public Object getProxy(Class clazz) {
        //12 设置被代理类的Class对象
        enhancer.setSuperclass(clazz);
        //13 设置拦截器回调
        enhancer.setCallback( this);
        return enhancer.create();
    }

    //实际代理对象obj ，方法，参数
    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
          //增强。。
        //
        Object result = methodProxy.invokeSuper(obj, objects);
        return result;
    }
}
