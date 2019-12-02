package com.chao.note.designPattern;

/**
 * 适配器模式
 * 1. 类的适配器模式
 *      核心思想：有一个Source类，拥有一个方法，待适配
 * 2. 对象的适配器模式
 * 3. 接口的适配器模式
 *      核心思想：有时我们写的一个接口中有多个抽象方法，当我们写该接口的实现类时，必须实现该接口的所有方法，
 *          这明显有时比较浪费，因为并不是所有的方法都是我们需要的，有时只需要某一些，此处为了解决这个问题，
 *          我们引入了接口的适配器模式，借助于一个抽象类，该抽象类实现了该接口，实现了所有的方法，而我们不和
 *          原始的接口打交道，只和该抽象类取得联系，所以我们写一个类，继承该抽象类，重写我们需要的方法就行。
 *
 * Created by 15313 on 2019/11/28.
 */
public class Adapter {

    public static void main(String[] args) {
//        1. 类的适配器模式
//        Targetable adapterClass = new AdapterClass();
//        adapterClass.method1();
//        adapterClass.method2();

//        2. 对象的适配器模式
//        Targetable adapterObject = new AdapterObject(new Soruce());
//        adapterObject.method1();
//        adapterObject.method2();


//        3. 接口的适配器模式
        Targetable adapterInterface1 = new AdapterInterface1();
        Targetable adapterInterface2 = new AdapterInterface2();

        adapterInterface1.method1();
        adapterInterface1.method2();

        adapterInterface2.method1();
        adapterInterface2.method2();
    }
}


/**
 * 1. 类的适配器模式
 */
class Soruce{
    public void method1(){
        System.out.println("this is Soruce method!");
    }
}

interface Targetable{
    void method1();
    void method2();
}

class AdapterClass extends Soruce implements Targetable{
    @Override
    public void method2() {
        System.out.println("this is Targetable method!");
    }
}


/**
 * 2. 对象的适配器模式
 */
class AdapterObject implements Targetable{

    private Soruce soruce;

    public AdapterObject(Soruce soruce) {
        this.soruce = soruce;
    }

    @Override
    public void method1() {
        soruce.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is Targetable method!");
    }
}


/**
 * 3. 接口的适配器模式
 */
abstract class AdapterAbstract implements Targetable{
    @Override
    public void method1() {}
    @Override
    public void method2() {}
}

class AdapterInterface1 extends AdapterAbstract{
    @Override
    public void method2() {
        System.out.println("the sourceable interface's second Sub2!");
    }
}

class AdapterInterface2 extends AdapterAbstract{
    @Override
    public void method1() {
        System.out.println("the sourceable interface's first Sub1!");
    }
}