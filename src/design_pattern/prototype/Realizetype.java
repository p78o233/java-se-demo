package design_pattern.prototype;
/*
 * @author p78o2
 * @date 2021/6/29
 */
//Java 中的 Object 类提供了浅克隆的 clone() 方法，具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆，
// 这里的 Cloneable 接口就是抽象原型类。其代码如下：
//创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
public class Realizetype implements Cloneable{
    private int num;
    private String name;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Realizetype(int num, String name) {
        this.num = num;
        this.name = name;
        System.out.println("具体原型创建成功！");
    }

    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Realizetype) super.clone();
    }
}
//原型模式的测试类
class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype obj1 = new Realizetype(1,"p78o2");
        Realizetype obj2 = (Realizetype) obj1.clone();
        System.out.println(obj1.getNum()+"============"+obj2.getNum());
        obj1.setNum(2);
        System.out.println(obj1.getNum()+"============"+obj2.getNum());
    }
}
