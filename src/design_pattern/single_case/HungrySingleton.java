package design_pattern.single_case;
/*
 * @author p78o2
 * @date 2021/6/29
 */
//单例-饿汉模式
//饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。
public class HungrySingleton {
    public static void main(String[] args) {
        Presidentt zt1 = Presidentt.getInstance();
        zt1.getName();    //输出总统的名字
        Presidentt zt2 = Presidentt.getInstance();
        zt2.getName();    //输出总统的名字
        if (zt1 == zt2) {
            System.out.println("他们是同一人！");
        } else {
            System.out.println("他们不是同一人！");
        }
    }
}
class Presidentt {
    private static final Presidentt instance = new Presidentt();    //保证instance在所有线程中同步
    //private避免类在外部被实例化
    private Presidentt() {
        System.out.println("产生一个总统！");
    }
    public static synchronized Presidentt getInstance() {
        return instance;
    }
    public void getName() {
        System.out.println("我是美国总统：特朗普。");
    }
}
