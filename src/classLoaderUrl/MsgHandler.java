package classLoaderUrl;
/*
 * @author p78o2
 * @date 2021/7/30
 */


import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

class MsgHandler {
    public void run() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
        while (true) {
//            有优先级，在本地有同名的会覆盖来源于url的，所以运行的时候要把同项目的Test类去掉，jar部署在服务器里面
            URL[] urls = new URL[]{new URL("http://127.0.0.1:7001/public/upload/java-se-demo.jar")};
            URLClassLoader classLoader = new URLClassLoader(urls);
            //加载类以后就可以得到 Class 对象了
            Class<?> clazz = classLoader.loadClass("classLoaderUrl.Test");
            classLoader.close();  //加载完类以后就可以删除了。
            //关闭 classLoader， 否则会造成 资源泄露  Resource leak
            //这里不使用默认的构造器，使用带参数的构造器 获取特殊的构造器
            Constructor<?> con = clazz.getDeclaredConstructor(int.class, String.class );
            //使用构造器创建对象
            Object ob = con.newInstance( 12, "123");
            //在调用 test 对象的 say 方法，返回对 Dog 对象自己的描述
            Method mtd0 = clazz.getMethod("say", new Class<?>[]{});
            String testSay = (String) mtd0.invoke(ob, new Object[]{});
            System.out.println(testSay);
            urls = null;
            try{
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
