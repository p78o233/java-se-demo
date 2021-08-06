package classLoaderUrl;
/*
 * @author p78o2
 * @date 2021/8/3
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    private int age;
    private String name;

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.say());
    }

    @Override
    public String toString() {
        return "Test{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Test() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String say(){
        return "oooo";
    }
}
