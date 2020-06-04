package concurent.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: zhongwenjian
 * @create: 2020-06-04 23:31
 */
public class Allocator {
    //使用静态内部类实现单例
    private static class SingletonHolder{
        private static final Allocator allocator = new Allocator();
    }
    public static Allocator getInstance(){
        return SingletonHolder.allocator;
    }
    private List<Object> arl = new ArrayList<Object>();
    //一次性申请所有资源
    synchronized boolean apply(Object from, Object to) {
        if (arl.contains(from) || arl.contains(to)){
            return false;
        }else {
            arl.add(from);
            arl.add(to);
        }
        return true;
    }

    //归还资源
    synchronized void free(Object from, Object to){
        arl.remove(from);
        arl.remove(to);
    }
}
