package jvm.classload;

/**
 * @author: avenzhong
 * @create: 2020-05-27 13:23
 */
public class NotInitialization {

    public static void main(String[] args) {
        int a = SuperClass.value;
//        SubClass subClass = new SubClass();
//        System.out.println(SubClass.value);
    }
}
