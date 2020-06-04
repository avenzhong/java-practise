package concurent.deadlock;

/**
 * @description
 * @author: zhongwenjian
 * @create: 2020-06-04 23:36
 */
public class Account {

    //通过破坏占有且等待条件避免死锁
    //通过allcator来实现一次性申请所有资源 转账示例
    //单例 只能由一个人来分配资源
    private Allocator allocator = Allocator.getInstance();
    private int balance;
    public Account(int balance){
        this.balance = balance;
    }
    // 一次性申请转出账户和转入账户，直到成功
    void transfer(Account target, int amt) {
        while(!allocator.apply(this, target)){};
        try {
            //锁定转出账户
            synchronized (this) {
                //锁定转入账户
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        System.out.println("账户a转出了"+amt +"余额为"+this.balance);
                        target.balance += amt;
                        System.out.println("账户b收到账户a的钱了"+amt+"余额为"+target.balance);
                    }
                }
            }
        } finally {
            allocator.free(this, target);
        }
    }

    public static void main(String[] args) {
        Account account = new Account(800);
        Account target = new Account(100);

        account.transfer(target,100);
    }
}
