package demo.dubbo;

/**
 * Created by 15313 on 2020/6/9.
 */
public class DubboTest {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(HelloService.class);
        HelloService proxyObject = factory.getProxyObject();
        proxyObject.sayHello("Chao Yong");
    }
}
