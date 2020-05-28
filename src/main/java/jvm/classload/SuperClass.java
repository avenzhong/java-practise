package jvm.classload;

/**
 * @author: avenzhong
 * @create: 2020-05-27 13:21
 */
public class SuperClass {

    static {
        System.out.println("superClass init");
    }
    public static int value = 123;
}
