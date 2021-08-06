package classLoaderUrl;
/*
 * @author p78o2
 * @date 2021/7/30
 */

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
        MsgHandler handler = new MsgHandler();
        handler.run();
    }
}
