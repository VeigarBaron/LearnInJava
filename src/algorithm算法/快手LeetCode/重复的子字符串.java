package algorithm算法.快手LeetCode;

/**
 * @author VeigarBaron
 * @date 2020/9/7 14:12
 * @Description *
 */
public class 重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
