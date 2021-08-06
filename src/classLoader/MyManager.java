package classLoader;
/*
 * @author p78o2
 * @date 2021/7/30
 */


import java.time.LocalTime;

public class MyManager  implements BaseManager {
    @Override
    public void logic() {
        System.out.println(LocalTime.now() + ": Java类的热加载");
    }
}
