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

    public boolean singleNumber(String s, String t) {
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //当前的映射值是否相同
            if (mapS[c1] != mapT[c2]) {
                System.out.println("f");
                return false;
            } else {
                //是否已经修改过，修改过就不需要再处理
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        System.out.println("t");
        return true;
    }

    public static void main(String[] args) {
        TestJava testJava = new TestJava();
        String a = "abadd";
        String b = "cddee";
        testJava.singleNumber(a,b);

    }
}
