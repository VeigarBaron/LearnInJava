package javabase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author VeigarBaron
 * @date 2020/8/7 11:16
 * @Description 测试方法类
 *
 */
public class TestJava extends TestFatherJava{

    private int anInt = 1;
    public String str = "strrrrr";
    private static int anInt2 = 2;
    public static String str2 = "strrrrr";

    public static void method() {
        // 不可以new
        TestJava testJava = new TestJava();
        System.out.println(testJava.anInt);
        System.out.println(anInt2);
        System.out.println(testJava.str);
        System.out.println(str2);
        System.out.println("qwer");
    }

    public static void main(String[] args) {
        TestJava testJava = new TestJava();
        String object = testJava.strJava;
        testJava.method();

        System.out.println(object);
        Map map = new HashMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Hashtable hashtable = new Hashtable();
        Collection collection;
        short s1 = 1;
        s1 += 1;

    }
}
