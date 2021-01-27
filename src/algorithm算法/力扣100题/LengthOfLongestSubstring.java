package algorithm算法.力扣100题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author VeigarBaron
 * @date 2021/1/27 17:27
 * @Description *
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int a = 0, b = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++){
            char cc = chars[i];
            if (hashMap.get(cc) == null){
            } else {
                b = hashMap.get(cc);
                if (hashMap.size() - b > a)
                    a = hashMap.size() - b;
            }
        }
        return a;
    }
}
