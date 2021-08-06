package design_pattern.prototype;
/*
 * @author p78o2
 * @date 2021/6/29
 */

import java.io.*;

public class DeepCopy implements Serializable {
    private int num;
    private String name;

    public DeepCopy(int num, String name) {
        this.num = num;
        this.name = name;
    }

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

    public Object deepClone() throws IOException, OptionalDataException, ClassNotFoundException {
        // 将对象写到流里
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);
        // 从流里读出来
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
    }
}

class Test {
    public static void main(String[] args) throws  OptionalDataException, IOException, ClassNotFoundException  {
        DeepCopy obj1 = new DeepCopy(1, "p78o2");
        DeepCopy obj2 = (DeepCopy) obj1.deepClone();
        System.out.println(obj1.getNum()+"============"+obj2.getNum());
        obj1.setNum(2);
        System.out.println(obj1.getNum()+"============"+obj2.getNum());
    }
}
