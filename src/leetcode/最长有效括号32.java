package leetcode;

import javax.sound.midi.Soundbank;
import java.util.ServiceLoader;

/**
 * @author VeigarBaron
 * @date 2020/8/27 10:57
 * @Description *
 */
public class 最长有效括号32 {
    public int longestValidParentheses(String s) {

        int res = 0;
        int lz = 0,ly = 0;
        for (char c : s.toCharArray()){
            if ('('== c){
                lz += 1;
            }
            if (')' == c){
                ly += 1;
            }
        }
        int i = Math.min(lz, ly);
        for (; i > 0 ;i --){
           if(s.contains("()")){
               res += 1;
               s = s.substring(s.indexOf("()")) + s.substring(0, s.indexOf("()"));
           }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        最长有效括号32 Z =new 最长有效括号32();
        Z.longestValidParentheses(")()())");
    }
}
