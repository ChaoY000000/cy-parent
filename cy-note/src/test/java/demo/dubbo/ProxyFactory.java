package demo.dubbo;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 15313 on 2020/6/9.
 */
public class ProxyFactory implements InvocationHandler {

    private Class interfaceClass;

    public ProxyFactory(Class interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public <T> T getProxyObject(){
        System.out.println("This is Proxy getProxyObject.");
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{interfaceClass},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
//        method.invoke(proxy, args);
        System.out.println("This is Proxy Invoke.");
        return null;
    }
}
