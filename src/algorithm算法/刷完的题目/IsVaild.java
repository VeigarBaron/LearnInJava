package algorithm算法.刷完的题目;

import java.util.*;

/**
 * @author VeigarBaron
 * @date 2021/1/28 14:59
 * @Description *
 */
public class IsVaild {

    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 > 0)
            return false;

        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++){
            char tempChar = s.charAt(i);
            char res = hashMap.get(tempChar);
            if (hashMap.containsKey(tempChar)){
                if (stack.isEmpty() || res == stack.peek()) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(tempChar);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsVaild isVaild = new IsVaild();
        isVaild.isValid("(]");
    }
}
