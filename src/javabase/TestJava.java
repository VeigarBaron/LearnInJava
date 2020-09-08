package javabase;

/**
 * @author VeigarBaron
 * @date 2020/8/7 11:16
 * @Description 测试方法类
 *
 */
public class TestJava extends TestFatherJava{

    public int compareVersion(String version1, String version2) {
        return 0;
    }

    public static void main(String[] args) {
        TestJava testJava = new TestJava();
        int a = testJava.compareVersion("0.1","1.1");
        System.out.println("a:" + a);
    }
}
