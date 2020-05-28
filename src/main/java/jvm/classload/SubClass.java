package jvm.classload;

/**
 * @author: avenzhong
 * @create: 2020-05-27 13:22
 */
public class SubClass extends SuperClass{

    static {
        System.out.println("subClass init");
    }
}
