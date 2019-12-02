package com.chao.note.designPattern;

/**
 * 桥接模式：
 *      核心思想：桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化。桥接的用意是：将抽象化与实现化解
 *      耦，使得二者可以独立变化，像我们常用的JDBC桥DriverManager一样，JDBC进行连接数据库的时候，在各个数据库
 *      之间进行切换，基本不需要动太多的代码，甚至丝毫不用动，原因就是JDBC提供统一接口，每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了。
 *
 * Created by 15313 on 2019/11/29.
 */
public class Bridge {
    public static void main(String[] args) {
        BridgeTest bridgeSourcebale = new MyBridge();

        SourceableBridge sourceSub1 = new SourceSub1();
        bridgeSourcebale.setSourceable(sourceSub1);
        bridgeSourcebale.method();

        SourceableBridge sourceSub2 = new SourceSub2();
        bridgeSourcebale.setSourceable(sourceSub2);
        bridgeSourcebale.method();
    }
}

interface SourceableBridge{
    public void method();
}

class SourceSub1 implements SourceableBridge{
    @Override
    public void method() {
        System.out.println("this is the first sub!");
    }
}

class SourceSub2 implements SourceableBridge{
    @Override
    public void method() {
        System.out.println("this is the second sub!");
    }
}

abstract class BridgeTest {
    private SourceableBridge sourceable;

    public void method() {
       sourceable.method();
    }

    public SourceableBridge getSourceable() {
        return sourceable;
    }
    public void setSourceable(SourceableBridge sourceable) {
        this.sourceable = sourceable;
    }
}

class MyBridge extends BridgeTest{
    public void method(){
        getSourceable().method();
    }
}