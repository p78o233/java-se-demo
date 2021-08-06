package classLoader;
/*
 * @author p78o2
 * @date 2021/7/30
 */

public class ClassLoaderTest {
    public static void main(String[] args) {
        new Thread(new MsgHandler()).start();
    }
}
