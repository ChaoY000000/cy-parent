package demo.dubbo.impl;

import com.chao.note.leetcode.SortUtils;
import demo.dubbo.HelloService;

/**
 * Created by 15313 on 2020/6/9.
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHello(String name) {
        System.out.println("Hello , My name is " + name + " .");
    }
}
